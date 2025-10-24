package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class UserPostgreSqlDAO extends SqlConnection implements UserDAO {

    public UserPostgreSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO \"user\"(");
        sql.append("id, identificationType, identificationNumber, firstName, secondName, ");
        sql.append("firstSurname, secondSurname, homeCity, email, ");
        sql.append("mobileNumber, emailConfirmed, mobileNumberConfirmed) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdentificationType().getId());
            preparedStatement.setObject(3, entity.getIdentificationNumber());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getSecondName());
            preparedStatement.setString(6, entity.getFirstSurname());
            preparedStatement.setString(7, entity.getSecondSurname());
            preparedStatement.setObject(8, entity.getHomeCity().getId());
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setString(10, entity.getMobileNumber());
            preparedStatement.setBoolean(11, entity.isEmailConfirmed());
            preparedStatement.setBoolean(12, entity.isMobileNumberConfirmed());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_REGISTERING_ENTITY.getContent() ;
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_REGISTERING_ENTITY.getContent() + " User " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_ENTITY.getContent() + " User " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        return findByFilter(new UserEntity());
    }

    @Override
    public List<UserEntity> findByFilter(final UserEntity filterEntity) {
        var parametersList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parametersList);
        try(var preparedStatement = this.getConnection().prepareStatement(sql)){
            for(int index = 0; index < parametersList.size(); index++){
                preparedStatement.setObject(index+1,parametersList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);
        } catch (final NoseException exception){
            throw exception;
        } catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_ENTITY_WHILE_EXECTUION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_ENTITY_WHILE_EXECTUION.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY_WHILE_EXECUTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY_WHILE_EXECUTION.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final UserEntity filterEntity, final List<Object> parametersList) {
        final var sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  u.\"id\" AS \"userId\", ");
        sql.append("  it.\"id\" AS \"identificationTypeId\", ");
        sql.append("  it.\"name\" AS \"identificationTypeName\", ");
        sql.append("  u.\"identificationType\" AS \"identificationType\", ");
        sql.append("  u.\"identificationNumber\" AS \"identificationNumber\", ");
        sql.append("  u.\"firstName\" AS \"firstName\", ");
        sql.append("  u.\"secondName\" AS \"secondName\", ");
        sql.append("  u.\"firstSurname\" AS \"firstSurname\", ");
        sql.append("  u.\"secondSurname\" AS \"secondSurname\", ");
        sql.append("  c.\"id\" AS \"homeCityId\", ");
        sql.append("  c.\"name\" AS \"homeCityName\", ");
        sql.append("  s.\"id\" AS \"homeStateId\", ");
        sql.append("  s.\"name\" AS \"homeStateName\", ");
        sql.append("  co.\"id\" AS \"homeCountryId\", ");
        sql.append("  co.\"name\" AS \"homeCountryName\", ");
        sql.append("  u.\"email\" AS \"email\", ");
        sql.append("  u.\"mobileNumber\" AS \"mobileNumber\", ");
        sql.append("  u.\"emailConfirmed\" AS \"emailConfirmed\", ");
        sql.append("  u.\"mobileNumberConfirmed\" AS \"mobileNumberConfirmed\", ");
        sql.append("  u.\"homeCity\" AS \"homeCity\" ");
        sql.append("FROM \"user\" AS u ");
        sql.append("INNER JOIN \"identificationType\" AS it ");
        sql.append("  ON u.\"identificationType\" = it.\"id\" ");
        sql.append("INNER JOIN \"city\" AS c ");
        sql.append("  ON u.\"homeCity\" = c.\"id\" ");
        sql.append("INNER JOIN \"state\" AS s ");
        sql.append("  ON c.\"state\" = s.\"id\" ");
        sql.append("INNER JOIN \"country\" AS co ");
        sql.append("  ON s.\"country\" = co.\"id\" ");

        createWhereClauseFindByFilter(sql, parametersList, filterEntity);
        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final UserEntity filterEntity){
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UserEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "u\"id\" = ", filterEntityValidated.getId());

        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getIdentificationType().getId()),
                "u.\"identificationType\" = ", filterEntityValidated.getIdentificationType().getId());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getIdentificationNumber()),
                "u.\"identificationNumber\" = ", filterEntityValidated.getIdentificationNumber());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstName()),
                "u.\"firstName\" = ", filterEntityValidated.getFirstName());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondName()),
                "u.\"secondName\" = ", filterEntityValidated.getSecondName());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstSurname()),
                "u.\"firstSurname\" = ", filterEntityValidated.getFirstSurname());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondSurname()),
                "u.\"secondSurname\" = ", filterEntityValidated.getSecondSurname());

        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getHomeCity().getId()),
                "u.\"homeCity\" = ", filterEntityValidated.getHomeCity().getId());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getEmail()),
                "u.\"email\" = ", filterEntityValidated.getEmail());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getMobileNumber()),
                "u.\"mobileNumber\" = ", filterEntityValidated.getMobileNumber());

        addCondition(conditions, parametersList, !filterEntityValidated.isEmailConfirmedIsDefaultValue(),
                "u.\"emailConfirmed\" = ", filterEntityValidated.isEmailConfirmed());

        addCondition(conditions, parametersList, !filterEntityValidated.isMobileNumberConfirmedIsDefaultValue(),
                "u.\"mobileNumberConfirmed\" = ", filterEntityValidated.isMobileNumberConfirmed());

        if(conditions.isEmpty()){
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parametersList, final boolean condition,
                              final String clause , final Object value){
        if (condition) {
            conditions.add(clause + "?");
            parametersList.add(value);
        }
    }

    private List<UserEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){
        var users =  new ArrayList<UserEntity>();
        try (var resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                var identificationType = new IdentificationTypeEntity();
                identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("identificationTypeId")));
                identificationType.setName(resultSet.getString("identificationTypeName"));

                var country = new CountryEntity();
                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("homeCountryId")));
                country.setName(resultSet.getString("homeCountryName"));

                var state = new StateEntity();
                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("homeStateId")));
                state.setName(resultSet.getString("homeStateName"));

                var city = new CityEntity();
                city.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("homeCityId")));
                city.setName(resultSet.getString("homeCityName"));
                city.setState(state);

                var user = new UserEntity();
                user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("userId")));
                user.setIdentificationType(identificationType);
                user.setIdentificationNumber(resultSet.getString("identificationNumber"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setFirstSurname(resultSet.getString("firstSurname"));
                user.setSecondSurname(resultSet.getString("secondSurname"));
                user.setHomeCity(city);
                user.setEmail(resultSet.getString("email"));
                user.setMobileNumber(resultSet.getString("mobileNumber"));
                user.setEmailConfirmed(resultSet.getBoolean("emailConfirmed"));
                user.setMobileNumberConfirmed(resultSet.getBoolean("mobileNumberConfirmed"));

                users.add(user);
            }
            } catch (final SQLException exception){
                var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_ENTITY_WHILE_EXECTUION.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_ENTITY_WHILE_EXECTUION.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
                throw NoseException.create(exception, userMessage, technicalMessage);
            } catch (final Exception exception){
                var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY_WHILE_EXECUTION.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY_WHILE_EXECUTION.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        return users;
        }


    @Override
    public UserEntity findById(final UUID id) {

        return findByFilter(new UserEntity(id)).stream().findFirst().orElse(new UserEntity());
    }

    @Override
    public void update(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE \"user\" ");
        sql.append("SET identificationType = ?, ");
        sql.append("    identificationNumber = ?, ");
        sql.append("    firstName = ?, ");
        sql.append("    secondName = ?, ");
        sql.append("    firstSurname = ?, ");
        sql.append("    secondSurname = ?, ");
        sql.append("    homeCity = ?, ");
        sql.append("    email = ?, ");
        sql.append("    mobileNumber = ?, ");
        sql.append("    emailConfirmed = ?, ");
        sql.append("    mobileNumberConfirmed = ? ");
        sql.append("WHERE id = ?;");

        try (final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getIdentificationType().getId());
            preparedStatement.setObject(2, entity.getIdentificationNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstSurname());
            preparedStatement.setString(6, entity.getSecondSurname());
            preparedStatement.setObject(7, entity.getHomeCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getMobileNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobileNumberConfirmed());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_UPDATING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_UPDATING_ENTITY.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_UPDATING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_UPDATING_ENTITY.getContent()  + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("DELETE FROM \"user\" ");
        sql.append("WHERE id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_DELETING_ENTITY.getContent();
            var technicalMessage =  MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_DELETING_ENTITY.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_DELETING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_DELETING_ENTITY.getContent() + " UserPostgreSqlDAO " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
}

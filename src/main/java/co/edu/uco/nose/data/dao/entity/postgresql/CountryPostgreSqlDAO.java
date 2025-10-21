package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.mapper.CountryMapper;
import co.edu.uco.nose.entity.CountryEntity;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class CountryPostgreSqlDAO extends SqlConnection implements CountryDAO {

    public CountryPostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<CountryEntity> findAll() {
        final var countries = new ArrayList<CountryEntity>();
        final var sql = new StringBuilder();

        sql.append("SELECT");
        sql.append(" c.id, ");
        sql.append(" c.name, ");
        sql.append(" from \"Country\" as c ");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())){
            try(var resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    var country = CountryMapper.map(resultSet);
                    countries.add(country);
                }
            }

        } catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_ENTITY.getContent() + exception.getMessage();
            throw NoseException.create(exception,userMessage, technicalMessage);
        }

        return countries;
    }

    @Override
    public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
        return null;
    }

    @Override
    public CountryEntity findById(UUID id) {
        var country = new CountryEntity();
        final var sql = new StringBuilder();

        sql.append("SELECT");
        sql.append(" c.id, ");
        sql.append(" c.name, ");
        sql.append(" from \"Country\" as c ");
        sql.append(" where c.id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())){
            preparedStatement.setObject(1, id);

            try (var resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    country = CountryMapper.map(resultSet);
                }
            }
        } catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_ENTITY +  exception.getMessage();
            throw NoseException.create(exception,userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY.getContent() + exception.getMessage();
            throw NoseException.create(exception,userMessage, technicalMessage);

        }
        return country;
    }

}

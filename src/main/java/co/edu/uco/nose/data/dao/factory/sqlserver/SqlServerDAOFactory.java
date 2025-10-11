package co.edu.uco.nose.data.dao.factory.sqlserver;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.*;
import co.edu.uco.nose.data.dao.entity.postgresql.*;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class SqlServerDAOFactory extends DAOFactory {

    public SqlServerDAOFactory() {
        openConnection();
    }
    @Override
    public CityDAO getCityDAO() {
        return new CityPostgreSqlDAO(connection);
    }

    @Override
    public CountryDAO getCountryDAO() {
        return new CountryPostgreSqlDAO(connection);
    }

    @Override
    public IdentificationTypeDAO getIdentificationTypeDAO() {
        return new IdentificationTypePostgreSqlDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        return new StatePostgreSqlDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserPostgreSqlDAO(connection);
    }

    @Override
    protected void openConnection() {
        try{
            this.connection = DriverManager.getConnection("");

        } catch ( final SQLException exception){
            var userMessage = "";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = "";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage, technicalMessage);
    }}



}

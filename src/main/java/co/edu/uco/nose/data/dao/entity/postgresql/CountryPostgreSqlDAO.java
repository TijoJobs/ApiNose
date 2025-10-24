package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
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
        return null;
    }

    @Override
    public List<CountryEntity> findByFilter(CountryEntity filterEntity) {

        return null;
    }

    @Override
    public CountryEntity findById(UUID id) {
        return null;
    }

}

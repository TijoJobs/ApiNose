package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.PostgreSqlConnection;
import co.edu.uco.nose.entity.CityEntity;

import java.util.List;
import java.util.UUID;
import java.sql.Connection;

public final class CityPostgreSqlDAO extends PostgreSqlConnection implements CityDAO {

    public CityPostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<CityEntity> findAll() {
        return null;
    }

    @Override
    public List<CityEntity> findByFilter(CityEntity filterEntity) {
        return null;
    }

    @Override
    public CityEntity findById(UUID uuid) {
        return null;
    }

}

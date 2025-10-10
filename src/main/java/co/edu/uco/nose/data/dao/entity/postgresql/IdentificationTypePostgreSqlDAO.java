package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

import java.sql.Connection;
import java.util.UUID;
import java.util.List;

public final class IdentificationTypePostgreSqlDAO extends SqlConnection implements IdentificationTypeDAO {

    protected IdentificationTypePostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IdentificationTypeEntity> findAll() {
        return null;
    }

    @Override
    public List<IdentificationTypeEntity> findByFilter(IdentificationTypeEntity filterEntity) {
        return null;
    }

    @Override
    public IdentificationTypeEntity findById(UUID uuid) {
        return null;
    }

}

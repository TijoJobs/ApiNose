package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import co.edu.uco.nose.data.dao.entity.mapper.IdentificationTypeMapper;


public final class IdentificationTypePostgreSqlDAO extends SqlConnection implements IdentificationTypeDAO {

    public IdentificationTypePostgreSqlDAO(Connection connection) {
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

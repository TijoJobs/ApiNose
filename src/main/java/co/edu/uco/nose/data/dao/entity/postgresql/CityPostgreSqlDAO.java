package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.business.assembler.entity.impl.CityEntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;

public final class CityPostgreSqlDAO extends SqlConnection implements CityDAO {

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
    public CityEntity findById(UUID id) {
        return null;
    }

}

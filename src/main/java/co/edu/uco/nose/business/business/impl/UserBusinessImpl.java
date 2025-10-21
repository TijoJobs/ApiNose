package co.edu.uco.nose.business.business.impl;

import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public final class UserBusinessImpl implements UserBusiness {

    private DAOFactory daoFactory;

    public UserBusinessImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public void registerNewUserInformation(UserDomain userDomain) {
        // 1. Valodar qie la informaci´on sea consistente a nivel de tipo de dato ,
        // longitud , obligatoriedad, formato , rango ,reglas propias del objeto

        //2. Validar que no exista previamente otro usuario con el mismo tipó y número
        // de identificación

        //3. Validar que no exista previamente otro usuario con el mismo correo electrónico

        //4. Validar que no exista previamente otro usuario con el mismo número de
        // teléfono celular

        //5. Generar un identificador para el nuevo usuario ,asegurando que no exista

        var id = UUIDHelper.getUUIDHelper().generateNewUUID();
        var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);

        userEntity.setId(id);

        //6. Registrar la información del nuevo usuario

        daoFactory.getUserDAO().create(userEntity);

    }

    @Override
    public void dropUserInformation(UUID id) {

    }

    @Override
    public void updateUserInformation(UUID id, UserDomain userDomain) {

    }

    @Override
    public List<UserDomain> findAllUsers() {
        return List.of();
    }

    @Override
    public List<UserDomain> findUsersByFilter(UserDomain userFilters) {
        return List.of();
    }

    @Override
    public UserDomain findSpecificUser(UUID id) {
        return null;
    }
}

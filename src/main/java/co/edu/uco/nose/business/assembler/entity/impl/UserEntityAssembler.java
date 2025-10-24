package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;
import static co.edu.uco.nose.business.assembler.entity.impl.IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler;
import static co.edu.uco.nose.business.assembler.entity.impl.CityEntityAssembler.getCityEntityAssembler;
public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain> {
    private static final EntityAssembler<UserEntity, UserDomain> instance = new UserEntityAssembler();
    private UserEntityAssembler() {

    }

    public static EntityAssembler <UserEntity,UserDomain> getUserEntityAssembler(){
        return instance;

    }
    @Override
    public UserEntity toEntity(UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var identificationTypeTmp = getIdentificationTypeEntityAssembler().toEntity(domain.getIdentificationType());
        var cityTmp = getCityEntityAssembler().toEntity(domain.getHomeCity());
        return new UserEntity(domainTmp.getId(),identificationTypeTmp,domainTmp.getIdentificationNumber(),domainTmp.getFirstName(),
                domainTmp.getSecondName(), domainTmp.getFirstSurname(), domainTmp.getSecondSurname(),cityTmp,domainTmp.getEmail(),
                domainTmp.getMobileNumber(),domainTmp.isEmailConfirmed(),domainTmp.isMobileNumberConfirmed());
    }

    @Override
    public UserDomain toDomain(UserEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new UserEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var identificationTypeTmpDomain = getIdentificationTypeEntityAssembler().toDomain(entity.getIdentificationType());
        var cityTmpDomain = getCityEntityAssembler().toDomain(entity.getHomeCity());
        return new UserDomain(entityTmp.getId(),identificationTypeTmpDomain,entityTmp.getIdentificationNumber(),entityTmp.getFirstName(),
                entityTmp.getSecondName(),entityTmp.getFirstSurname(), entityTmp.getSecondSurname(), cityTmpDomain, entityTmp.getEmail(),
                entityTmp.getMobileNumber(),entityTmp.isEmailConfirmed(),entityTmp.isMobileNumberConfirmed());
    }
}

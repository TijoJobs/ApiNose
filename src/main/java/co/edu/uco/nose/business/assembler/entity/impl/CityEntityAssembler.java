package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.entity.CityEntity;
import static  co.edu.uco.nose.business.assembler.entity.impl.StateEntityAssembler.getStateEntityAssembler;

import java.util.Objects;

public final class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {
    private static final EntityAssembler<CityEntity, CityDomain> instance = new CityEntityAssembler();

    private CityEntityAssembler(){

    }

    public static EntityAssembler <CityEntity, CityDomain> getCityEntityAssembler(){
        return instance;
    }
    @Override
    public CityEntity toEntity(CityDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var stateTmp = getStateEntityAssembler().toEntity(domain.getState());
        return new CityEntity(domainTmp.getId(), domainTmp.getName(), stateTmp);
    }

    @Override
    public CityDomain toDomain(CityEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new CityEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var stateTmpDomain = getStateEntityAssembler().toDomain(entity.getState());
        return new CityDomain(entityTmp.getId(), entityTmp.getName(), stateTmpDomain);
    }
}

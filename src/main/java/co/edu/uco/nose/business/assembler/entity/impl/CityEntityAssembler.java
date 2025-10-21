package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.assembler.dto.impl.CityDTOAssembler;
import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.entity.CityEntity;

public final class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {
    private static final EntityAssembler<CityEntity, CityDomain> instance = new CityEntityAssembler();

    private CityEntityAssembler(){

    }

    public static EntityAssembler <CityEntity, CityDomain> getCityEntityAssembler(){
        return instance;
    }
    @Override
    public CityEntity toEntity(CityDomain domain) {
        return null;
    }

    @Override
    public CityDomain toDomain(CityEntity entity) {
        return null;
    }
}

package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;

public final class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {
    private static final EntityAssembler<CountryEntity, CountryDomain> instance = new CountryEntityAssembler();

    private CountryEntityAssembler(){

    }

    public static EntityAssembler <CountryEntity, CountryDomain> getCityEntityAssembler(){
        return instance;
    }
    @Override
    public CountryEntity toEntity(final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new CountryEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CountryDomain toDomain(final CountryEntity entity) {
        var dtoTmp = ObjectHelper.getDefault(entity, new CountryEntity());
        return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
    }
}
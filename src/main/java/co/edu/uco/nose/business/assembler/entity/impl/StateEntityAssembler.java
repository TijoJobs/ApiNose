package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.StateEntity;
import static co.edu.uco.nose.business.assembler.entity.impl.CountryEntityAssembler.getCountryEntityAssembler;


public final class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {
    private static final EntityAssembler<StateEntity, StateDomain> instance = new StateEntityAssembler();

    private StateEntityAssembler() {

    }

    public static EntityAssembler <StateEntity, StateDomain> getStateEntityAssembler(){
        return instance;
    }

    @Override
    public StateEntity toEntity(StateDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var countryTmp = getCountryEntityAssembler().toEntity(domain.getCountry());
        return new StateEntity(domainTmp.getId(),domainTmp.getName(), countryTmp);
    }

    @Override
    public StateDomain toDomain(StateEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new StateEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var countryTmpDomain = getCountryEntityAssembler().toDomain(entity.getCountry());
        return new StateDomain(entityTmp.getId(),entityTmp.getName(), countryTmpDomain);
    }
}

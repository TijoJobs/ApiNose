package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import co.edu.uco.nose.entity.StateEntity;

public final class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {
    private static final EntityAssembler<StateEntity, StateDomain> instance = new StateEntityAssembler();

    private StateEntityAssembler() {

    }

    public static EntityAssembler <StateEntity, StateDomain> getStateEntityAssembler(){
        return instance;

    }

    @Override
    public StateEntity toEntity(StateDomain domain) {
        return null;
    }

    @Override
    public StateDomain toDomain(StateEntity entity) {
        return null;
    }
}

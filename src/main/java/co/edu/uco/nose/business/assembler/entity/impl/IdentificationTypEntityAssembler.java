package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public final class IdentificationTypEntityAssembler implements EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> {
    private static final EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> instance = new IdentificationTypEntityAssembler();

    private void IdentificationTypeEntityAssembler() {

    }

    public static EntityAssembler <IdentificationTypeEntity, IdentificationTypeDomain> getIdentificationTypeEntityAssembler(){
        return instance;

    }@Override
    public IdentificationTypeEntity toEntity(IdentificationTypeDomain domain) {
        return null;
    }

    @Override
    public IdentificationTypeDomain toDomain(IdentificationTypeEntity entity) {
        return null;
    }
}

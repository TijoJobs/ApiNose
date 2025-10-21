package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CountryDTO;
import co.edu.uco.nose.dto.IdentificationTypeDTO;

public final class IdentificationTypeDTOAssembler implements DTOAssembler <IdentificationTypeDTO, IdentificationTypeDomain> {
    private static final DTOAssembler <IdentificationTypeDTO, IdentificationTypeDomain> instance = new IdentificationTypeDTOAssembler();

    private IdentificationTypeDTOAssembler(){

    }

    public static DTOAssembler <IdentificationTypeDTO, IdentificationTypeDomain> getIdentificationTypeDTOAssembler(){
        return instance;

    }@Override
    public IdentificationTypeDTO toDTO(final IdentificationTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new IdentificationTypeDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public IdentificationTypeDomain toDomain(final IdentificationTypeDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new IdentificationTypeDTO());
        return new IdentificationTypeDomain(dtoTmp.getId(), dtoTmp.getName());
    }
}

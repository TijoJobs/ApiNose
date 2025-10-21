package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.CountryDTO;

public final class CityDTOAssembler implements DTOAssembler <CityDTO, CityDomain>{

    private static final DTOAssembler <CityDTO, CityDomain> instance = new CityDTOAssembler();

    private CityDTOAssembler(){

    }

    public static DTOAssembler <CityDTO, CityDomain> getCityDTOAssembler(){
        return instance;
    }

    @Override
    public CityDTO toDTO(CityDomain domain) {
        return null;
    }

    @Override
    public CityDomain toDomain(CityDTO dto) {
        return null;
    }
}

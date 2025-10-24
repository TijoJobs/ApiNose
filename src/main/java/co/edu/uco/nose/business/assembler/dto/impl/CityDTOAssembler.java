package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import static co.edu.uco.nose.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

import java.util.ArrayList;
import java.util.List;

public final class CityDTOAssembler implements DTOAssembler <CityDTO, CityDomain>{

    private static final DTOAssembler <CityDTO, CityDomain> instance = new CityDTOAssembler();

    private CityDTOAssembler(){

    }

    public static DTOAssembler <CityDTO, CityDomain> getCityDTOAssembler(){
        return instance;
    }

    @Override
    public CityDTO toDTO(CityDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var stateTmp = getStateDTOAssembler().toDTO(domain.getState());
        return new CityDTO(domainTmp.getId(), domainTmp.getName(), stateTmp);
    }

    @Override
    public CityDomain toDomain(CityDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO(UUIDHelper.getUUIDHelper().getDefault()));
        var stateTmpDomain =  getStateDTOAssembler().toDomain(dto.getState());
        return new CityDomain(dtoTmp.getId(), dtoTmp.getName(), stateTmpDomain);
    }

    @Override
    public List<CityDTO> toDTO(List<CityDomain> domainList) {
        var cityDTOList = new ArrayList<CityDTO>();
        for (var cityDomain: domainList) {
            cityDTOList.add(toDTO(cityDomain));
        }
        return cityDTOList;
    }
}

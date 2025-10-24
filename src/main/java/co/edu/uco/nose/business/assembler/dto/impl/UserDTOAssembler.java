package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import static co.edu.uco.nose.business.assembler.dto.impl.IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler;
import static co.edu.uco.nose.business.assembler.dto.impl.CityDTOAssembler.getCityDTOAssembler;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain> {
    private static final DTOAssembler <UserDTO, UserDomain> instance = new UserDTOAssembler();

    private UserDTOAssembler(){

    }

    public static DTOAssembler <UserDTO, UserDomain> getUserDTOAssembler(){
        return instance;
    }
    @Override
    public UserDTO toDTO(UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain , new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var identificationTypeTmp = getIdentificationTypeDTOAssembler().toDTO(domainTmp.getIdentificationType());
        var cityTmp = getCityDTOAssembler().toDTO(domainTmp.getHomeCity());
        return new UserDTO(domainTmp.getId(),identificationTypeTmp,domainTmp.getIdentificationNumber(),domainTmp.getFirstName(),
                domainTmp.getSecondName(),domainTmp.getFirstSurname(),domainTmp.getSecondSurname(),cityTmp,domainTmp.getEmail(),
                domainTmp.getMobileNumber(),domainTmp.isEmailConfirmed(), domain.isMobileNumberConfirmed());
    }

    @Override
    public UserDomain toDomain(UserDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto , new UserDTO(UUIDHelper.getUUIDHelper().getDefault()));
        var identificationTypeTmpDomain = getIdentificationTypeDTOAssembler().toDomain(dtoTmp.getIdentificationType());
        var cityTmpDomain= getCityDTOAssembler().toDomain(dtoTmp.getHomeCity());
        return new UserDomain(dtoTmp.getId(), identificationTypeTmpDomain, dtoTmp.getIdentificationNumber(),dtoTmp.getFirstName(),
                dtoTmp.getSecondName(),dtoTmp.getFirstSurname(),dtoTmp.getSecondSurname(),cityTmpDomain,dtoTmp.getEmail(),
                dtoTmp.getMobileNumber(),dtoTmp.isEmailConfirmed(), dtoTmp.isMobileNumberConfirmed());
    }

    public List<UserDTO> toDTO(List<UserDomain> domainList) {
        var userDtoList = new ArrayList<UserDTO>();

        for(var UserDomain: domainList){
            userDtoList.add(toDTO(UserDomain));
        }
        return userDtoList;


    }
}

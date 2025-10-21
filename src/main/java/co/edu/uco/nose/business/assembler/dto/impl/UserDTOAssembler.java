package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.dto.CountryDTO;
import co.edu.uco.nose.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain> {
    private static final DTOAssembler <UserDTO, UserDomain> instance = new UserDTOAssembler();

    private UserDTOAssembler(){

    }

    public static DTOAssembler <UserDTO, UserDomain> getUserDTOAssembler(){
        return instance;
    }
    @Override
    public UserDTO toDTO(UserDomain domain) {
        return null;
    }

    @Override
    public UserDomain toDomain(UserDTO dto) {
        return null;
    }

    public List<UserDTO> toDTO(List<UserDomain> domainList) {
        var userDtoList = new ArrayList<UserDTO>();

        for(var UserDomain: domainList){
            userDtoList.add(toDTO(UserDomain));
        }
        return userDtoList;


    }
}

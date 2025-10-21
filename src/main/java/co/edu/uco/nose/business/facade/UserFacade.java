package co.edu.uco.nose.business.facade;

import co.edu.uco.nose.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserFacade {

    void registerNewUserInformation(UserDTO userDto);

    void dropUserInformation(UUID id);

    void updateUserInformation(UUID id, UserDTO userDto);

    List<UserDTO> findAllUsers();
    List<UserDTO> findUsersByFilter(UserDTO userFilters);

    UserDTO findSpecificUser(UUID id);

    void confirmMobileNumber(UUID id, int confirmationCode);

    void confirmEmail(UUID id, int confirmationCode);

    void sendMobileNumberConfirmation(UUID id);
    void sendEmailConfirmation(UUID id);
}

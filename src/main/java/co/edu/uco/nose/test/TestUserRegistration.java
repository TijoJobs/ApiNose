package co.edu.uco.nose.test;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.IdentificationTypeDTO;
import co.edu.uco.nose.dto.UserDTO;

import java.util.UUID;

public class TestUserRegistration {

    public static void main(String[] args) {
        try{
            var user = new UserDTO();

            user.setIdentificationType(new IdentificationTypeDTO(UUID.fromString("20000000-0000-0000-0000-000000000010")));
            user.setIdentificationNumber("1033099718");
            user.setFirstName("Diego");
            user.setSecondName("Andrés");
            user.setFirstSurname("Tijo");
            user.setSecondSurname("Guacaneme");
            user.setHomeCity(new CityDTO(UUID.fromString("20000000-0000-0000-0000-000000000003")));
            user.setEmail("dtijo9718@gmail.com");
            user.setMobileNumber("3014286196");
            user.setEmailConfirmed(false);
            user.setEmailConfirmed(false);

            var facade = new UserFacadeImpl();
            facade.registerNewUserInformation(user);

            System.out.println("Gané el semestre!!");
        } catch (NoseException e){
            System.out.println(e.getUserMessage());
            System.out.println(e.getTechnicalMessage());
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

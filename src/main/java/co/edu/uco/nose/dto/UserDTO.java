package co.edu.uco.nose.dto;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private IdentificationTypeDTO identificationType;
    private String identificationNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityDTO homeCity;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;
    private boolean emailConfirmedIsDefaultValue;
    private boolean mobileNumberConfirmedIsDefaultValue;

    public UserDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeDTO.getDefaultValue());
        setIdentificationNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(CityDTO.getDefaultValue());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setMobileNumberConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(false);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    public UserDTO(final UUID id) {
        setId(id);
        setIdentificationType(IdentificationTypeDTO.getDefaultValue());
        setIdentificationNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(CityDTO.getDefaultValue());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setMobileNumberConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    public UserDTO(final UUID id, final IdentificationTypeDTO identificationType, final String identificationNumber, final String firstName,
                   final String secondName, final String firstSurname, final String secondSurname, final CityDTO homeCity, final String email,
                   final String mobileNumber, final boolean emailConfirmed, final boolean mobileNumberConfirmed) {
        setId(id);
        setIdentificationType(identificationType);
        setIdentificationNumber(identificationNumber);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setHomeCity(homeCity);
        setEmail(email);
        setMobileNumber(mobileNumber);
        setMobileNumberConfirmed(mobileNumberConfirmed);
        setEmailConfirmed(emailConfirmed);
    }

    static UserDTO getDefaultValue() {
        return new UserDTO();
    }

    static UserDTO getDefaultValue(final UserDTO user) {
        return ObjectHelper.getDefault(user, getDefaultValue());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public IdentificationTypeDTO getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationTypeDTO identificationType) {
        this.identificationType = ObjectHelper.getDefault(identificationType, IdentificationTypeDTO.getDefaultValue());
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = TextHelper.getDefaultWithTrim(firstName);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = TextHelper.getDefaultWithTrim(secondName);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
    }

    public CityDTO getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(CityDTO homeCity) {
        this.homeCity = ObjectHelper.getDefault(homeCity, getHomeCity());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = TextHelper.getDefaultWithTrim(mobileNumber);
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
        setEmailConfirmedIsDefaultValue(false);
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
        setMobileNumberConfirmedIsDefaultValue(false);
    }

    public boolean isEmailConfirmedIsDefaultValue() {
        return emailConfirmedIsDefaultValue;
    }

    public void setEmailConfirmedIsDefaultValue(boolean emailConfirmedIsDefaultValue) {
        this.emailConfirmedIsDefaultValue = emailConfirmedIsDefaultValue;
    }

    public boolean isMobileNumberConfirmedIsDefaultValue() {
        return mobileNumberConfirmedIsDefaultValue;
    }

    public void setMobileNumberConfirmedIsDefaultValue(boolean mobileNumberConfirmedIsDefaultValue) {
        this.mobileNumberConfirmedIsDefaultValue = mobileNumberConfirmedIsDefaultValue;
    }
}

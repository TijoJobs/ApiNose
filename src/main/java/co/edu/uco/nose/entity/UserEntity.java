package co.edu.uco.nose.entity;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public class UserEntity {

    private UUID id;
    private IdentificationTypeEntity identificationType;
    private String identificationNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityEntity homeCity;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;
    private boolean emailConfirmedIsDefaultValue;
    private boolean mobileNumberConfirmedIsDefaultValue;

    public UserEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeEntity.getDefaultValue());
        setIdentificationNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(CityEntity.getDefaultValue());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setMobileNumberConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(false);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    public UserEntity(final UUID id) {
        setId(id);
        setIdentificationType(IdentificationTypeEntity.getDefaultValue());
        setIdentificationNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(CityEntity.getDefaultValue());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setMobileNumberConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setMobileNumberConfirmedIsDefaultValue(true);
    }


    public UserEntity(final UUID id, final IdentificationTypeEntity identificationType, final String identificationNumber, final String firstName,
                      final String secondName, final String firstSurname, final String secondSurname, final CityEntity homeCity, final String email,
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

    static UserEntity getDefaultValue() {
        return new UserEntity();
    }

    static UserEntity getDefaultValue(final UserEntity user) {
        return ObjectHelper.getDefault(user, getDefaultValue());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }


    public IdentificationTypeEntity getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final IdentificationTypeEntity identificationType) {
        this.identificationType = ObjectHelper.getDefault(identificationType, IdentificationTypeEntity.getDefaultValue());
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(final String identificationNumber) {
        this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = TextHelper.getDefaultWithTrim(firstName);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = TextHelper.getDefaultWithTrim(secondName);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(final String firstSurname) {
        this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
    }

    public CityEntity getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(final CityEntity homeCity) {
        this.homeCity = ObjectHelper.getDefault(homeCity, CityEntity.getDefaultValue());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = TextHelper.getDefaultWithTrim(mobileNumber);
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
        setEmailConfirmedIsDefaultValue(false);
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
        setMobileNumberConfirmedIsDefaultValue(false);
    }

    public boolean isEmailConfirmedIsDefaultValue() {
        return emailConfirmedIsDefaultValue;
    }

    public void setEmailConfirmedIsDefaultValue(final boolean emailConfirmedIsDefaultValue) {
        this.emailConfirmedIsDefaultValue = emailConfirmedIsDefaultValue;
    }

    public boolean isMobileNumberConfirmedIsDefaultValue() {
        return mobileNumberConfirmedIsDefaultValue;
    }

    public void setMobileNumberConfirmedIsDefaultValue(final boolean mobileNumberConfirmedIsDefaultValue) {
        this.mobileNumberConfirmedIsDefaultValue = mobileNumberConfirmedIsDefaultValue;
    }
}


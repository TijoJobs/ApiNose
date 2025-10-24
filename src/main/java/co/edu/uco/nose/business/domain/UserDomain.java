package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class UserDomain extends Domain {

    private IdentificationTypeDomain identificationType;
    private String identificationNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityDomain homeCity;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;
    private boolean emailConfirmedIsDefaultValue;
    private boolean mobileNumberConfirmedIsDefaultValue;

    public UserDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeDomain.getDefaultValue());
        setIdentificationNumber(TextHelper.getDefault());;
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(CityDomain.getDefaultValue());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setMobileNumberConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedDefaultValue(true);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    public UserDomain(final UUID id) {
        super(id);
        setIdentificationType(IdentificationTypeDomain.getDefaultValue());
        setIdentificationNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(CityDomain.getDefaultValue());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setMobileNumberConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedDefaultValue(true);
        setMobileNumberConfirmedIsDefaultValue(true);
    }


    public UserDomain(final UUID id, final IdentificationTypeDomain identificationType, final String identificationNumber, final String firstName,
                      final String secondName, final String firstSurname, final String secondSurname, final CityDomain homeCity, final String email,
                      final String mobileNumber, final boolean emailConfirmed, final boolean mobileNumberConfirmed) {
        super(id);
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

    static UserDomain getDefaultValue() {
        return new UserDomain();
    }

    static UserDomain getDefaultValue(final UserDomain user) {
        return ObjectHelper.getDefault(user, getDefaultValue());
    }

    public IdentificationTypeDomain getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final IdentificationTypeDomain identificationType) {
        this.identificationType = ObjectHelper.getDefault(identificationType, IdentificationTypeDomain.getDefaultValue());
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

    public CityDomain getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(final CityDomain homeCity) {
        this.homeCity = ObjectHelper.getDefault(homeCity, CityDomain.getDefaultValue());
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
        setEmailConfirmedDefaultValue(false);
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
        setMobileNumberConfirmedIsDefaultValue(false);
    }

    public boolean isEmailConfirmedDefaultValue() {
        return emailConfirmedIsDefaultValue;
    }

    private void setEmailConfirmedDefaultValue(final boolean emailConfirmedDefaultValue) {
        this.emailConfirmedIsDefaultValue = emailConfirmedDefaultValue;
    }

    public boolean isMobileNumberConfirmedDefaultValue() {
        return mobileNumberConfirmedIsDefaultValue;
    }

    private void setMobileNumberConfirmedIsDefaultValue(final boolean mobileNumberConfirmedIsDefaultValue) {
        this.mobileNumberConfirmedIsDefaultValue = mobileNumberConfirmedIsDefaultValue;
    }



}

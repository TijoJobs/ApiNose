package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helpers.ObjetcHelper;
import co.edu.uco.nose.crosscuting.helpers.TextHelper;
import co.edu.uco.nose.crosscuting.helpers.UUIDHelper;

public class CityDomain extends Domain{

    private String name;
    private StateDomain state;

    public CityDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(StateDomain.getDefaultValue());
    }

    public CityDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setState(StateDomain.getDefaultValue());
    }

    public CityDomain(final UUID id, final String name, final StateDomain state) {
        super(id);
        this.name = name;
        this.state = state;
    }

    static CityDomain getDefaultValue() {
        return new CityDomain();
    }

    static CityDomain getDefaultValue(final CityDomain city) {
        return ObjetcHelper.getDefault(city, getDefaultValue());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public StateDomain getState() {
        return state;
    }

    public void setState(final StateDomain state) {
        this.state = ObjetcHelper.getDefault(state, StateDomain.getDefaultValue());
    }


}

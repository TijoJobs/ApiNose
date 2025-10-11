package co.edu.uco.nose.entity;

import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helpers.ObjetcHelper;
import co.edu.uco.nose.crosscuting.helpers.TextHelper;
import co.edu.uco.nose.crosscuting.helpers.UUIDHelper;

import java.util.UUID;

public class CityEntity extends Entity {

    private String name;
    private StateEntity state;

    public CityEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(StateEntity.getDefaultValue());
    }

    public CityEntity(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setState(StateEntity.getDefaultValue());
    }

    public CityEntity(final UUID id, final String name, final StateEntity state) {
        super(id);
        this.name = name;
        this.state = state;
    }

    static CityEntity getDefaultValue() {
        return new CityEntity();
    }

    static CityEntity getDefaultValue(final CityEntity city) {
        return ObjetcHelper.getDefault(city, getDefaultValue());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = ObjetcHelper.getDefault(state, StateEntity.getDefaultValue());
    }


}

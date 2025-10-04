package co.edu.uco.nose.entity;

import co.edu.uco.nose.entity.Entity;
import co.edu.uco.nose.crosscuting.helpers.ObjetcHelper;
import co.edu.uco.nose.crosscuting.helpers.TextHelper;
import co.edu.uco.nose.crosscuting.helpers.UUIDHelper;

import java.util.UUID;

public class IdentificationTypeEntity extends Entity {

    private String name;

    public IdentificationTypeEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeEntity(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }


    public IdentificationTypeEntity(final UUID id, final String name) {
        super(id);
        this.name = name;
    }

    static IdentificationTypeEntity getDefaultValue() {
        return new IdentificationTypeEntity();
    }

    static IdentificationTypeEntity getDefaultValue(final IdentificationTypeEntity identificationType) {
        return ObjetcHelper.getDefault(identificationType, getDefaultValue());
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }



}

package co.edu.uco.nose.business.domain;
import co.edu.uco.nose.crosscuting.helpers.TextHelper;
import co.edu.uco.nose.crosscuting.helpers.UUIDHelper;
import org.w3c.dom.Text;

import java.util.UUID;

public final class CountryDomain {
    private String name;


    public CountryDomain(){
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public CountryDomain(final UUID id){
        super(id);
        setName(TextHelper.getDefault());
    }
    public CountryDomain(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

    }

}

package co.edu.uco.nose.crosscuting.helpers;

public final class ObjetcHelper {
    private ObjetcHelper() {

    }

    public static <O> boolean isNull(final O object){
        return object == null;
    }

    public static <O> O getDefault(final O object, final O defaultValue) {
        return isNull(object) ? defaultValue : object;
    }
}

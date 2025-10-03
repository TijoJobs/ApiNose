package co.edu.uco.nose.crosscuting.helpers;

public class TextHelper {
    private static final String EMPTY = "";
    private TextHelper() {

    }

    public static String getDefault(){
        return EMPTY;
    }

    public static String getDefault(final String value){
        return ObjetcHelper.getDefault(value, getDefault());
    }

    public static String getDefaultWithTrim(final String value){
        return getDefault(value).trim();
    }

    public static boolean isEmpty(final String value){
        return EMPTY.equals(getDefault(value));
    }
}

package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helpers.TextHelper;

public enum MessagesEnum {

    USER_ERROR_SQL_CONNECTION_IS_EMPTY(
            "Conexión contra la fuente de información deseada vacía",
            "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."
    ),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY(
            "Conexión contra la fuente de información deseada nula",
            "La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula"
    ),

    USER_ERROR_SQL_CONNECTION_IS_CLOSED("",""),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("",""),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("",""),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("","");

    private String title;
    private String content;

    private MessagesEnum(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
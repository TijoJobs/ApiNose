package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
    USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía.",
            "La conexión requerida para realizar la operación contra la fuente de información deseada está vacía. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula.",
            "La conexión requerida para realizar la operación contra la base de datos llegó nula."),

    USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada.",
            "La conexión requerida para realizar la operación contra la fuente de información deseada está cerrada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada.",
            "La conexión requerida para realizar la operación contra la base de datos está cerrada."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión.",
            "Se ha presentado un problema inesperado al validar el estado de la conexión requerida para realizar la operación. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Error SQL validando el estado de la conexión contra la base de datos.",
            "Se presentó una excepción de tipo SQLException al intentar validar si la conexión contra la base de datos se encontraba activa."),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando el estado de la conexión contra la base de datos.",
            "Se presentó un error no controlado al intentar validar el estado de la conexión contra la base de datos."),

    USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada.",
            "No se ha iniciado una transacción válida para ejecutar la operación solicitada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada en la fuente de datos.",
            "El autocommit de la conexión está activado, lo que indica que no existe una transacción activa."),

    USER_ERROR_TRANSACTION_IS_STARTED("Transacción ya iniciada.",
            "Ya existe una transacción activa sobre la conexión actual. Por favor, verifique la secuencia de operaciones."),
    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción ya iniciada en la fuente de datos.",
            "El autocommit de la conexión está desactivado, lo que indica que ya existe una transacción activa."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando el estado de la transacción.",
            "Ocurrió un problema inesperado al validar si la transacción estaba iniciada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL validando si la transacción estaba iniciada.",
            "Se presentó una excepción de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos había sido iniciada."),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando si la transacción estaba iniciada.",
            "Se presentó un error no controlado al intentar validar si la transacción estaba iniciada."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando si la transacción no estaba iniciada.",
            "Ocurrió un problema inesperado al validar si la transacción no había sido iniciada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error SQL validando si la transacción no estaba iniciada.",
            "Se presentó una excepción de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos no había sido iniciada."),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando si la transacción no estaba iniciada.",
            "Se presentó un error no controlado al intentar validar si la transacción contra la base de datos no había sido iniciada."),

    USER_ERROR_FACTORY_NOT_INITIALIZED("Fábrica no inicializada.",
            "La fábrica requerida para acceder a la fuente de información no está disponible. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_FACTORY_NOT_VALIDATED("Fábrica de datos no validada.",
            "No se ha podido determinar la fuente de datos a la cual debe conectarse la fábrica de acceso a datos."),

    USER_ERROR_SQL_EXCEPTION_REGISTERING_ENTITY("Error durante el registro de la información.",
            "Se ha presentado un problema tratando de registrar la información solicitada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_SQL_EXCEPTION_REGISTERING_ENTITY("Error SQL durante la operación de registro.",
            "Se ha presentado un error de tipo SQLException durante la operación de registro."),
    USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_ENTITY("Error inesperado durante el registro de la información.",
            "Se ha presentado un problema inesperado durante la operación de registro. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_ENTITY("Error inesperado durante la operación de registro.",
            "Se ha presentado un error no controlado durante la operación de registro."),

    USER_ERROR_SQL_EXCEPTION_UPDATING_ENTITY("Error durante la actualización de la información.",
            "Se ha presentado un problema tratando de actualizar la información solicitada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_SQL_EXCEPTION_UPDATING_ENTITY("Error SQL durante la operación de actualización.",
            "Se ha presentado un error de tipo SQLException durante la operación de actualización."),
    USER_ERROR_UNEXPECTED_EXCEPTION_UPDATING_ENTITY("Error inesperado durante la actualización de la información.",
            "Se ha presentado un problema inesperado durante la operación de actualización. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_UPDATING_ENTITY("Error inesperado durante la operación de actualización.",
            "Se ha presentado un error no controlado durante la operación de actualización."),

    USER_ERROR_SQL_EXCEPTION_DELETING_ENTITY("Error durante la eliminación de la información.",
            "Se ha presentado un problema tratando de eliminar la información solicitada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_SQL_EXCEPTION_DELETING_ENTITY("Error SQL durante la operación de eliminación.",
            "Se ha presentado un error de tipo SQLException durante la operación de eliminación."),
    USER_ERROR_UNEXPECTED_EXCEPTION_DELETING_ENTITY("Error inesperado durante la eliminación de la información.",
            "Se ha presentado un problema inesperado durante la operación de eliminación. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_DELETING_ENTITY("Error inesperado durante la operación de eliminación.",
            "Se ha presentado un error no controlado durante la operación de eliminación."),

    USER_ERROR_SQL_EXCEPTION_FINDING_ENTITY("Error durante la consulta de la información.",
            "Se ha presentado un problema tratando de consultar la información solicitada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_ENTITY("Error SQL durante la operación de consulta.",
            "Se ha presentado un error de tipo SQLException durante la operación de consulta."),
    USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY("Error inesperado durante la consulta de la información.",
            "Se ha presentado un problema inesperado durante la operación de consulta. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),
    TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_ENTITY("Error inesperado durante la operación de consulta.",
            "Se ha presentado un error no controlado durante la operación de consulta."),

    // ===== MAPPER ERRORS =====
    USER_ERROR_SQL_EXCEPTION_MAPPER("Ocurrió un error al obtener los datos desde la base de datos.",
            "Error SQL al mapear los resultados desde el ResultSet."),
    TECHNICAL_ERROR_SQL_EXCEPTION_MAPPER("Error técnico de SQL al mapear los resultados de la consulta.",
            "Error técnico de tipo SQLException al mapear los resultados de la consulta."),

    USER_ERROR_UNEXPECTED_EXCEPTION_MAPPER("Ocurrió un error inesperado al procesar la información.",
            "Error inesperado al mapear la información desde el ResultSet."),
    TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_MAPPER("Error técnico inesperado al mapear la información desde el ResultSet.",
            "Error técnico no controlado al mapear la información desde el ResultSet."),

    USER_ERROR_NULL_RESULTSET_MAPPER("No se recibieron datos válidos desde la base de datos.",
            "El ResultSet está vacío o es nulo al intentar mapear los datos."),
    TECHNICAL_ERROR_NULL_RESULTSET_MAPPER("El ResultSet está vacío o es nulo al intentar mapear los datos.",
            "ResultSet nulo o sin filas cuando se esperaba contenido para mapear.");

    private String title;
    private String content;

    private MessagesEnum(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(final String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    private void setContent(final String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}
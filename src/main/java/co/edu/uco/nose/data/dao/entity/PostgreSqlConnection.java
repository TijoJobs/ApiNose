package co.edu.uco.nose.data.dao.entity;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;

import java.sql.Connection;

public abstract class PostgreSqlConnection {

    private Connection connection;

    protected PostgreSqlConnection(final Connection connection) {
        setConnection(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(final Connection connection) {
        SqlConnectionHelper.ensureConnectionIsOpen(connection);
        this.connection = connection;
    }


}
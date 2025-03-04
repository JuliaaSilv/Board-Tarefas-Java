package dio.me.board.persistence.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public final class ConnectionConfig {

    private ConnectionConfig() {}

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_boards";
        String user = "root";
        String password = "julia";
        var connection = DriverManager.getConnection(url, user, password);

        connection.setAutoCommit(false);

        return connection;
    }

}

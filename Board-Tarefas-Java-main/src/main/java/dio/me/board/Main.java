package dio.me.board;
import dio.me.board.persistence.Migration.MigrationStrategy;
import dio.me.board.ui.MainMenu;

import java.sql.SQLException;

import static dio.me.board.persistence.Config.ConnectionConfig.getConnection;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
        new MainMenu().execute();
    }
}

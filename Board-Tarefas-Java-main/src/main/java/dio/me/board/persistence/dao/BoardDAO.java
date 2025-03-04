package dio.me.board.persistence.dao;

import dio.me.board.persistence.Entity.BoardEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Optional;

public class BoardDAO {

    public final Connection connection;

    public BoardDAO(Connection connection) {
        this.connection = connection;
    }

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        String query = "INSERT INTO tb_boards (name) VALUES (?);";
        try(var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
            try(var rs = statement.getGeneratedKeys()) {
                if(rs.next()){
                    entity.setId(rs.getLong(1));
                }
            }
            return entity;
        }
    }

    public void delete(final Long id) throws SQLException {
        String query = "DELETE FROM tb_boards WHERE id = ?";
        try(var statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    public Optional<BoardEntity> findById(final Long id) throws SQLException {
        String query = "SELECT id, name FROM tb_boards WHERE id = ?";
        try(var statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()) {
                var entity = new BoardEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }


    public boolean existsById(final Long id) throws SQLException {
        String query = "SELECT 1 FROM tb_boards WHERE id = ?";
        try(var statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeQuery();
            return statement.getResultSet().next();
        }
    }
}
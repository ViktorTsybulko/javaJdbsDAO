package com.jdbc.dao.impl;

import com.jdbc.dao.AbstractJdbcDao;
import com.jdbc.dao.TrailerDao;
import com.jdbc.entity.Trailer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrailerDaoImpl extends AbstractJdbcDao implements TrailerDao {

    private static final String INSERT_QUERY = "INSERT INTO Trailer(name, duration) VALUES(?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Trailer SET id_trailer = ?, name = ?, duration = ?";
    private static final String REMOVE_QUERY = "DELETE FROM Trailer WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM Trailer";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM Trailer \n" +
            "WHERE id_trailer = ?";
    private static final String FIND_BY_NAME_QUERY = "SELECT * FROM Trailer \n" +
            "WHERE name = ?";
    private static final String FIND_BY_DURATION_QUERY = "SELECT * FROM Trailer \n" +
            "WHERE duration = ?";


    @Override
    public void create(Trailer trailer) {
        executeUpdateStatement(INSERT_QUERY, Arrays.asList(trailer.getId(),trailer.getName(),trailer.getDuration()));
    }

    @Override
    public void update(Trailer trailer) {
        executeUpdateStatement(UPDATE_QUERY,Arrays.asList(trailer.getId(), trailer.getName(), trailer.getDuration()));
    }

    @Override
    public void remove(Trailer trailer) {
        executeUpdateStatement(REMOVE_QUERY, Collections.singletonList(trailer.getId()));
    }

    @Override
    public List<Trailer> findAll() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_QUERY);
            List<Trailer> trailers = new ArrayList<>();
            while (resultSet.next()) {
                Trailer trailer = new Trailer();
                trailer.setId(resultSet.getInt(1));
                trailer.setName(resultSet.getString(2));
                trailer.setDuration(resultSet.getTime(3));
                trailers.add(trailer);

            }
            return trailers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trailer findById(Integer id) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Trailer trailer = new Trailer();
                trailer.setId(resultSet.getInt(1));
                trailer.setName(resultSet.getString(2));
                trailer.setDuration(resultSet.getTime(3));
                return trailer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trailer findByName(String name) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME_QUERY)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Trailer trailer = new Trailer();
                trailer.setId(resultSet.getInt(1));
                trailer.setName(resultSet.getString(2));
                trailer.setDuration(resultSet.getTime(3));
                return trailer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trailer findByDuration(Time duration) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_DURATION_QUERY)) {
            preparedStatement.setTime(1, duration);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Trailer trailer = new Trailer();
                trailer.setId(resultSet.getInt(1));
                trailer.setName(resultSet.getString(2));
                trailer.setDuration(resultSet.getTime(3));
                return trailer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

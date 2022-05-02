package com.jdbc.dao.impl;

import com.jdbc.dao.AbstractJdbcDao;
import com.jdbc.dao.TelecastDao;
import com.jdbc.entity.Order;
import com.jdbc.entity.Telecast;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TelecastDaoImpl extends AbstractJdbcDao implements TelecastDao {

    private static final String INSERT_QUERY = "INSERT INTO Telecast(name, rate, cost_minute) VALUES(?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Telecast SET id_telecast = ?, name = ?, rate = ?, cost_minute = ?";
    private static final String REMOVE_QUERY = "DELETE FROM Telecast WHERE id_telecast = ?";
    private static final String FIND_ALL_QUERY = "SELECT id_telecast, name, rate, cost_minute, release_date FROM Telecast\n" +
            "JOIN Orders ON id_telecast = ref_telecast";
    private static final String FIND_BY_ID_QUERY = """
            SELECT id_telecast, name, rate, cost_minute, release_date FROM Telecast
            JOIN Orders ON id_telecast = ref_telecast
            WHERE id_telecast = ?""";
    private static final String FIND_BY_NAME_QUERY = """
            SELECT id_telecast, name, rate, cost_minute, release_date FROM Telecast
            JOIN Orders ON id_telecast = ref_telecast
            WHERE name = ?""";
    private static final String FIND_BY_RATE_QUERY = """
            SELECT id_telecast, name, rate, cost_minute, release_date FROM Telecast
            JOIN Orders ON id_telecast = ref_telecast
            WHERE rate = ?;""";
    private static final String FIND_BY_COST_MINUTE_QUERY = """
            SELECT id_telecast, name, rate, cost_minute, release_date FROM Telecast
            JOIN Orders ON id_telecast = ref_telecast
            WHERE cost_minute = ?;""";

    @Override
    public void create(Telecast telecast) {
        executeUpdateStatement(INSERT_QUERY, Arrays.asList(telecast.getId(),telecast.getName(),telecast.getRate(), telecast.getCostMinute()));
    }

    @Override
    public void update(Telecast telecast) {
        executeUpdateStatement(UPDATE_QUERY, Arrays.asList(telecast.getId(), telecast.getName(), telecast.getRate(), telecast.getCostMinute()));
    }

    @Override
    public void remove(Telecast telecast) {
        executeUpdateStatement(REMOVE_QUERY, Collections.singletonList(telecast.getId()));
    }

    @Override
    public List<Telecast> findAll() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_QUERY);
            List<Telecast> telecasts = new ArrayList<>();
            while (resultSet.next()) {
                Telecast telecast = new Telecast();
                telecast.setId(resultSet.getInt(1));
                telecast.setName(resultSet.getString(2));
                telecast.setRate(resultSet.getInt(3));
                telecast.setCostMinute(resultSet.getDouble(4));
                telecast.setOrder(new Order(resultSet.getDate(5)));

                telecasts.add(telecast);
            }
            return telecasts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Telecast findById(Integer id) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Telecast telecast = new Telecast();
                telecast.setId(resultSet.getInt(1));
                telecast.setName(resultSet.getString(2));
                telecast.setRate(resultSet.getInt(3));
                telecast.setCostMinute(resultSet.getDouble(4));
                telecast.setOrder(new Order(resultSet.getDate(5)));
                return telecast;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Telecast findByName(String name) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME_QUERY)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Telecast telecast = new Telecast();
                telecast.setId(resultSet.getInt(1));
                telecast.setName(resultSet.getString(2));
                telecast.setRate(resultSet.getInt(3));
                telecast.setCostMinute(resultSet.getDouble(4));
                telecast.setOrder(new Order(resultSet.getDate(5)));
                return telecast;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Telecast findByRate(Integer rate) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_RATE_QUERY)) {
            preparedStatement.setInt(1, rate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Telecast telecast = new Telecast();
                telecast.setId(resultSet.getInt(1));
                telecast.setName(resultSet.getString(2));
                telecast.setRate(resultSet.getInt(3));
                telecast.setCostMinute(resultSet.getDouble(4));
                telecast.setOrder(new Order(resultSet.getDate(5)));
                return telecast;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Telecast findByCostMinute(Double costMinute) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COST_MINUTE_QUERY)) {
            preparedStatement.setDouble(1, costMinute);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Telecast telecast = new Telecast();
                telecast.setId(resultSet.getInt(1));
                telecast.setName(resultSet.getString(2));
                telecast.setRate(resultSet.getInt(3));
                telecast.setCostMinute(resultSet.getDouble(4));
                telecast.setOrder(new Order(resultSet.getDate(5)));
                return telecast;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

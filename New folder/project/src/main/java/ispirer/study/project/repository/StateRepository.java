package ispirer.study.project.repository;

import ispirer.study.project.database.Connector;
import ispirer.study.project.model.State;
import ispirer.study.project.model.Stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateRepository {
    public List<State> initStates() {
        List<State> states = new ArrayList<>();
        String query = "SELECT * FROM state ORDER BY code";

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                State state = new State();
                state.setCode(resultSet.getString("code"));
                state.setSname(resultSet.getString("sname"));
                states.add(state);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return states;
    }

    public State getState(String code) {
        State state = null;
        String query = "SELECT * FROM state WHERE code == \"" + code + "\"";

        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, code);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    state = new State();
                    state.setCode(resultSet.getString("code"));
                    state.setSname(resultSet.getString("sname"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }



}

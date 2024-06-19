package repo;

import model.Museum;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MuseumRepo extends AbstractRepo<Museum>{

    public MuseumRepo() throws IOException {
        super("Museum");
    }

    @Override
    public HashMap<String, Object> modelValues(Museum museum) {
        HashMap<String, Object> values = new HashMap<>();

        values.put("id", museum.getId());
        values.put("Navn", museum.getName());
        values.put("Sted", museum.getAddress());

        return values;
    }

    @Override
    public Museum resultMapper(ResultSet resultSet) throws SQLException {
        return new Museum(resultSet.getInt("id"), resultSet.getString("Navn"), resultSet.getString("Sted"));
    }

    @Override
    public int getId(Museum museum) {
        return museum.getId();
    }
}

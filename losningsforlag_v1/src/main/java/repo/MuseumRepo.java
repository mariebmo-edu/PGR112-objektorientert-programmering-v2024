package repo;

import model.Museum;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MuseumRepo extends AbstractRepo<Museum>{

    public MuseumRepo(String tableName) throws IOException {
        super(tableName);
    }

    @Override
    public Museum resultMapper(ResultSet resultSet) throws SQLException {
        return null;
    }
}

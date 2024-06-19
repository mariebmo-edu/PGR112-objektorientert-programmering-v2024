package repo;

import model.Jewelry;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JewelryRepo extends AbstractRepo<Jewelry> {

    public JewelryRepo() throws IOException {
        super("Smykke");
    }

    @Override
    public Jewelry resultMapper(ResultSet resultSet) throws SQLException {
        return null;
    }
}

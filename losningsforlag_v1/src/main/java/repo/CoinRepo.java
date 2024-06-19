package repo;

import model.Coin;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinRepo extends AbstractRepo<Coin> {

    public CoinRepo() throws IOException {
        super("Mynt");
    }

    @Override
    public Coin resultMapper(ResultSet resultSet) throws SQLException {
        return null;
    }
}

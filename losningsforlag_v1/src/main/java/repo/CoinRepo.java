package repo;

import model.Coin;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CoinRepo extends AbstractRepo<Coin> {

    public CoinRepo() throws IOException {
        super("Mynt");
    }

    @Override
    public HashMap<String, Object> modelValues(Coin coin) {
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", coin.getId());
        values.put("Antatt_årstall", coin.getEstimatedYear());
        values.put("Diameter", coin.getDiameter());
        values.put("Finner_id", coin.getFinderId());
        values.put("Funnsted", coin.getCoordinates());
        values.put("Funntidspunkt", coin.getFoundDateString());
        values.put("Metall", coin.getMetal());

        if(coin.getMuseumId() >= 0) {
            values.put("Museum_id", coin.getMuseumId());
        }

        return values;
    }

    @Override
    public Coin resultMapper(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String coordinates = resultSet.getString("Funnsted");
        int finderId = resultSet.getInt("Finner_id");
        int estimatedYear = resultSet.getInt("Antatt_årstall");
        int museumId = resultSet.getInt("Museum_id");
        int diameter = resultSet.getInt("Diameter");
        String metal = resultSet.getString("Metall");
        LocalDate foundDate = resultSet.getDate("Funntidspunkt").toLocalDate();

        return new Coin(id, coordinates, finderId, foundDate, estimatedYear, museumId, diameter, metal);
    }

    @Override
    public int getId(Coin coin) {
        return coin.getId();
    }
}

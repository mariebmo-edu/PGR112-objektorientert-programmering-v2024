package repo;

import model.Jewelry;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class JewelryRepo extends AbstractRepo<Jewelry> {

    public JewelryRepo() throws IOException {
        super("Smykke");
    }

    @Override
    public HashMap<String, Object> modelValues(Jewelry jewelry) {
        HashMap<String, Object> values = new HashMap<>();

        values.put("id", jewelry.getId());
        values.put("Antatt_årstall", jewelry.getEstimatedYear());
        values.put("filnavn", jewelry.getImgName());
        values.put("Finner_id", jewelry.getFinderId());
        values.put("Funnsted", jewelry.getCoordinates());
        values.put("Type", jewelry.getCategory());
        values.put("Verdiestimat", jewelry.getValueEstimate());

        if(jewelry.getMuseumId() > 0) {
            values.put("Museum_id", jewelry.getMuseumId());
        }

        values.put("Funntidspunkt", jewelry.getFoundDateString());

        return values;
    }

    @Override
    public Jewelry resultMapper(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String coordinates = resultSet.getString("Funnsted");
        int finderId = resultSet.getInt("Finner_id");
        int estimatedYear = resultSet.getInt("Antatt_årstall");
        int museumId = resultSet.getInt("Museum_id");
        String imgName = resultSet.getString("filnavn");
        String category = resultSet.getString("Type");
        int valueEstimate = resultSet.getInt("Verdiestimat");
        LocalDate foundDate = resultSet.getDate("Funntidspunkt").toLocalDate();

        return new Jewelry(id, coordinates, finderId, foundDate, estimatedYear, museumId, category, valueEstimate, imgName);
    }

    @Override
    public int getId(Jewelry jewelry) {
        return jewelry.getId();
    }
}

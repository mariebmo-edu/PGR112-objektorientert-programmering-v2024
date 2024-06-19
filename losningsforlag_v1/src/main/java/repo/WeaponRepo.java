package repo;

import model.Weapon;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class WeaponRepo extends AbstractRepo<Weapon> {
    public WeaponRepo() throws IOException {
        super("Vaapen");
    }

    @Override
    public HashMap<String, Object> modelValues(Weapon weapon) {
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", weapon.getId());
        values.put("Antatt_årstall", weapon.getEstimatedYear());
        values.put("Finner_id", weapon.getFinderId());
        values.put("Funnsted", weapon.getCoordinates());
        values.put("Funntidspunkt", weapon.getFoundDateString());
        values.put("Materiale", weapon.getMaterial());
        values.put("Type", weapon.getWeaponType());
        values.put("Vekt", weapon.getWeight());

        if(weapon.getMuseumId() > 0) {
            values.put("Museum_id", weapon.getMuseumId());
        }

        return values;
    }

    @Override
    public Weapon resultMapper(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String coordinates = resultSet.getString("Funnsted");
        int finderId = resultSet.getInt("Finner_id");
        int estimatedYear = resultSet.getInt("Antatt_årstall");
        int museumId = resultSet.getInt("Museum_id");
        String material = resultSet.getString("Materiale");
        String weaponType = resultSet.getString("Type");
        int weight = resultSet.getInt("Vekt");
        LocalDate foundDate = resultSet.getDate("Funntidspunkt").toLocalDate();

        return new Weapon(id, coordinates, finderId, foundDate, estimatedYear, museumId, weaponType, material, weight);
    }

    @Override
    public int getId(Weapon weapon) {
        return weapon.getId();
    }
}

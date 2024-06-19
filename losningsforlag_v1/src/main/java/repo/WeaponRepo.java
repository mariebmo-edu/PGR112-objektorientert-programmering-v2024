package repo;

import model.Weapon;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeaponRepo extends AbstractRepo<Weapon> {
    public WeaponRepo() throws IOException {
        super("Vaapen");
    }

    @Override
    public Weapon resultMapper(ResultSet resultSet) throws SQLException {
        return null;
    }
}

package repo;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Jewelry;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class JewelryRepo{

    private DataSource dataSource;

    public JewelryRepo() throws IOException {

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3307/Funn");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");

        this.dataSource = mysqlDataSource;
    }

    public ArrayList<Jewelry> getAll() {

        ArrayList<Jewelry> list = new ArrayList<>();

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();
            ResultSet resultSet = s.executeQuery("SELECT * FROM Smykke");

            while (resultSet.next()) {
                list.add(resultMapper(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insert(Jewelry jewelry) {

        if (exists(jewelry)) {
            System.out.println(jewelry.toString() + " Already exists");
            return false;
        }

        try (Connection con = dataSource.getConnection()) {
            String query = "INSERT INTO Smykke";

            query += "(id, Antatt_årstall, Finner_id, Funnsted, Funntidspunkt, Type, Verdiestimat, filnavn";

            if (jewelry.getMuseumId() >= 0) {
                query += ", Museum_id";
            }

            query += ") VALUES (?, ?, ?, ?, ?, ?, ?, ?";

            if (jewelry.getMuseumId() >= 0) {
                query += ", ?";
            }

            query += ")";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, jewelry.getId());
            ps.setInt(2, jewelry.getEstimatedYear());
            ps.setInt(3, jewelry.getFinderId());
            ps.setString(4, jewelry.getCoordinates());
            ps.setDate(5, Date.valueOf(jewelry.getFoundDate()));
            ps.setString(6, jewelry.getCategory());
            ps.setInt(7, jewelry.getValueEstimate());
            ps.setString(8, jewelry.getImgName());

            if (jewelry.getMuseumId() >= 0) {
                ps.setInt(9, jewelry.getMuseumId());
            }

            ps.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean exists(Jewelry jewelry) {

        try (Connection con = dataSource.getConnection()) {
            PreparedStatement s = con.prepareStatement("SELECT * FROM Smykke WHERE id = ?");
            s.setInt(1, jewelry.getId());
            ResultSet resultSet = s.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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

}

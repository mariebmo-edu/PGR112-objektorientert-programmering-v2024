package repo;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Coin;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoinRepo{

    protected DataSource dataSource;

    public CoinRepo() throws IOException {

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3307/Funn");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");

        this.dataSource = mysqlDataSource;

    }

    public ArrayList<Coin> getAll(){

        ArrayList<Coin> list = new ArrayList<>();

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();
            ResultSet resultSet = s.executeQuery("SELECT * FROM Mynt");

            while (resultSet.next()) {
                list.add(resultMapper(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(Coin coin){

        if(exists(coin)){
            System.out.println(coin.toString() + " Already exists");
            return false;
        }

        try (Connection con = dataSource.getConnection()) {
            String query = "INSERT INTO Mynt";

            query += "(id, Antatt_årstall, Diameter, Finner_id, Funnsted, Funntidspunkt, Metall";

            if(coin.getMuseumId() >= 0) {
                query += ", Museum_id";
            }

            query += ") VALUES (?, ?, ?, ?, ?, ?, ?";
            if(coin.getMuseumId() >= 0) {
                query += ", ?";
            }
            query += ")";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, coin.getId());
            ps.setInt(2, coin.getEstimatedYear());
            ps.setInt(3, coin.getDiameter());
            ps.setInt(4, coin.getFinderId());
            ps.setString(5, coin.getCoordinates());
            ps.setDate(6, Date.valueOf(coin.getFoundDate()));
            ps.setString(7, coin.getMetal());

            if(coin.getMuseumId() >= 0) {
                ps.setInt(8, coin.getMuseumId());
            }


            ps.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean exists(Coin coin){
        try (Connection con = dataSource.getConnection()) {
            PreparedStatement s = con.prepareStatement("SELECT * FROM Mynt WHERE id = ?");
            s.setInt(1, coin.getId());
            ResultSet resultSet = s.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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
}

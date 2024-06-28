package repo;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Museum;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.nio.file.Files.exists;

public class MuseumRepo {

    DataSource dataSource;

    public MuseumRepo() throws IOException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3307/Funn");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");

        this.dataSource = mysqlDataSource;
    }

    public ArrayList<Museum> getAll() {
        ArrayList<Museum> list = new ArrayList<>();

        try (var con = dataSource.getConnection()) {
            var s = con.createStatement();
            var resultSet = s.executeQuery("SELECT * FROM Museum");

            while (resultSet.next()) {
                list.add(resultMapper(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(Museum museum) {
        if (exists(museum)) {
            System.out.println(museum.toString() + " Already exists");
            return false;
        }

        try (var con = dataSource.getConnection()) {
            String query = "INSERT INTO Museum";

            query += "(id, Navn, Sted) VALUES (?, ?, ?)";

            var preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, museum.getId());
            preparedStatement.setString(2, museum.getName());
            preparedStatement.setString(3, museum.getAddress());

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean exists(Museum museum) {
        try (var con = dataSource.getConnection()) {
            var s = con.createStatement();
            var resultSet = s.executeQuery("SELECT * FROM Museum WHERE id = ?");
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Museum resultMapper(ResultSet resultSet) throws SQLException {
        return new Museum(resultSet.getInt("id"), resultSet.getString("Navn"), resultSet.getString("Sted"));
    }

}

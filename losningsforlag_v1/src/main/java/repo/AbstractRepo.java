package repo;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public abstract class AbstractRepo<T> {

    protected DataSource dataSource;
    protected String tableName;

    public AbstractRepo(String tableName) throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("src/main/resources/environment.properties");
        properties.load(fileReader);

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(properties.getProperty("REPO_URL"));
        mysqlDataSource.setUser(properties.getProperty("REPO_USERNAME"));
        mysqlDataSource.setPassword(properties.getProperty("REPO_PASSWORD"));

        this.dataSource = mysqlDataSource;
        this.tableName = tableName;
    }

    public boolean Insert(String query) {

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();
            s.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean Exists(String query) {

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();
            ResultSet resultSet = s.executeQuery(query);

            if (!resultSet.next()) {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean Update(String query) {

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();
            s.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<T> RetrieveAll() {

        ArrayList<T> arrayList = new ArrayList<>();

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();

            String query = "SELECT * FROM " + tableName;

            ResultSet resultSet = s.executeQuery(query);

            while (resultSet.next()) {
                T result = resultMapper(resultSet);
                arrayList.add(result);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }

    public T RetrieveById(String query) {

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();

            ResultSet resultSet = s.executeQuery(query);

            if (resultSet.next()) {
                return resultMapper(resultSet);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public T RetrieveByConditions(String query) {

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();

            ResultSet resultSet = s.executeQuery(query);

            if (resultSet.next()) {
                return resultMapper(resultSet);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<T> RetrieveAllWithId(String query) {

        ArrayList<T> arrayList = new ArrayList<>();

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();

            ResultSet resultSet = s.executeQuery(query);

            while (resultSet.next()) {
                T result = resultMapper(resultSet);
                arrayList.add(result);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }

    public boolean Delete(String query) {

        try (Connection con = dataSource.getConnection()) {
            Statement s = con.createStatement();
            s.executeQuery(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public abstract T resultMapper(ResultSet resultSet) throws SQLException;
}
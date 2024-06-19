package repo;

import model.Person;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepo extends AbstractRepo<Person>{
    public PersonRepo() throws IOException {
        super("Person");
    }

    @Override
    public Person resultMapper(ResultSet resultSet) throws SQLException {
        return null;
    }
}

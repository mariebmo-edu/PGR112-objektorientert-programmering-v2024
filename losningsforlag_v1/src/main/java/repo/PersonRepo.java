package repo;

import model.Person;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PersonRepo extends AbstractRepo<Person>{
    public PersonRepo() throws IOException {
        super("Person");
    }

    @Override
    public HashMap<String, Object> modelValues(Person person) {
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", person.getId());
        values.put("Navn", person.getName());
        values.put("E_post", person.getEmail());
        values.put("Tlf", person.getPhoneNumber());

        return values;
    }

    @Override
    public Person resultMapper(ResultSet resultSet) throws SQLException {
        return new Person(resultSet.getInt("id"), resultSet.getString("Navn"), resultSet.getString("Tlf"), resultSet.getString("E_post"));
    }

    @Override
    public int getId(Person person) {
        return person.getId();
    }
}

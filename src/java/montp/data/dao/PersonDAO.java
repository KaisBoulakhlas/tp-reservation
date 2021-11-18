package montp.data.dao;

import montp.data.model.resource.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonDAO extends GenericDAO<Person>  {
    public PersonDAO() {
        super(Person.class);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersons() {
        return em.createQuery("SELECT p FROM Person p ORDER BY p.name")
                .getResultList();
    }


}

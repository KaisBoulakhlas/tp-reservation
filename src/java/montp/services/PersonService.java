package montp.services;


import montp.data.dao.PersonDAO;
import montp.data.dao.ResourceDAO;
import montp.data.model.resource.Person;
import montp.data.model.resource.Resource;
import montp.data.model.security.Group;
import montp.data.model.security.User;
import montp.tools.Tools;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;


@ApplicationScoped
public class PersonService extends GenericService<Person, PersonDAO>{
    public List<Person> getPersons() {
        return dao.getPersons();
    }

    @Transactional
    public void insert(Person person) {
        person.setPersonFirstname(person.getPersonFirstname());
        person.setPersonName(person.getPersonName());
        person.setUserName(person.getUserName());
        super.insert(person);
    }

}

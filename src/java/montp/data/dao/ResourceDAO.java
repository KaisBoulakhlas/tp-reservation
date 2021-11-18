package montp.data.dao;

import montp.data.model.resource.Person;
import montp.data.model.resource.Resource;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ResourceDAO extends GenericDAO<Resource>  {
    public ResourceDAO() {
        super(Resource.class);
    }

    @SuppressWarnings("unchecked")
    public List<Resource> getResources() {
        return em.createQuery("SELECT r FROM Resource r ORDER BY r.resourceName")
                .getResultList();
    }

    public List<Person> getPersons(){
        return em.createQuery("SELECT p FROM Person p ORDER BY p.firstname")
                .getResultList();
    }
}

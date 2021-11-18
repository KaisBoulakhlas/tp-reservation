package montp.services;

import montp.data.dao.ResourceDAO;
import montp.data.model.resource.Person;
import montp.data.model.resource.Resource;
import montp.data.model.resource.ResourceType;
import montp.web.UserSession;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ResourceService extends GenericService<Resource, ResourceDAO>{

    @Inject
    private UserSession userSession;

    public List<Resource> getResources() {
        return dao.getResources();
    }

    public List<Person> getPersons() {
        return dao.getPersons();
    }

    @Transactional
    public void insert(Resource resource) {
        resource.setResourceName(resource.getResourceName());
        resource.setResourceType(resource.getResourceType());
        resource.setResponsable(resource.getResponsable());
        if(Objects.equals(resource.getResourceType().toString(), "Salle")){
            resource.setPartage();
        }
        super.insert(resource);
    }

    public void delete(Resource resource) {
        dao.delete(resource);
    }

   // public boolean canDelete(Resource resource) {
   //     return Objects.equals(resource.getResponsable().getStatut(), "Gestionnaire");

  //  }
}

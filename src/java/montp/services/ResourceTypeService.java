package montp.services;

import montp.data.dao.ResourceTypeDAO;
import montp.data.model.resource.ResourceType;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ResourceTypeService extends GenericService<ResourceType, ResourceTypeDAO> {

    @Inject
    private Event<ResourceType> event;

    public List<ResourceType> getResourceTypes() {
        return dao.getResourcesType();
    }

    public void delete(ResourceType resourceType) {
        dao.delete(resourceType);
    }

    public boolean canDelete(ResourceType resourceType) {
        return resourceType.getResources().size() == 0;
    }
}

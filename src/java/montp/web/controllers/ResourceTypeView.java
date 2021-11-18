package montp.web.controllers;

import montp.data.dao.ResourceTypeDAO;
import montp.data.model.resource.ResourceType;
import montp.services.ResourceTypeService;
import montp.tools.Logger;
import montp.web.FacesTools;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named("resourceTypeView")
public class ResourceTypeView extends AbstractDataTableView<ResourceType, ResourceTypeDAO,ResourceTypeService>{

    @Inject
    private ResourceTypeService resourceTypeService;

    @Inject private AddDialogResourceType addDialogResourceType;

    @PostConstruct
    public void init() {
        Logger.log(Logger.LogLevel.INFO, ResourceTypeView.class.getSimpleName(), "initializing view controller");
    }

    public List<ResourceType> getResourceTypes() { return resourceTypeService.getResourceTypes(); }

    public void deleteResourceType(ResourceType resourceType) {
        resourceTypeService.delete(resourceType);
    }

    public boolean canDelete(ResourceType resourceType) {
        return resourceTypeService.canDelete(resourceType);
    }



}

package montp.web.controllers;

import montp.data.dao.ResourceDAO;
import montp.data.model.resource.Resource;
import montp.data.model.resource.ResourceType;
import montp.services.ResourceService;
import montp.services.ResourceTypeService;
import montp.tools.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named("resourceView")
public class ResourceView extends AbstractDataTableView<Resource, ResourceDAO, ResourceService>{

    @Inject
    private ResourceService resourceService;

    @PostConstruct
    public void init() {
        Logger.log(Logger.LogLevel.INFO, ResourceView.class.getSimpleName(), "initializing view controller");
    }

    public List<Resource> getResources() { return resourceService.getResources(); }
}

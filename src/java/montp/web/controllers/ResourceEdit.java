package montp.web.controllers;

import montp.data.dao.ResourceDAO;
import montp.data.model.resource.Person;
import montp.data.model.resource.Resource;
import montp.services.ResourceService;
import montp.tools.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named("resourceEdit")
public class ResourceEdit extends AbstractResourceCrud<Resource, ResourceDAO, ResourceService> {

    @Inject
    private ResourceService resourceService;

    public void instanciate() {
        instance = new Resource();
    }

    @PostConstruct
    public void init() {
        Logger.log(Logger.LogLevel.INFO, ResourceEdit.class.getSimpleName(), "initializing view controller");
    }

    public List<Person> getPersons(){
        return resourceService.getPersons();
    }
}
package montp.web.controllers;


import montp.data.dao.ResourceTypeDAO;
import montp.data.model.resource.ResourceType;
import montp.services.ResourceTypeService;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("addDialogResourceType")
public class AddDialogResourceType extends AbstractDialog<ResourceType, ResourceTypeDAO, ResourceTypeService> {

    @Override
    public void instanciate() {
        instance = new ResourceType();
    }



}

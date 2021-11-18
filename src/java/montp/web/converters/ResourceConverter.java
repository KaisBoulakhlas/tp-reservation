package montp.web.converters;

import montp.data.dao.ResourceDAO;
import montp.data.model.resource.Resource;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Resource.class)
public class ResourceConverter extends GenericConverter<Resource> {

    public ResourceConverter() {
        super(Tools.lookupBean(ResourceDAO.class));
    }

}
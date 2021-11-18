package montp.data.model.resource;

import montp.data.model.GenericEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESOURCE")
public class Resource extends GenericEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String resourceName;

    @ManyToOne
    private ResourceType resourceType;

    @ManyToOne()
    private Person responsable;

    @ManyToOne
    private Person reserve;

    public Resource(String resourceName, ResourceType resourceType, Person responsable) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.responsable = responsable;
    }

    @Column(nullable = false)
    private Boolean partage = false;

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Resource(String resourceName) {
        this.resourceName = resourceName;
    }

    public Resource() {

    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Person getResponsable() {
        return responsable;
    }

    public void setResponsable(Person responsable) {
        this.responsable = responsable;
    }

    public Boolean getPartage() {
        return partage;
    }

    public void setPartage() {
        this.partage = !partage;
    }

    @Override
    public String toString() {
        return resourceName;
    }
}

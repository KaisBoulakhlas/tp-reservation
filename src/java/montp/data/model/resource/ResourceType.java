package montp.data.model.resource;

import montp.data.model.GenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "RESOURCE_TYPE")
public class ResourceType extends GenericEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column()
    private Integer capacity;

    @OneToMany(mappedBy="resourceType")
    private List<Resource> resources;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public ResourceType(String name) {
        this.name = name;
    }

    public ResourceType() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

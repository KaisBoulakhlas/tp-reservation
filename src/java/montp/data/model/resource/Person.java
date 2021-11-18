package montp.data.model.resource;

import montp.data.model.security.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Person extends User {
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String firstname;

    @OneToMany(mappedBy="responsable")
    private List<Resource> resources;

    @OneToMany(mappedBy="personne")
    private List<Reservation> reservations;

    public Person() {
    }

    public Person(String userName, String password, String firstname, String name) {
        super(userName, password);
        this.name = name;
        this.firstname = firstname;
    }

    public String getPersonName() {
        return name;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    public String getPersonFirstname() {
        return firstname;
    }

    public void setPersonFirstname(String firstname) {
        this.firstname = firstname;
    }


    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

}

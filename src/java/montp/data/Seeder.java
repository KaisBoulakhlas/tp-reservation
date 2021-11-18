package montp.data;

import montp.data.model.resource.Person;
import montp.data.model.resource.Reservation;
import montp.data.model.resource.Resource;
import montp.data.model.resource.ResourceType;
import montp.data.model.security.Group;
import montp.data.model.security.User;
import montp.services.PersonService;
import montp.services.ReservationService;
import montp.services.ResourceService;
import montp.services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.util.*;

@Singleton
@Startup
public class Seeder {
    
    @Inject
    private UserService userService;

    @Inject
    private PersonService personService;

    @Inject
    private ReservationService reservationService;

    @Inject
    private ResourceService resourceService;

    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    public void init() {
        if (userService.getGroup("USER") == null) {
            Group groupUser = new Group("USER");
            em.persist(groupUser);
            Group groupAdmin = new Group("ADMIN");
            em.persist(groupAdmin);
            User userUser1 = new User("user1", "user1");
            List<Group> groupes = new ArrayList<>();
            groupes.add(groupUser);
            userUser1.setGroups(groupes);
            userService.insert(userUser1);
            User userAdmin = new User("admin", "admin");
            groupes.add(groupAdmin);
            userAdmin.setGroups(groupes);
            userService.insert(userAdmin);

            ResourceType resourceType1 = new ResourceType();
            resourceType1.setName("Salle");
            resourceType1.setCapacity(35);
            em.persist(resourceType1);

            ResourceType resourceType2 = new ResourceType();
            resourceType2.setName("Vidéo");
            em.persist(resourceType2);

            for (int i = 0; i < 5; i++) {
                personService.insert(new Person(
                        String.format("Username%d", i),
                        String.format("Password%d", i),
                        String.format("PersonFirstName%d", i),
                        String.format("PersonName%d", i)));
            }

            Person person1 = new Person("kaiis", "kaiis", "Kais", "Boulakhlas");
            personService.insert(person1);

            Resource resource = new Resource("Salle de classe", resourceType1, person1);
            resourceService.insert(resource);

            Resource resource2 = new Resource("Cinéma", resourceType2, person1);
            resourceService.insert(resource2);

            for (int i = 0; i < 35; i++) {
                resourceService.insert(new Resource(
                        String.format("ResourceName%d", i),
                        resourceType1,
                        person1));
            }


            Calendar dateDebut = new GregorianCalendar();
            dateDebut.set(2021, Calendar.DECEMBER, 1);
            Calendar dateFin = new GregorianCalendar();
            dateFin.set(2022, Calendar.JANUARY, 2);
            reservationService.insert(new Reservation(person1,resource2,dateDebut.getTime(),dateFin.getTime(),4));
        }
    }

}

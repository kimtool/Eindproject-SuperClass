package nl.jajaro.auth.auth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // Handig om het goed op te slaan in database en om de CrudRepository te kunnen maken
                                        // In theorie kan je ook de naam gebruiken als Id maar een nummer is fijner voor de database :-)

    private String email;               // Als login wil ik email gebruiken
    private String password;


    // Met de Annontaties hieronder weet Spring hoe de tabellen gekoppeld moeten worden
    // Ik beschrijf een ManyToMany relatie tussen deze tabel User en de Tabel die de
    // 'roles' bevat uit de Collection<Role>  roles
    // In de tabel 'Role' is de andere kant van deze relatie beschreven
    // Omdat het een ManyToMany relatie is zal Spring een Extra tussen-tabel maken
    // met de naam 'user_roles'
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;     // Dit geeft een overzicht van de rechten van de user
                                        // De user krijgt een of meer Rollen
                                        // Iedere Rol bestaat weer uit een of meer Privilages


     // Je kan verder zovel velden extra maken als je wil
    private String name;
    private String whateveryouneed;
    private String whateveryouwant;

    // Een lege default constructor.  Deze wordt door Spring gebruikt bij het maken van records.
    // Als je deze niet hebt krijg je foutmeldingen.
    public User() {
     }

    public User(boolean isLazy) {
        if (isLazy)
            roles = new ArrayList<>();
    }

    // Hieronder zijn alle methodes die de Interface UserDetails verplicht te maken
    // De meeste spreken voor zich maar de getAuthorities() is niet zo vanzelf sprekend...
    // De methode getAuthorities() hieronder, wordt straks bij het inloggen gebruikt door Spring om alle Rollen en, let op!, ook alle Privilages op
    // te vragen.  De rollen als bv.  USER ADMIN SUPERVISOR ...  moeten worden opgeslagen als ROLE_USER, ROLE_ADMIN.. enz
    // Het standerd voorvoegsel ROLE_ kan je vast ook wel ergens aanpassen als je wil... Maar vooralsnog moet je het toepassen!
    // De Privilages worden zonder voorvoegsel opgegeven. Je krijgt dan bv. iets terug als:
    //
    //  Stel, gebruiker robbie@gmail.com heeft de rol USER en de rol Admin dan moet
    //  getAutorities() voor deze user onderstaande lijst terugeven :

    // ROLE_USER
    // READ_PRIVILEGE
    // ROLE_ADMIN
    // WRITE_PRIVILEGE

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add roles
        roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        // Add privileges foreach role
        roles.stream().forEach(role -> role.getPrivileges().stream().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName()))));
        authorities.stream().forEach(a -> System.out.println(a.getAuthority()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;  // want ik wil inloggen met mijn username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // deze gebruik ik niet dus geef ik default True terug
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // deze gebruik ik niet dus geef ik default True terug
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // deze gebruik ik niet dus geef ik default True terug
    }

    @Override
    public boolean isEnabled() {
        return true; // deze gebruik ik niet dus geef ik default True terug
    }

    // Getters and Setters voor de rest van de velden
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhateveryouneed() {
        return whateveryouneed;
    }

    public void setWhateveryouneed(String whateveryouneed) {
        this.whateveryouneed = whateveryouneed;
    }

    public String getWhateveryouwant() {
        return whateveryouwant;
    }

    public void setWhateveryouwant(String whateveryouwant) {
        this.whateveryouwant = whateveryouwant;
    }
}
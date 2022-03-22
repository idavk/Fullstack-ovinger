package no.ntnu.IDATT2105.oving_5_backend.models.User;


import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorResponse;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;
    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CalculatorResponse> calculations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return password;
    }

    public void setPassword(String passw) {
        this.password = passw;
    }
}

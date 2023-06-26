package rw.isite.ne.auth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import rw.isite.ne.auth.enums.EGender;
import rw.isite.ne.auth.enums.ERole;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"phone"})})
@OnDelete(action = OnDeleteAction.CASCADE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotBlank
    @Column(name = "password")
    private String password;

    public Customer(String firstname, String lastname, String phoneNumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Customer(String firstname, String lastname, String phoneNumber, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return this.firstname + " " + this.lastname;
    }
}

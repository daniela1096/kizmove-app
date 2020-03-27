package co.com.kizmove.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@Table(name="Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="id_person")
    private Long id;

    @NotEmpty
    @Column(name="name")
    private String name;

    @NotEmpty
    @Column(name="last_name")
    private String lastName;

    @NotEmpty
    @Email
    @Column(name="email")
    private String email;


    @Column(name="phone_number")
    private String phoneNumber;
}

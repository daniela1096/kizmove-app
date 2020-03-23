package co.com.kizmove.domain;


import lombok.Data;

import javax.persistence.*;
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
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
}

package vti.dtn.account_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
}

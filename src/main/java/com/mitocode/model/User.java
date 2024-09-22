package com.mitocode.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_data")

public class User {

    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 50, unique = true)
    private String userName;
    @Column(nullable = false, length = 60) // Bcrypt
    private String password;

    @Column(nullable = false) 
    private boolean enabled;

     @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    
        joinColumns = @JoinColumn(name = "id_user", referencedColumnName  ="idUser"),
        inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole")
    )
    private List<Role> roles;


}

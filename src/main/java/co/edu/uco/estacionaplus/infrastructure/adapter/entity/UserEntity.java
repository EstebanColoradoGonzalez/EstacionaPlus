package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="users_code_seq")
    @SequenceGenerator(name="users_code_seq", sequenceName="users_code_seq", allocationSize=1)
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "userrole")
    private UserRoleEntity userRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle")
    private VehicleEntity vehicle;
}
package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "userrole")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="userrole_code_seq")
    @SequenceGenerator(name="userrole_code_seq", sequenceName="userrole_code_seq", allocationSize=1)
    private int code;
    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;
}
package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="role_code_seq")
    @SequenceGenerator(name="role_code_seq", sequenceName="role_code_seq", allocationSize=1)
    private int code;
    private String name;
}
package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "state")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StateEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="state_code_seq")
    @SequenceGenerator(name="state_code_seq", sequenceName="state_code_seq", allocationSize=1)
    private int code;
    private String name;
}
package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="city_code_seq")
    @SequenceGenerator(name="city_code_seq", sequenceName="city_code_seq", allocationSize=1)
    private int code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "state")
    private StateEntity state;
}
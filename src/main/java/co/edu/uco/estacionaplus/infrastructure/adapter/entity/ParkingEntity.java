package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    private String nit;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "city")
    private CityEntity city;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "place")
    private List<PlaceEntity> places;
}
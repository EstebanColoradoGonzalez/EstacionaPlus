package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "parkingplace")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingPlaceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="parkingplace_code_seq")
    @SequenceGenerator(name="parkingplace_code_seq", sequenceName="parkingplace_code_seq", allocationSize=1)
    private int code;
    private boolean taken;
    @ManyToOne
    @JoinColumn(name = "place")
    private PlaceEntity place;
}

package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="vehicle_code_seq")
    @SequenceGenerator(name="vehicle_code_seq", sequenceName="vehicle_code_seq", allocationSize=1)
    private int code;
    private String license;
    @ManyToOne
    @JoinColumn(name = "typevehicle")
    private TypeVehicleEntity typeVehicle;
}
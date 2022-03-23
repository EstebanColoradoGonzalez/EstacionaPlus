package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "typevehicle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypeVehicleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="typevehicle_code_seq")
    @SequenceGenerator(name="typevehicle_code_seq", sequenceName="typevehicle_code_seq", allocationSize=1)
    private int code;
    private String name;
}
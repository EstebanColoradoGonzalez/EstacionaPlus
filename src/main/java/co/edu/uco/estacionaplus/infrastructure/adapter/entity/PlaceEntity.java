package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="place_code_seq")
    @SequenceGenerator(name="place_code_seq", sequenceName="place_code_seq", allocationSize=1)
    private int code;
    private String position;
    @ManyToOne
    @JoinColumn(name = "typeplace")
    private TypePlaceEntity typePlace;
}
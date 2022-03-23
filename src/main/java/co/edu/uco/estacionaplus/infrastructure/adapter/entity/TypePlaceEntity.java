package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "typeplace")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypePlaceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="typeplace_code_seq")
    @SequenceGenerator(name="typeplace_code_seq", sequenceName="typeplace_code_seq", allocationSize=1)
    private int code;
    private String name;
}
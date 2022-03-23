package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "price")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PriceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="price_code_seq")
    @SequenceGenerator(name="price_code_seq", sequenceName="price_code_seq", allocationSize=1)
    private int code;
    private double value;
}
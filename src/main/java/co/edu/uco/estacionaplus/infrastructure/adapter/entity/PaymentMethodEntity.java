package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "paymentmethod")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentMethodEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="paymentmethod_code_seq")
    @SequenceGenerator(name="paymentmethod_code_seq", sequenceName="paymentmethod_code_seq", allocationSize=1)
    private int code;
    private String name;
}
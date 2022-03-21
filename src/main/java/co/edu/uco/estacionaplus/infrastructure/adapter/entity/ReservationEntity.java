package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    private Date date;
    private String arrivalTime;
    private String departureTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservedtime")
    private ReservedTimeEntity reservedTime;
    @ManyToOne
    @JoinColumn(name = "price")
    private PriceEntity price;
    @ManyToOne
    @JoinColumn(name = "place")
    private PlaceEntity place;
    @ManyToOne
    @JoinColumn(name = "paymentmethod")
    private PaymentMethodEntity paymentMethod;
    @ManyToOne
    @JoinColumn(name = "users")
    private UserEntity user;
}
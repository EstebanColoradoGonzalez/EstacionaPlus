package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="reservation_code_seq")
    @SequenceGenerator(name="reservation_code_seq", sequenceName="reservation_code_seq", allocationSize=1)
    private int code;
    private LocalDate date;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservedtime")
    private ReservedTimeEntity reservedTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price")
    private PriceEntity price;
    @ManyToOne
    @JoinColumn(name = "parkingplace")
    private ParkingPlaceEntity place;
    @ManyToOne
    @JoinColumn(name = "paymentmethod")
    private PaymentMethodEntity paymentMethod;
    @ManyToOne
    @JoinColumn(name = "users")
    private UserEntity user;
}
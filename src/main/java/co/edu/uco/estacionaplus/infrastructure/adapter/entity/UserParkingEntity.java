package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "userparking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserParkingEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    @ManyToOne
    @JoinColumn(name = "users")
    private UserEntity user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking")
    private ParkingEntity parking;
}
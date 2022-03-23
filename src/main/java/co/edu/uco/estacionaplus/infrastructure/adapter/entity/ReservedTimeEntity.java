package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "reservedtime")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservedTimeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="reservedtime_code_seq")
    @SequenceGenerator(name="reservedtime_code_seq", sequenceName="reservedtime_code_seq", allocationSize=1)
    private int code;
    private int value;
    private String typeTime;
}
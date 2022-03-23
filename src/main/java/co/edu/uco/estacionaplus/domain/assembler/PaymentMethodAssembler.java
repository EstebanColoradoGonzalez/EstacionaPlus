package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.PaymentMethodDTO;
import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PaymentMethodEntity;

public interface PaymentMethodAssembler extends Assembler<PaymentMethod, PaymentMethodEntity, PaymentMethodDTO>
{
}

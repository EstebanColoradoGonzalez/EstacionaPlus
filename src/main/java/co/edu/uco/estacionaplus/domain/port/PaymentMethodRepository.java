package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository
{
    List<PaymentMethod> getAll();
    PaymentMethod getByCode(int code);
    boolean exists(PaymentMethod paymentMethod);
}

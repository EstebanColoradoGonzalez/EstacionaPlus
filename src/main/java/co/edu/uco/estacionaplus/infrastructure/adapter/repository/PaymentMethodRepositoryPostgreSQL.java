package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.port.PaymentMethodRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PaymentMethodEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PaymentMethodDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PaymentMethodRepositoryPostgreSQL implements PaymentMethodRepository
{
    private final PaymentMethodDAO paymentMethodDAO;

    public PaymentMethodRepositoryPostgreSQL(PaymentMethodDAO paymentMethodDAO)
    {
        this.paymentMethodDAO = paymentMethodDAO;
    }

    @Override
    public List<PaymentMethod> getAll()
    {
        return this.paymentMethodDAO.findAll().stream().map(this::assemblePaymentMethod).toList();
    }

    @Override
    public PaymentMethod getByCode(int code)
    {
        return this.paymentMethodDAO.findById(code).map(this::assemblePaymentMethod).orElse(null);
    }

    @Override
    public boolean exists(PaymentMethod paymentMethod)
    {
        return this.paymentMethodDAO.existsById(paymentMethod.getCode());
    }

    private PaymentMethod assemblePaymentMethod(PaymentMethodEntity paymentMethod)
    {
        return PaymentMethod.create(paymentMethod.getCode(), paymentMethod.getName());
    }
}
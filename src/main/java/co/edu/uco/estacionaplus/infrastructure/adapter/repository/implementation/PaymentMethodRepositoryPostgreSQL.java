package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.port.PaymentMethodRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PaymentMethodDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PaymentMethodAssemblerImplementation.getPaymentMethodAssembler;

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
        return this.paymentMethodDAO.findAll().stream().map(getPaymentMethodAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public PaymentMethod getByCode(int code)
    {
        return this.paymentMethodDAO.findById(code).map(getPaymentMethodAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public boolean exists(PaymentMethod paymentMethod)
    {
        return this.paymentMethodDAO.existsById(paymentMethod.getCode());
    }
}
package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.PaymentMethodDTO;
import co.edu.uco.estacionaplus.domain.assembler.PaymentMethodAssembler;
import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PaymentMethodEntity;

public class PaymentMethodAssemblerImplementation implements PaymentMethodAssembler
{
    private static final PaymentMethodAssembler INSTANCE = new PaymentMethodAssemblerImplementation();

    private PaymentMethodAssemblerImplementation()
    {

    }

    public static PaymentMethodAssembler getPaymentMethodAssembler()
    {
        return INSTANCE;
    }

    @Override
    public PaymentMethod assembleDomainFromEntity(PaymentMethodEntity entity)
    {
        return PaymentMethod.create(entity.getCode(), entity.getName());
    }

    @Override
    public PaymentMethodEntity assembleEntityFromDomain(PaymentMethod domain)
    {
        return new PaymentMethodEntity(domain.getCode(), domain.getName());
    }

    @Override
    public PaymentMethod assembleDomainFromDTO(PaymentMethodDTO dto)
    {
        return PaymentMethod.create(dto.getCode(), dto.getName());
    }

    @Override
    public PaymentMethodDTO assembleDTOFromDomain(PaymentMethod domain)
    {
        return new PaymentMethodDTO(domain.getCode(), domain.getName());
    }
}
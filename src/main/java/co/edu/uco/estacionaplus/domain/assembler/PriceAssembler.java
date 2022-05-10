package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.PriceDTO;
import co.edu.uco.estacionaplus.domain.model.Price;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PriceEntity;

public interface PriceAssembler extends Assembler<Price, PriceEntity, PriceDTO>
{
}
package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.CityDTO;
import co.edu.uco.estacionaplus.domain.model.City;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.CityEntity;

public interface CityAssembler extends Assembler<City, CityEntity, CityDTO>
{
}

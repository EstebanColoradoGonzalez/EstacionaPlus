package co.edu.uco.estacionaplus.domain.assembler;

public interface Assembler<D, E, T>
{
    D assembleDomainFromEntity(E entity);

    E assembleEntityFromDomain(D domain);

    D assembleDomainFromDTO(T dto);

    T assembleDTOFromDomain(D domain);
}

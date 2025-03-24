package org.sid.personnecore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.personnecore.coreDTO.PersonneCoreDTO;
import org.sid.personnecore.module.Personne;


@Mapper(componentModel = "spring")
public interface PersonneMapper {
    PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);
    PersonneCoreDTO personneToPersonneCoreDTO(Personne personne);
    Personne personneCoreDTOToPersonne(PersonneCoreDTO personneCoreDTO);
}

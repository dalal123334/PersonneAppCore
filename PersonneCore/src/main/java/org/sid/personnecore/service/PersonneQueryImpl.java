package org.sid.personnecore.service;

import lombok.AllArgsConstructor;
import org.sid.personnecore.coreDTO.PersonneCoreDTO;
import org.sid.personnecore.mapper.PersonneMapper;
import org.sid.personnecore.module.Personne;
import org.sid.personnecore.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonneQueryImpl implements IPersonneQuery {

    private PersonneRepository personneRepository;
    private PersonneMapper personneMapper;
    @Override
    public List<PersonneCoreDTO> getAllPersonnes() {
        List<Personne> personnes = personneRepository.findAll();
        return personnes.stream().map(personneMapper::personneToPersonneCoreDTO).collect(Collectors.toList());
    }
    @Override
    public PersonneCoreDTO getPersonneById(Long id) {
        Optional<Personne> personneOptional = personneRepository.findById(id);
        if (personneOptional.isPresent()) {
            return personneMapper.personneToPersonneCoreDTO(personneOptional.get());
        } else {

            return null;
    }
    }
}

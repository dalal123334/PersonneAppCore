package org.sid.personnecore.service;

import lombok.AllArgsConstructor;
import org.sid.personnecore.coreDTO.PersonneCoreDTO;
import org.sid.personnecore.mapper.PersonneMapper;
import org.sid.personnecore.module.Personne;
import org.sid.personnecore.repository.PersonneRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonneServiceImpl implements IPersonneService {
    private PersonneRepository personneRepository;
    private PersonneMapper personneMapper;


    @Override
    public PersonneCoreDTO creerPersonne(PersonneCoreDTO personneCoreDTO) {
        Personne personne = personneMapper.personneCoreDTOToPersonne(personneCoreDTO);
        Personne savedPersonne = personneRepository.save(personne);
        return personneMapper.personneToPersonneCoreDTO(savedPersonne);
    }


    @Override
    public PersonneCoreDTO updatePersonne(Long id, PersonneCoreDTO personneCoreDTO) {

        Optional<Personne> personneOptional = personneRepository.findById(id);
        if (personneOptional.isPresent()) {
            Personne personne = personneOptional.get();

            personne.setNom(personneCoreDTO.getNom());
            personne.setPrenom(personneCoreDTO.getPrenom());
            personne.setAdresse(personneCoreDTO.getAdresse());


            Personne updatedPersonne = personneRepository.save(personne);
            return personneMapper.personneToPersonneCoreDTO(updatedPersonne);
        } else {
            return null;
        }
    }

    @Override
    public void deletePersonne(Long id) {

        Optional<Personne> personneOptional = personneRepository.findById(id);
        if (personneOptional.isPresent()) {

            personneRepository.delete(personneOptional.get());
        } else {
            System.out.println("Personne avec l'ID " + id + " non trouvée.");
        }
    }
}


package org.sid.personnecore.service;



import org.sid.personnecore.coreDTO.PersonneCoreDTO;

public interface IPersonneService {
    PersonneCoreDTO creerPersonne (PersonneCoreDTO personneCoreDTO);
    PersonneCoreDTO updatePersonne(Long id, PersonneCoreDTO personneCoreDTO);
    void deletePersonne(Long id) ;
}

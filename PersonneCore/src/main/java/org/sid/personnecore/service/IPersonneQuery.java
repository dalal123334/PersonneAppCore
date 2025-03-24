package org.sid.personnecore.service;
import org.sid.personnecore.coreDTO.PersonneCoreDTO;

import java.util.List;

public interface IPersonneQuery {
    List<PersonneCoreDTO> getAllPersonnes();
    PersonneCoreDTO getPersonneById(Long id);
}


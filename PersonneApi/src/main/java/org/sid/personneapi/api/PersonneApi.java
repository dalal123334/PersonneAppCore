package org.sid.personneapi.api;

import lombok.AllArgsConstructor;
import org.sid.personnecore.coreDTO.PersonneCoreDTO;
import org.sid.personnecore.service.IPersonneQuery;
import org.sid.personnecore.service.IPersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnes")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PersonneApi {

    private final IPersonneService iPersonneService;
    private final IPersonneQuery iPersonneQuery;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('BFF_creerPersonne')")
    public ResponseEntity<PersonneCoreDTO> creerPersonne(@RequestBody PersonneCoreDTO personneCoreDTO) {
        PersonneCoreDTO savedPersonne = iPersonneService.creerPersonne(personneCoreDTO);
        return new ResponseEntity<>(savedPersonne, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('BFF_updatePersonne')")
    public ResponseEntity<PersonneCoreDTO> updatePersonne(@PathVariable Long id, @RequestBody PersonneCoreDTO personneCoreDTO) {
        PersonneCoreDTO updatedPersonne = iPersonneService.updatePersonne(id, personneCoreDTO);
        if (updatedPersonne != null) {
            return new ResponseEntity<>(updatedPersonne, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('BFF_deletePersonne')")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        iPersonneService.deletePersonne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('BFF_getAllPersonnes')")
    public ResponseEntity<List<PersonneCoreDTO>> getAllPersonnes() {
        List<PersonneCoreDTO> personnes = iPersonneQuery.getAllPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('BFF_getPersonneById')")
    public ResponseEntity<PersonneCoreDTO> getPersonneById(@PathVariable Long id) {
        PersonneCoreDTO personne = iPersonneQuery.getPersonneById(id);
        if (personne != null) {
            return new ResponseEntity<>(personne, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

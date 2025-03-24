package org.sid.personnecore.coreDTO;

import lombok.*;

@Getter
@Builder
@Setter @NoArgsConstructor @AllArgsConstructor
public class PersonneCoreDTO {
    private String nom;
    private String prenom;
    private String adresse;
}

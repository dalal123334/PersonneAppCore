package org.sid.personnecore.coreDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonneCoreDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private int age;
    private String email;
}

package org.sid.personnecore.repository;

import org.sid.personnecore.module.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long>
{
}

package com.bjornspetprojects.configprops.configprops.repositories;

import com.bjornspetprojects.configprops.configprops.entities.GhelamcoDbPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GhelamcoDbPropertyRepository extends JpaRepository<GhelamcoDbPropertyEntity,Long> {
}

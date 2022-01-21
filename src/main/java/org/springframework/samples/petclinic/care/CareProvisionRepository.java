package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
	
    List<CareProvision> findAll(); 
    
    Optional<CareProvision> findById(int id);
    
	@Query("SELECT c FROM cares c")
    List<Care> findAllCares();
	
//	@Query("SELECT c FROM Care c WERE c.pet_type_id = ?petTypeName")
//    List<Care> findCompatibleCares(String petTypeName);
	
	@Query("SELECT c FROM cares c WERE c.name = ?careName")
	Care findCareByName(String careName);
	
    //Care findCareByName(String name);
	
//	@Query("SELECT c.care_provision_id FROM Care c WERE c.")
//    List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}

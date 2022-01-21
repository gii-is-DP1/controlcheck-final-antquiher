package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice.This;

@Getter
@Setter
@Entity
@Table(name = "cares")
public class Care extends BaseEntity {
	
	@NotNull
	@Size(min = 5, max = 30)
    String name;
	
	@NotNull
    String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pet_type_care", joinColumns = @JoinColumn(name = "care_id"),
			inverseJoinColumns = @JoinColumn(name = "types_id"))
    Set<PetType> compatiblePetTypes;
	
	@ManyToMany
	@JoinTable(name = "incompatible_care", joinColumns = @JoinColumn(name = "care_id"),
			inverseJoinColumns = @JoinColumn(name = "care_no_compatible_id"))
    Set<Care> incompatibleCares;
	
	
	
}

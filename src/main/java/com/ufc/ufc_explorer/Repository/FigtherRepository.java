package com.ufc.ufc_explorer.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufc.ufc_explorer.Entity.Fighter;

@Repository
public interface FigtherRepository extends JpaRepository<Fighter, Long>{
	
	Page<Fighter> findAll(Pageable pageable);
	
	@Query("SELECT f FROM Fighter f WHERE LOWER(f.weightClass) = LOWER(:weightClass)")
	Page<Fighter> findAllByweightClass(@Param("weightClass")String weightClass, Pageable pageable);

}

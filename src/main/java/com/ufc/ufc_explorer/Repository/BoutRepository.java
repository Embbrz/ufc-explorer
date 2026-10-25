package com.ufc.ufc_explorer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.ufc_explorer.Entity.Bout;

@Repository
public interface BoutRepository extends JpaRepository<Bout, Long>{
	List<Bout> findByEventId(Long eventId);

}

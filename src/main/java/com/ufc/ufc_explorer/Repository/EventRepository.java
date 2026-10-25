package com.ufc.ufc_explorer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.jdi.event.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}

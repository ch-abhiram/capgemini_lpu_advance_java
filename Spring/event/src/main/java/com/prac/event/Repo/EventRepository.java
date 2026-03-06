package com.prac.event.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.event.Entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventType(String eventType);

    List<Event> findByTitleContaining(String title);
}

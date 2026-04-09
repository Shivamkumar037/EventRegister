package com.Event.EventSystem.repository;

import com.Event.EventSystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
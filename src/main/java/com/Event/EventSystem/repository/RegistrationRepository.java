package com.Event.EventSystem.repository;

import com.Event.EventSystem.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
package com.Event.EventSystem.controller;

import com.Event.EventSystem.entity.Event;
import com.Event.EventSystem.entity.Registration;
import com.Event.EventSystem.repository.EventRepository;
import com.Event.EventSystem.repository.RegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventRepository eventRepository;
    private final RegistrationRepository registrationRepository;

    public EventController(EventRepository eventRepository,
                           RegistrationRepository registrationRepository) {
        this.eventRepository = eventRepository;
        this.registrationRepository = registrationRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

    @GetMapping("/create-event")
    public String createEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event-form";
    }

    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/";
    }

    @GetMapping("/register/{id}")
    public String registerForm(@PathVariable Long id, Model model) {

        Event event = eventRepository.findById(id).orElseThrow();
        Registration registration = new Registration();
        registration.setEvent(event);

        model.addAttribute("registration", registration);
        return "register";
    }

    @PostMapping("/register")
    public String saveRegistration(@ModelAttribute Registration registration) {

        registrationRepository.save(registration);
        return "redirect:/";
    }
}
package com.uap.it1331l.registrationapi.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uap.it1331l.registrationapi.model.Attendee;
import com.uap.it1331l.registrationapi.repository.RegistrationMybatisRepository;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationMybatisRepository registrationRepo;
	@PostMapping("/event/register")
	public Attendee register(@RequestBody Attendee student) {
		registrationRepo.insert(student);
		return student;
	}
	@GetMapping("/attendees")
	public List<Attendee> getAttendees() {
		return registrationRepo.findAll();
	}
	@PutMapping("/event/survey/eligibility")
	public List<Attendee> updateEligibility() {
		registrationRepo.updateEligibility();
		List<Attendee> attendees = registrationRepo.getAllEligible();
		return attendees;
	}
	@DeleteMapping("event/registration/{id}")
	public void deleteAttendee(@PathVariable("id") int attendeeId) {
		registrationRepo.deleteId(attendeeId);
	}
}

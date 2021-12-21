package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Slot;
import com.example.demo.repositary.SlotRepositary;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SlotController {

	@Autowired
	private SlotRepositary slotRepositary;
	
	//get all slots
	@GetMapping("/slots")
	public List<Slot> getAllSlots() {
		return slotRepositary.findAll();
	}
	
	//update slot record
	@PutMapping("/slots/{id}")
	public ResponseEntity<Slot> updateSlot(@PathVariable Long id,@RequestBody Slot slotDetails){
		Slot slot = slotRepositary.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Slot doesnot exist"));
		
		slot.setBooked(slotDetails.isBooked());
		
		Slot updatedSlot = slotRepositary.save(slot);
		return ResponseEntity.ok(updatedSlot);
		
	}

}

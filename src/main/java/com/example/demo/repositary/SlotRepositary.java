package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Slot;

@Repository
public interface SlotRepositary extends JpaRepository<Slot, Long>{

}


package com.epics82.agrovita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epics82.agrovita.entity.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    // Add custom queries if needed
}

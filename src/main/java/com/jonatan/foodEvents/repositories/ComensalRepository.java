package com.jonatan.foodEvents.repositories;


import com.jonatan.foodEvents.entities.Comensal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComensalRepository extends JpaRepository<Comensal, Long> {
}

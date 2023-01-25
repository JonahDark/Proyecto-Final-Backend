package com.jonatan.foodEvents.repositories;


import com.jonatan.foodEvents.entities.Decoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecoracionRepository extends JpaRepository<Decoracion, Long> {
}

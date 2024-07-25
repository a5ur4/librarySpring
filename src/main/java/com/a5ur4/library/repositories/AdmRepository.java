package com.a5ur4.library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a5ur4.library.entitys.AdmEntity;

@Repository
public interface AdmRepository extends JpaRepository<AdmEntity, Integer> {
    Optional<AdmEntity> findAdmByName(String name);
    
    Optional<AdmEntity> findAdmById(Integer id);
}

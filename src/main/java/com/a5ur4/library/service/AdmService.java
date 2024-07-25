package com.a5ur4.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5ur4.library.entitys.AdmEntity;
import com.a5ur4.library.repositories.AdmRepository;

@Service
public class AdmService {
    @Autowired
    private AdmRepository repository;

    public void createAdmin(String name, String password) {
        AdmEntity newAdmin = new AdmEntity(name, password);
        this.repository.save(newAdmin);
    }

    public void deleteAdmin(Integer id) {
        this.repository.deleteById(id);
    }

    public void updateAdmin(Integer id, String name, String password) {
        AdmEntity admin = this.repository.findAdmById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setName(name);
        admin.setPassword(password);
        this.repository.save(admin);
    }

    public void findAdminById(Integer id) {
        this.repository.findAdmById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public List<AdmEntity> findAllAdmins() {
        return this.repository.findAll();
    }
}

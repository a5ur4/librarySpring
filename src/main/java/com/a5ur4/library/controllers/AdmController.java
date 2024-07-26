package com.a5ur4.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a5ur4.library.entitys.AdmEntity;
import com.a5ur4.library.dtos.AdmDTO;
import com.a5ur4.library.service.AdmService;

@RestController
@RequestMapping("/admin")
public class AdmController {
    @Autowired
    private AdmService admService;

    @PostMapping("/create")
    public ResponseEntity<String> createAdm(@RequestBody AdmDTO adm) {
        this.admService.createAdmin(adm.name(), adm.password());
        return ResponseEntity.ok("Admin created");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAdm(@RequestBody AdmDTO adm) {
        this.admService.deleteAdmin(adm.id(), adm.name());
        return ResponseEntity.ok("Admin deleted");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateAdm(@RequestBody AdmDTO adm) {
        this.admService.updateAdmin(adm.id(), adm.name(), adm.password());
        return ResponseEntity.ok("Admin updated");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<AdmEntity>> listAllAdms() {
        return ResponseEntity.ok(this.admService.findAllAdmins());
    }
}

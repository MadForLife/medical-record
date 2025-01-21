package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.KeycloakSyncModel;
import student.informatics.medicalrecord.data.entity.User;
import student.informatics.medicalrecord.service.impl.KeycloakSyncServiceImpl;


@RestController
@RequestMapping("/keycloak/sync-request/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:7080")
public class KeycloakSyncController {

    private final KeycloakSyncServiceImpl keycloakSyncService;

    @PostMapping("/register")
    public ResponseEntity<? extends User> createRegisteredUser(@RequestBody KeycloakSyncModel keycloakSyncModel) {
        return ResponseEntity.ok(keycloakSyncService.createUser(keycloakSyncModel));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody KeycloakSyncModel keycloakSyncModel) {
        return ResponseEntity.ok(keycloakSyncService.updateUser(keycloakSyncModel));
    }

    @PostMapping("/doctor")
    public ResponseEntity<User> createDoctor(@RequestBody KeycloakSyncModel keycloakSyncModel) {
        return ResponseEntity.ok(keycloakSyncService.createDoctor(keycloakSyncModel));
    }

}
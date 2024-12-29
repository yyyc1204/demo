package org.example.javademo.controller;

import org.example.javademo.model.DistributedLock;
import org.example.javademo.service.DistributedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locks")
public class DistributedLockController {

    private final DistributedLockService lockService;

    @Autowired
    public DistributedLockController(DistributedLockService lockService) {
        this.lockService = lockService;
    }

    @PostMapping("/acquire")
    public ResponseEntity<Boolean> acquireLock(
            @RequestParam String lockName,
            @RequestParam String lockOwner,
            @RequestParam(defaultValue = "30") int timeoutSeconds) {
        boolean acquired = lockService.acquireLock(lockName, lockOwner, timeoutSeconds);
        return ResponseEntity.ok(acquired);
    }

    @DeleteMapping("/release")
    public ResponseEntity<Boolean> releaseLock(
            @RequestParam String lockName,
            @RequestParam String lockOwner) {
        boolean released = lockService.releaseLock(lockName, lockOwner);
        return ResponseEntity.ok(released);
    }

    @GetMapping("/{lockName}")
    public ResponseEntity<DistributedLock> getLock(@PathVariable String lockName) {
        DistributedLock lock = lockService.getLock(lockName);
        return ResponseEntity.ok(lock);
    }

    @GetMapping
    public ResponseEntity<List<DistributedLock>> getAllLocks() {
        List<DistributedLock> locks = lockService.getAllLocks();
        return ResponseEntity.ok(locks);
    }

    @DeleteMapping("/clean")
    public ResponseEntity<Void> cleanExpiredLocks(
            @RequestParam(defaultValue = "30") int timeoutSeconds) {
        lockService.cleanExpiredLocks(timeoutSeconds);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/renew")
    public ResponseEntity<Boolean> renewLock(
            @RequestParam String lockName,
            @RequestParam String lockOwner) {
        boolean renewed = lockService.renewLock(lockName, lockOwner);
        return ResponseEntity.ok(renewed);
    }
}
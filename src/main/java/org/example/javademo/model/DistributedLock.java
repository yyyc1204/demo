package org.example.javademo.model;

import java.time.LocalDateTime;

public class DistributedLock {
    private String lockName;
    private String lockOwner;
    private LocalDateTime lockTimestamp;

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public LocalDateTime getLockTimestamp() {
        return lockTimestamp;
    }

    public void setLockTimestamp(LocalDateTime lockTimestamp) {
        this.lockTimestamp = lockTimestamp;
    }
}
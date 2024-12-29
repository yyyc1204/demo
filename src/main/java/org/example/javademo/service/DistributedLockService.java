package org.example.javademo.service;

import org.example.javademo.model.DistributedLock;
import java.util.List;

public interface DistributedLockService {
    /**
     * 获取锁
     */
    boolean acquireLock(String lockName, String lockOwner, int timeoutSeconds);
    
    /**
     * 释放锁
     */
    boolean releaseLock(String lockName, String lockOwner);
    
    /**
     * 获取锁信息
     */
    DistributedLock getLock(String lockName);
    
    /**
     * 获取所有锁
     */
    List<DistributedLock> getAllLocks();
    
    /**
     * 清理过期锁
     */
    void cleanExpiredLocks(int timeoutSeconds);
    
    /**
     * 续期锁
     */
    boolean renewLock(String lockName, String lockOwner);
}
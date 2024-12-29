package org.example.javademo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.javademo.model.DistributedLock;
import java.util.List;

@Mapper
public interface DistributedLockMapper {
    /**
     * 尝试获取锁
     */
    int tryLock(DistributedLock lock);
    
    /**
     * 释放锁
     */
    int releaseLock(@Param("lockName") String lockName, @Param("lockOwner") String lockOwner);
    
    /**
     * 查询锁信息
     */
    DistributedLock getLock(@Param("lockName") String lockName);
    
    /**
     * 获取所有锁
     */
    List<DistributedLock> getAllLocks();
    
    /**
     * 清理过期的锁
     */
    int cleanExpiredLocks(@Param("timeoutSeconds") int timeoutSeconds);
    
    /**
     * 更新锁的时间戳
     */
    int updateLockTimestamp(@Param("lockName") String lockName, @Param("lockOwner") String lockOwner);
}
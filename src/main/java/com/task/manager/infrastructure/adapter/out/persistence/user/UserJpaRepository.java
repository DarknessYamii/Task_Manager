package com.task.manager.infrastructure.adapter.out.persistence.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * The interface User jpa repository.
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find by user name optional.
     *
     * @param userName the user name
     * @return the optional
     */
    @Query(value = "SELECT t FROM UserEntity t WHERE t.userName = :userName")
    Optional<UserEntity> findByUserName(@Param("userName") String userName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UserEntity t")
    void deleteAll();
}

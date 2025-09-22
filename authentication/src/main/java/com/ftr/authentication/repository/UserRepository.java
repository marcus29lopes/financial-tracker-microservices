package com.ftr.authentication.repository;

import com.ftr.authentication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(nativeQuery = true,
            value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM  users u WHERE u.email = :email")
    Boolean existsByEmail(@Param("email") String email);

    @Query(nativeQuery = true,
            value = "SELECT * FROM users WHERE email = :email")
    Optional<Users> findUserByEmail(@Param("email") String email);
}

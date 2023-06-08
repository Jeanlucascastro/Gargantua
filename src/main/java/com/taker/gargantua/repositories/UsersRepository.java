package com.taker.gargantua.repositories;

import com.taker.gargantua.entities.Person;
import com.taker.gargantua.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    Users findByUsername(@Param("userName") String userName);
}
package com.example.expenseapp.repository;

import com.example.expenseapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   Boolean existsByEmail(String email);

}

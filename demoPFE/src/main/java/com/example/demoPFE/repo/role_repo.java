package com.example.demoPFE.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPFE.models.Role;

@Repository
public interface role_repo extends JpaRepository<Role ,Long> {

}

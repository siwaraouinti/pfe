package com.example.demoPFE.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPFE.models.Intervention;
@Repository
public interface  intervention_repo extends JpaRepository<Intervention,Long> {

}

package com.example.demoPFE.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPFE.models.Notif;


@Repository
public interface notif_repo extends JpaRepository<Notif ,Long> {

}

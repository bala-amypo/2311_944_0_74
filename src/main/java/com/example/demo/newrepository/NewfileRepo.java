package com.example.demo.newrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.newentity.NewfileEntity;
public interface NewfileRepo extends JpaRepository<NewfileEntity,Long>{
    
}
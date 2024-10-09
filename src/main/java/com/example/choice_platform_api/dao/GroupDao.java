package com.example.choice_platform_api.dao;

import com.example.choice_platform_api.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group,Long> {
}

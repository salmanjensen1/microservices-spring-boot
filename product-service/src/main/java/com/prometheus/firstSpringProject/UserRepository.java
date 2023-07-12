package com.prometheus.firstSpringProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Admin, Integer>{
}

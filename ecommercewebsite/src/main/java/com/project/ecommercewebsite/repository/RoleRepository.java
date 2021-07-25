package com.project.ecommercewebsite.repository;

import com.project.ecommercewebsite.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String roleName);
}

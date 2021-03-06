package com.springbootboilerplate.springbootboilerplate.repository;

import com.springbootboilerplate.springbootboilerplate.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
}

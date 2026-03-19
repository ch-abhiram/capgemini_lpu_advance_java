package com.prac.jwt_prac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.jwt_prac.entity.UserInformation;

public interface UserJpaRepository extends JpaRepository<UserInformation, String> {

}

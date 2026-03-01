package com.capgemini.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.HMS.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}

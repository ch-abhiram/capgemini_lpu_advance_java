package com.capgemini.HMS.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.HMS.Entity.Member;
import com.capgemini.HMS.Repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberjpa;

    public Member addMember(Member m) {
        m.setMemberSince(LocalDate.now());
        m.setStatus("ACTIVE");
        return memberjpa.save(m);
    }

    public Member getMemberById(Long id) {
        return memberjpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public List<Member> getAllMembers() {
        return memberjpa.findAll();
    }

    public Member updateMember(Long id, Member update) {
        Member obj = getMemberById(id);
        obj.setName(update.getName());
        obj.setEmail(update.getEmail());
        obj.setPhone(update.getPhone());
        return memberjpa.save(obj);
    }

    public void deleteMember(Long id) {
        Member obj = getMemberById(id);
        memberjpa.delete(obj);
    }
}

package com.capgemini.HMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.HMS.Entity.LibraryBranch;
import com.capgemini.HMS.Repository.LibraryBranchRepository;

@Service
public class LibraryBranchService {

	@Autowired
    private LibraryBranchRepository branchjpa;

    public LibraryBranch addBranch(LibraryBranch b) {
        return branchjpa.save(b);
    }

    public LibraryBranch getBranchById(Long id) {
        return branchjpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    public List<LibraryBranch> getAllBranches() {
        return branchjpa.findAll();
    }

    public LibraryBranch updateBranch(Long id, LibraryBranch update) {
        LibraryBranch obj = getBranchById(id);
        obj.setName(update.getName());
        obj.setLocation(update.getLocation());
        obj.setContactNumber(update.getContactNumber());
        return branchjpa.save(obj);
    }

    public void deleteBranch(Long id) {
        LibraryBranch obj = getBranchById(id);
        branchjpa.delete(obj);
    }
}

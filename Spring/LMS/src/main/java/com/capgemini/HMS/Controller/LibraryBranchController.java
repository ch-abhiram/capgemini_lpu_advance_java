package com.capgemini.HMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.HMS.Entity.LibraryBranch;
import com.capgemini.HMS.Service.LibraryBranchService;

@RestController
@RequestMapping("/branches")
public class LibraryBranchController {

    @Autowired
    private LibraryBranchService branchService;

    @PostMapping
    public LibraryBranch addBranch(@RequestBody LibraryBranch b) {
        return branchService.addBranch(b);
    }

    @GetMapping("/{id}")
    public LibraryBranch getBranchById(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    @GetMapping
    public List<LibraryBranch> getAllBranches() {
        return branchService.getAllBranches();
    }

    @PutMapping("/{id}")
    public LibraryBranch updateBranch(@PathVariable Long id,
                                      @RequestBody LibraryBranch b) {
        return branchService.updateBranch(id, b);
    }

    @DeleteMapping("/{id}")
    public String deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return "Branch deleted successfully";
    }
}
package com.capgemini.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.EMS.Entity.Employee;
import com.capgemini.EMS.Service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // ---------- REGISTER PAGE ----------
    @GetMapping("/hello")
    public String registerPage() {
        return "register";
    }

    
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee emp) {

        service.save(emp);

        return "login";
    }

    // ---------- LOGIN PAGE ----------
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/logincheck")
    public ModelAndView loginCheck(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {

        ModelAndView mv = new ModelAndView();

        Employee emp =
                service.findByEmailAndPassword(email, password);

        // LOGIN FAILED
        if (emp == null) {
            mv.setViewName("failure");
            return mv;
        }

        // ROLE NOT MATCH
        if (!emp.getRole().equalsIgnoreCase(role)) {
            mv.setViewName("role");
            return mv;
        }

        // ADMIN LOGIN
        if (role.equalsIgnoreCase("ADMIN")) {
            return service.getAdminPage();
        }

        // USER LOGIN
        mv.addObject("name", emp.getName());
        mv.setViewName("welcome");

        return mv;
    }
    
    

    @PostMapping("/deleteRecord")
    public String deleteRecord(@RequestParam String email) {

        service.deleteEmployee(email);

        return "redirect:/adminpage";
    }

    // ---------- ADMIN PAGE ----------
    @GetMapping("/adminpage")
    public ModelAndView adminPage() {

        ModelAndView mv = new ModelAndView();

        List<Employee> employees =
                service.getAllEmployees();

        mv.addObject("list_of_employees", employees);
        mv.setViewName("adminpage");

        return mv;
    }
    
    
}
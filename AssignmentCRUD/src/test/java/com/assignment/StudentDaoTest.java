package com.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.*;

public class StudentDaoTest {

    private static EntityManagerFactory emf;
    private StudentDao dao;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @AfterAll
    static void closeFactory() {
        emf.close();
    }

    @BeforeEach
    void setup() {
        dao = new StudentDao();
    }

    @AfterEach
    void tearDown() {
        dao.close();
    }

    // ----------------------------------------------------

    @Test
    void testSaveStudent() {
        Student s = new Student();
        s.setId(201);
        s.setName("SaveUser");
        s.setEmail("save@mail.com");
        s.setMarks(80.0);

        dao.saveStudent(s);

        Student saved = dao.findStudentById(201);
        assertNotNull(saved);
    }

    // ----------------------------------------------------

    @Test
    void testFindStudentById_NotFound() {
        Student s = dao.findStudentById(9999);
        assertNull(s);
    }

    // ----------------------------------------------------

    @Test
    void testFindAllStudents() {
        Student s = new Student();
        s.setId(202);
        s.setName("AllUser");
        s.setEmail("all@mail.com");
        s.setMarks(75.0);

        dao.saveStudent(s);

        List<Student> list = dao.findAllStudents();
        assertTrue(list.size() > 0);
    }

    // ----------------------------------------------------

    @Test
    void testUpdateStudent_Name() {

        Student s = new Student();
        s.setId(203);
        s.setName("Old");
        s.setEmail("old@mail.com");
        s.setMarks(60.0);

        dao.saveStudent(s);

        dao.updateStudent(203, 1, "New");

        Student updated = dao.findStudentById(203);
        assertEquals("New", updated.getName());
    }

    // ----------------------------------------------------

    @Test
    void testUpdateStudent_Email() {

        Student s = new Student();
        s.setId(204);
        s.setName("User");
        s.setEmail("old@mail.com");
        s.setMarks(60.0);

        dao.saveStudent(s);

        dao.updateStudent(204, 2, "new@mail.com");

        Student updated = dao.findStudentById(204);
        assertEquals("new@mail.com", updated.getEmail());
    }

    // ----------------------------------------------------

    @Test
    void testUpdateStudent_Marks() {

        Student s = new Student();
        s.setId(205);
        s.setName("User");
        s.setEmail("mail@mail.com");
        s.setMarks(50.0);

        dao.saveStudent(s);

        dao.updateStudent(205, 3, 95.0);

        Student updated = dao.findStudentById(205);
        assertEquals(95.0, updated.getMarks());
    }

    // ----------------------------------------------------

    @Test
    void testUpdateStudent_InvalidChoice() {

        Student s = new Student();
        s.setId(206);
        s.setName("User");
        s.setEmail("mail@mail.com");
        s.setMarks(50.0);

        dao.saveStudent(s);

        dao.updateStudent(206, 99, "Invalid");  // default case

        Student unchanged = dao.findStudentById(206);
        assertEquals("User", unchanged.getName());
    }

    // ----------------------------------------------------

    @Test
    void testUpdateStudent_NotFound() {
        dao.updateStudent(9999, 1, "NoUser");  // student not found
        Student s = dao.findStudentById(9999);
        assertNull(s);
    }

    // ----------------------------------------------------

    @Test
    void testDeleteStudent() {

        Student s = new Student();
        s.setId(207);
        s.setName("Delete");
        s.setEmail("del@mail.com");
        s.setMarks(40.0);

        dao.saveStudent(s);

        dao.deleteStudent(207);

        Student deleted = dao.findStudentById(207);
        assertNull(deleted);
    }

    // ----------------------------------------------------

    @Test
    void testDeleteStudent_NotFound() {
        dao.deleteStudent(8888); // student not present
        Student s = dao.findStudentById(8888);
        assertNull(s);
    }

    // ----------------------------------------------------

    @Test
    void testClose() {
        dao.close();
        assertTrue(true); // just ensures method executes
    }
}

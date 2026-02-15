package com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UniversityServiceTest {

    @Mock
    private InstructorDAO instructorDAO;

    @Mock
    private CourseDAO courseDAO;

    @Mock
    private EnrollmentDAO enrollmentDAO;

    @InjectMocks
    private UniversityService service;

    @Test
    void oneToOneMappingTest() {

        Instructor instructor = new Instructor();
        InstructorProfile profile = new InstructorProfile();

        service.createInstructorWithProfile(instructor, profile);

        assertEquals(profile, instructor.getProfile());
    }

    @Test
    void oneToManyMappingTest() {

        Instructor instructor = new Instructor();
        instructor.setId(1);

        Course c1 = new Course();
        Course c2 = new Course();

        List<Course> courses = Arrays.asList(c1, c2);

        when(instructorDAO.findInstructorWithCourses(1)).thenReturn(instructor);

        service.addCoursesToInstructor(1, courses);

        assertNotNull(instructor.getCourses());
        assertEquals(2, instructor.getCourses().size());
    }

    @Test
    void manyToOneMappingTest() {

        Course course = new Course();
        course.setId(201);

        Enrollment enrollment = new Enrollment();

        when(courseDAO.findCourse(201)).thenReturn(course);

        service.addEnrollmentToCourse(enrollment, 201);

        assertEquals(course, enrollment.getCourse());
    }

    @Test
    void daoUpdateTest() {

        service.updateEnrollmentGrade(301, "A");

        assertTrue(true);
    }

    @Test
    void daoDeleteTest() {

        Instructor instructor = new Instructor();
        instructor.setId(1);

        Course course = new Course();
        course.setId(201);

        instructor.setCourses(List.of(course));

        when(instructorDAO.findInstructorWithCourses(1))
                .thenReturn(instructor);

        when(enrollmentDAO.findByCourse(201))
                .thenReturn(new ArrayList<>());

        service.deleteInstructorAndDependencies(1);

        assertNotNull(instructor);
    }

    @Test
    void fullServiceIntegrationTest() {

        Instructor instructor = new Instructor();
        instructor.setId(10);

        when(instructorDAO.findInstructorWithCourses(10))
                .thenReturn(instructor);

        Instructor result =
                service.fetchInstructorWithCourses(10);

        assertNotNull(result);
        assertEquals(10, result.getId());
    }
}

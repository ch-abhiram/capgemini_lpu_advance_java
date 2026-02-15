package com.uni;



import java.util.List;

public class UniversityService {

//    private InstructorDAO instructorDAO = new InstructorDAO();
//    private CourseDAO courseDAO = new CourseDAO();
//    private EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    
        private InstructorDAO instructorDAO;
        private CourseDAO courseDAO;
        private EnrollmentDAO enrollmentDAO;

        public UniversityService(
                InstructorDAO instructorDAO,
                CourseDAO courseDAO,
                EnrollmentDAO enrollmentDAO) {

            this.instructorDAO = instructorDAO;
            this.courseDAO = courseDAO;
            this.enrollmentDAO = enrollmentDAO;
        }

    public void createInstructorWithProfile(
            Instructor instructor,
            InstructorProfile profile) {

        instructor.setProfile(profile);
        instructorDAO.saveInstructor(instructor, profile);
    }

    public void addCoursesToInstructor(
            int instructorId,
            List<Course> courses) {

        Instructor instructor =
                instructorDAO.findInstructorWithCourses(instructorId);

        for (Course c : courses) {
            courseDAO.saveCourse(c);
        }

        instructor.setCourses(courses);
        instructorDAO.updateInstructor(instructor);
    }

    public void addEnrollmentToCourse(
            Enrollment enrollment,
            int courseId) {

        Course course = courseDAO.findCourse(courseId);
        enrollment.setCourse(course);
        enrollmentDAO.saveEnrollment(enrollment);
    }

    public void updateEnrollmentGrade(
            int enrollmentId,
            String grade) {

        enrollmentDAO.updateGrade(enrollmentId, grade);
    }

    public Instructor fetchInstructorWithCourses(int id) {

        Instructor instructor =
                instructorDAO.findInstructorWithCourses(id);

        if (instructor.getCourses() != null) {
            instructor.getCourses().size();
        }

        return instructor;
    }

    public void deleteInstructorAndDependencies(int instructorId) {

        Instructor instructor =
                instructorDAO.findInstructorWithCourses(instructorId);

        if (instructor == null)
            return;

        if (instructor.getCourses() != null) {

            for (Course course : instructor.getCourses()) {

                List<Enrollment> enrollments =
                        enrollmentDAO.findByCourse(course.getId());

                for (Enrollment e : enrollments) {
                    enrollmentDAO.deleteEnrollment(e.getId());
                }

                courseDAO.deleteCourse(course.getId());
            }
        }

        instructorDAO.deleteInstructor(instructorId);
    }
}


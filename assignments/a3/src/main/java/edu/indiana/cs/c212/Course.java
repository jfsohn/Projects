package edu.indiana.cs.c212;

import java.util.*;


public class Course {
    private String        courseName;
    private List<Student> students;
    private UUID          id;

    public Course() {
        students = new ArrayList<Student>(); //Leave this be.
        //FIXME Set the value of id to be a random UUID
    }

    public UUID getId() {
        return null; //FIXME Return the id value.
    }

    public void setId(UUID id) {
        //FIXME set the id value
    }

    public List<Student> getStudents() {
        return null; //FIXME return the actually set of enrolled students.
    }

    public void setStudents(List<Student> students) {
        //FIXME Set the students value
    }

    /**
     * This method takes a student and adds them to the set of enrolled students.
     * Students may be rejected or not enrolled for 1 of 2 reasons
     * 1) They are already enrolled (i.e already a member of students)
     * 2) Their enrollment would cause the number of students to exceed
     *
     * @param student The student to be added.
     * @return true if and only if the student has been successfully enrolled in the course
     */
    public Boolean enrollStudent(Student student) {

        return null; //FIXME return the correct Boolean value
    }

    public Boolean isEnrolled(Student student){
        return null; //FIXME
    }

    /**
     * Removes the given student from the course. If the student is not enrolled,
     * do nothing.
     *
     * @param student The student to be removed.
     */
    public void removeStudent(Student student) {
        //FIXME
    }


    /**
     * The maximum number of students allowed to be enrolled in the class at a given time.
     */
    public static int COURSE_ENROLLMENT_LIMIT; //FIXME The course enrollment limit should be 90
}

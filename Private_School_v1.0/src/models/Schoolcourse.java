package models;

import java.util.List;


public class Schoolcourse {

    private Course course;
    private List<Trainer> trainers;
    private List<Student> students;
    private List<Assignment> assignments;

    public Schoolcourse() {
    }

    public Schoolcourse(Course course, List<Trainer> trainers, List<Student> students, List<Assignment> assignments) {
        this.course = course;
        this.trainers = trainers;
        this.students = students;
        this.assignments = assignments;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Schoolcourse{" + "course=" + course + ", trainers=" + trainers + ", students=" + students + ", assignments=" + assignments + '}';
    }
    
}

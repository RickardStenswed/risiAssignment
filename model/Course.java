package model;

public class Course {
    private String courseCode;
    private String courseName;
    private double credit;

    public Course(String courseCode, String courseName, double credit) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCredit(credit);
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

}



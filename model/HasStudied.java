package model;

public class HasStudied {
    private String courseCode;
    private String ssn;
    private String grade;
    private String semester;

    public HasStudied(String courseCode, String ssn, String grade, String semester) {

    setCourseCode(courseCode);
    setSsn(ssn);
    setGrade(grade);
    setSemester(semester);
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

}



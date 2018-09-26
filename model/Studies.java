package model;

public class Studies {
    private String courseCode;
    private String ssn;
    private String semester;

    public Studies(String courseCode, String ssn, String semester) {

    setCourseCode(courseCode);
    setSsn(ssn);
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

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

}



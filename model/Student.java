package model;

public class Student {
    private String ssn;
    private String studentName;
    private String address;
    private String phoneNumber;

    public Student(String ssn, String studentName, String address, String phoneNumber) {

    setSsn(ssn);
    setStudentName(studentName);
    setAddress(address);
    setPhoneNumber(phoneNumber);
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
    return phoneNumber;
}
    
}




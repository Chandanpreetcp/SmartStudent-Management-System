public class Student {

    private String name;
    private String rollNo;
    private String department;
    private String email;
    private String phone;
    private double marks;

    public Student(String name, String rollNo,
                   String department,
                   String email,
                   String phone,
                   double marks) {

        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getMarks() {
        return marks;
    }
}

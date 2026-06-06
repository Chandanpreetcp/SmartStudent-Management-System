import java.sql.*;


public class StudentDAO {

    Connection con = DatabaseConnection.getConnection();

    public void addStudent(Student s) {

        String query =
        "INSERT INTO students(name,roll_no,department,email,phone,marks) VALUES(?,?,?,?,?,?)";

        try {

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, s.getName());
            ps.setString(2, s.getRollNo());
            ps.setString(3, s.getDepartment());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setDouble(6, s.getMarks());

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        try {

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            System.out.println(
            "-------------------------------------------------------------");

            while(rs.next()) {

                System.out.println(
                rs.getInt("id")+" | "+
                rs.getString("name")+" | "+
                rs.getString("roll_no")+" | "+
                rs.getString("department")+" | "+
                rs.getDouble("marks"));
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String rollNo) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "DELETE FROM students WHERE roll_no=?");

            ps.setString(1, rollNo);

            int rows = ps.executeUpdate();

            if(rows>0)
                System.out.println("Student Deleted");
            else
                System.out.println("Student Not Found");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByRoll(String rollNo) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "SELECT * FROM students WHERE roll_no=?");

            ps.setString(1, rollNo);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                rs.getString("name")+" "+
                rs.getString("department")+" "+
                rs.getDouble("marks"));
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByDepartment(String dept) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "SELECT * FROM students WHERE department=?");

            ps.setString(1, dept);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                rs.getString("name")+" "+
                rs.getString("roll_no"));
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByMarks(double marks) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "SELECT * FROM students WHERE marks > ?");

            ps.setDouble(1, marks);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                rs.getString("name")+" "+
                rs.getDouble("marks"));
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMarks(String rollNo,double marks) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "UPDATE students SET marks=? WHERE roll_no=?");

            ps.setDouble(1, marks);
            ps.setString(2, rollNo);

            int rows = ps.executeUpdate();

            if(rows>0)
                System.out.println("Updated Successfully");
            else
                System.out.println("Student Not Found");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

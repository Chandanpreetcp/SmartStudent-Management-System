import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AdminService admin =
                new AdminService();

        if(!admin.login()) {

            System.out.println("Invalid Login");
            return;
        }

        StudentDAO dao =
                new StudentDAO();

        while(true) {

            System.out.println("\n===== SMART STUDENT =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Search By Roll");
            System.out.println("6. Search By Department");
            System.out.println("7. Search By Marks");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    Student s =
                    new Student(name,roll,
                            dept,email,
                            phone,marks);

                    dao.addStudent(s);

                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Roll No: ");
                    String r = sc.nextLine();

                    System.out.print("New Marks: ");
                    double m = sc.nextDouble();

                    dao.updateMarks(r,m);

                    break;

                case 4:

                    System.out.print("Roll No: ");
                    dao.deleteStudent(sc.nextLine());

                    break;

                case 5:

                    System.out.print("Roll No: ");
                    dao.searchByRoll(sc.nextLine());

                    break;

                case 6:

                    System.out.print("Department: ");
                    dao.searchByDepartment(sc.nextLine());

                    break;

                case 7:

                    System.out.print("Marks Greater Than: ");
                    dao.searchByMarks(sc.nextDouble());

                    break;

                case 8:

                    System.out.println("Thank You");
                    System.exit(0);
            }
        }
    }
}
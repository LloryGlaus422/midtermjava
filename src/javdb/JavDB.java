/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javdb;

import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class JavDB {

    private String username;
    private String password;
    private String confirm;
    private String firstname;
    private String lastname;
    private String age;
    private String course;
    private String units;
    private String schedule;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lorlydb";
    static final String USER = "root";
    static final String PASS = "";
    Scanner scan = new Scanner(System.in);
    Scanner input = new Scanner(System.in);

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void delete(int id) {
        String sql = "DELETE FROM information WHERE acc_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletecour(int id) {
        String sql = "DELETE FROM course WHERE cour_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id) {
        System.out.print("Input Firstname to update: ");
        firstname = scan.next();
        System.out.print("Input Lastname to update: ");
        lastname = scan.next();
        System.out.println("Provide age to update: ");
        age = scan.next();
        String sql = "UPDATE `information` SET `firstname`='" + firstname + "',`lastname`='" + lastname + "',`age`='" + age + "'WHERE acc_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update1(int id) {
        System.out.print("Input subject to update: ");
        course = scan.next();
        System.out.print("Input units to update: ");
        units = scan.next();
        System.out.println("Provide schedule to update: ");
        schedule = scan.next();
        String sql = "UPDATE `course` SET `course`='" + course + "',`units`='" + units + "',`schedule`='" + schedule + "'WHERE cour_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create() {
        while (true) {
            try {
                System.out.print("Input username: ");
                username = input.nextLine();
                int name = parseInt(username);
                System.out.println("Please Enter a Alphabet for Your Firstname");
            } catch (Exception e) {
                break;
            }

        }

        while (true) {
            try {
                System.out.print("Input password: ");
                password = input.nextLine();
                if (password.length() >= 8) {
                    break;
                } else {
                    System.out.println("Password too short!");
                }
            } catch (Exception e) {
                System.out.println(e + "Password too short!");
            }
        }

        while (true) {
            try {
                System.out.print("Re-enter password: ");
                confirm = input.nextLine();
                if (password.contains(confirm)) {
                    break;
                } else {
                    System.out.println("Password Mismatch");
                }
            } catch (Exception e) {
                System.out.println(e + "password mismatch");
            }

        }

        while (true) {
            try {
                System.out.print("Input Firstname: ");
                firstname = input.nextLine();
                int fname = parseInt(firstname);
                System.out.println("Input an alphabet for your firstname: ");
            } catch (Exception e) {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Input Lastname: ");
                lastname = input.next();
                int lname = parseInt(lastname);
                System.out.println("Input alphabet in your lastname");
            } catch (Exception e) {
                break;

            }
        }

        while (true) {
            try {
                System.out.print("Provide your age: ");
                age = input.next();
                int age1 = parseInt(age);
                break;
            } catch (Exception e) {
                System.out.println("Input a number for your age");
            }
        }
        while (true) {
            try {
                System.out.print("Input subject: ");
                course = input.next();
                int yu = parseInt(course);
                System.out.println("Input alphabet in your course");
            } catch (Exception e) {
                break;

            }
        }

        while (true) {
            try {
                System.out.print("Input units: ");
                units = input.next();
                int la = parseInt(units);
                break;
            } catch (Exception e) {
                System.out.println("Input number in your units");

            }
        }

        while (true) {
            try {
                System.out.print("Input schedule: ");
                schedule = input.next();
                int su = parseInt(schedule);
                System.out.println("Input alphabet in your schedule");
            } catch (Exception e) {
                break;

            }
        }

    }
   
    public void saveInfo() {
        String sql = "INSERT INTO information VALUES (acc_id,'" + firstname + "','" + lastname + "','" + parseInt(age) + "')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save() {
        String sql = "INSERT INTO acc VALUES (id,'" + username + "','" + password + "')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void savecourse() {
        String sql = "INSERT INTO course VALUES (cour_id,'" + course + "','" + units + "','" + schedule + "')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void retrieve() {
        String sql = "SELECT * FROM `acc`";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("id");
                String uss = rs.getString("username");
                String pass = rs.getString("password");

                System.out.format("%s, %s, %s\n", id2, uss, pass);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void retrieve1() {
        String sql = "SELECT * FROM `information`";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("acc_id");
                String uss = rs.getString("firstname");
                String pass = rs.getString("lastname");
                String age2 = rs.getString("age");

                System.out.format("%s, %s, %s,%s\n", id2, uss, pass, age2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void retrieve2() {
        String sql = "SELECT * FROM `course`";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("cour_id");
                String uss = rs.getString("course");
                String pass = rs.getString("units");
                String age2 = rs.getString("schedule");

                System.out.format("%s, %s, %s,%s\n", id2, uss, pass, age2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void search() {
        System.out.print("Input id to search from account: ");
        int id = scan.nextInt();
        String sql = "SELECT `id`, `username`, `password` FROM `acc` WHERE id = '" + id + "'";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("id");
                String uss = rs.getString("username");
                String pass = rs.getString("password");

                System.out.format("%s, %s, %s\n", id2, uss, pass);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void search1() {
        System.out.print("Input id to search from information: ");
        int id = scan.nextInt();
        String sql = "SELECT `acc_id`, `firstname`, `lastname`, `age` FROM `information` WHERE acc_id = '" + id + "'";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("acc_id");
                String lname = rs.getString("lastname");
                String fname = rs.getString("firstname");
                String age1 = rs.getString("age");

                System.out.format("%s, %s, %s,%s\n", id2, fname, lname, age1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void search2() {
        System.out.print("Input id to search from course: ");
        int id = scan.nextInt();
        String sql = "SELECT `cour_id`, `course`, `units`, `schedule` FROM `course` WHERE cour_id = '" + id + "'";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("cour_id");
                String lname = rs.getString("course");
                String fname = rs.getString("units");
                String age1 = rs.getString("schedule");

                System.out.format("%s, %s, %s,%s\n", id2, fname, lname, age1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JavDB jav = new JavDB();
        boolean x = true;
        while (x) {
            Scanner input = new Scanner(System.in);
            System.out.println("\tChoose: \nPress 1 -- Create \nPress 2 -- Retrieve\nPress 3 -- Update\nPress 4 -- Delete\nPress 5 -- Save\nPress 6 -- Search\nPress 7 -- Exit");
            System.out.print("Enter Number: ");
            int i = input.nextInt();
            switch (i) {
                case 1:
                    jav.create();
                    break;
                case 2:
                    System.out.println("Retrieve data from account");
                    jav.retrieve();
                    System.out.println("Retrieve data from information");
                    jav.retrieve1();
                    System.out.println("Retrieve data from course");
                    jav.retrieve2();
                    break;
                case 3:
                    System.out.print("Input id to update information");
                    int idup = input.nextInt();
                    jav.update(idup);
                    System.out.print("Input id to update course");
                    int yay = input.nextInt();
                    jav.update1(yay);
                    System.out.println("*****Saving Changes***");
                    break;
                case 4:
                    System.out.print("Input Id to Delete from information: ");
                    int del = input.nextInt();
                    jav.delete(del);
                    System.out.print("Input Id to Delete from course: ");
                    int dele = input.nextInt();
                    jav.deletecour(dele);
                    break;
                case 5:
                    System.out.println("Everything is up to date!");
                    jav.save();
                    jav.saveInfo();
                    jav.savecourse();
                    break;
                case 6:
                    jav.search();
                    jav.search1();
                    jav.search2();
                    break;
                case 7:
                    System.out.println("Thank You so much!");
                    x = false;

            }
        }
    }
}


package com.vls.ui;

import com.vls.model.Course;
import com.vls.model.User;
import com.vls.repository.JdbcSystemRepository;
import com.vls.service.CourseService;
import com.vls.service.UserService;
import com.vls.service.VlsService;

import java.util.List;
import java.util.Scanner;

public class VlsManagementSystem {
    private VlsService courseService;
    private VlsService userService;
    private Scanner scanner;

    public VlsManagementSystem() {
        this.courseService = new CourseService(new JdbcSystemRepository());
        this.userService = new UserService(new JdbcSystemRepository());
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            printMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewAllCourses();
                    break;
                case 3:
                    searchCourses();
                    break;
                case 4:
                    registerUser();
                    break;
                case 5:
                    loginUser();
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\nVirtual Learning System");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Search Courses");
        System.out.println("4. Register User");
        System.out.println("5. Login User");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter course duration (in hours): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Is the course available? (true/false): ");
        boolean availability = Boolean.parseBoolean(scanner.nextLine());

        Course course = new Course(0, courseName, authorName, duration, availability);
        courseService.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private void viewAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        System.out.println("\nAll Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private void searchCourses() {
        System.out.print("Enter keyword to search for courses: ");
        String keyword = scanner.nextLine();
        List<Course> courses = courseService.searchCourses(keyword);
        System.out.println("\nSearch Results:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private void registerUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user password: ");
        String password = scanner.nextLine();

        User user = new User(0, name, password);
        userService.registerUser(user);
        System.out.println("User registered successfully.");
    }

    private void loginUser() {
        System.out.print("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter user password: ");
        String password = scanner.nextLine();

        User user = userService.loginUser(id, password);
        if (user != null) {
            System.out.println("User logged in successfully: " + user.getName());
            System.out.println("Welcome " + user.getName() + "!");
            userActions(user);
        } else {
            System.out.println("Invalid ID or password.");
        }
    }

    private void userActions(User user) {
        while (true) {
            printUserMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    updateUser(user);
                    break;
                case 2:
                    deleteUser(user);
                    return;
                case 3:
                    logoutUser(user);
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void printUserMenu() {
        System.out.println("\nUser Menu");
        System.out.println("1. Update User");
        System.out.println("2. Delete User");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
    }

    private void updateUser(User user) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        user.setName(newName);
        user.setPassword(newPassword);
        userService.updateUser(user);
        System.out.println("User updated successfully.");
    }

    private void deleteUser(User user) {
        userService.deleteUser(user.getId());
        System.out.println("User deleted successfully.");
    }

    private void logoutUser(User user) {
        userService.logoutUser(user);
        System.out.println("User logged out.");
    }

    public static void main(String[] args) {
        new VlsManagementSystem().run();
    }
}

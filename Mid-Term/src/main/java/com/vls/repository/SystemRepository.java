package com.vls.repository;

import com.vls.model.Course;
import com.vls.model.User;

import java.util.List;

public interface SystemRepository {

    // Course methods
    void addCourse(Course course);
    Course getCourseById(int courseId);
    List<Course> getAllCourses();
    List<Course> searchCourses(String keyword);

    // User methods
    void addUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}

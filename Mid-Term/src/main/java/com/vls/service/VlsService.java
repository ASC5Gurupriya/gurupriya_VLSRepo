package com.vls.service;

import com.vls.model.Course;
import com.vls.model.User;

import java.util.List;

public interface VlsService {
    // Course methods
    void addCourse(Course course);
    Course getCourseById(int courseId);
    List<Course> getAllCourses();
    List<Course> searchCourses(String keyword);

    // User methods
    void registerUser(User user);
    User loginUser(int id, String password);
    void logoutUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}

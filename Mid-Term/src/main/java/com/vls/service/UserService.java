package com.vls.service;

import com.vls.model.User;
import com.vls.model.Course;
import com.vls.repository.SystemRepository;

import java.util.List;

public class UserService implements VlsService {
    private final SystemRepository systemRepository;

    public UserService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    @Override
    public void registerUser(User user) {
        systemRepository.addUser(user);
    }

    @Override
    public User loginUser(int id, String password) {
        User user = systemRepository.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public void logoutUser(User user) {
        // In a real application, you might invalidate a session or token here
        System.out.println("User logged out: " + user.getName());
    }

    @Override
    public List<User> getAllUsers() {
        return systemRepository.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        systemRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        systemRepository.deleteUser(id);
    }

    @Override
    public void addCourse(Course course) {
        throw new UnsupportedOperationException("Operation not supported in UserService.");
    }

    @Override
    public Course getCourseById(int courseId) {
        throw new UnsupportedOperationException("Operation not supported in UserService.");
    }

    @Override
    public List<Course> getAllCourses() {
        throw new UnsupportedOperationException("Operation not supported in UserService.");
    }

    @Override
    public List<Course> searchCourses(String keyword) {
        throw new UnsupportedOperationException("Operation not supported in UserService.");
    }
}

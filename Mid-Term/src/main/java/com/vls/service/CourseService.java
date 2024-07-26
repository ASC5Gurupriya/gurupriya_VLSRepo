package com.vls.service;

import com.vls.model.Course;
import com.vls.model.User;
import com.vls.repository.SystemRepository;

import java.util.List;

public class CourseService implements VlsService {
    private final SystemRepository systemRepository;

    public CourseService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    @Override
    public void addCourse(Course course) {
        systemRepository.addCourse(course);
    }

    @Override
    public Course getCourseById(int courseId) {
        return systemRepository.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return systemRepository.getAllCourses();
    }

    @Override
    public List<Course> searchCourses(String keyword) {
        return systemRepository.searchCourses(keyword);
    }

    @Override
    public void registerUser(User user) {
        throw new UnsupportedOperationException("Operation not supported in CourseService.");
    }

    @Override
    public User loginUser(int id, String password) {
        throw new UnsupportedOperationException("Operation not supported in CourseService.");
    }

    @Override
    public void logoutUser(User user) {
        throw new UnsupportedOperationException("Operation not supported in CourseService.");
    }

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Operation not supported in CourseService.");
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Operation not supported in CourseService.");
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Operation not supported in CourseService.");
    }
}


package com.vls.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {

    @Test
    public void testCourseConstructorAndGetters() {
        Course course = new Course(1, "Java Programming", "John Doe", 30, true);

        assertEquals(1, course.getCourseId());
        assertEquals("Java Programming", course.getCourseName());
        assertEquals("John Doe", course.getAuthorName());
        assertEquals(30, course.getDuration());
        assertTrue(course.isAvailability());
    }

    @Test
    public void testCourseSetters() {
        Course course = new Course(1, "Java Programming", "John Doe", 30, true);

        course.setCourseId(2);
        course.setCourseName("Python Programming");
        course.setAuthorName("Jane Doe");
        course.setDuration(40);
        course.setAvailability(false);

        assertEquals(2, course.getCourseId());
        assertEquals("Python Programming", course.getCourseName());
        assertEquals("Jane Doe", course.getAuthorName());
        assertEquals(40, course.getDuration());
        assertTrue(!course.isAvailability());
    }

    @Test
    public void testCourseToString() {
        Course course = new Course(1, "Java Programming", "John Doe", 30, true);
        String expectedString = "Course{courseId=1, courseName='Java Programming', authorName='John Doe', duration=30, availability=true}";
        assertEquals(expectedString, course.toString());
    }
}

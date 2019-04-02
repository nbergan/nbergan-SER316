package test.java;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import main.java.Course;
import main.java.Student;
import main.java.Major;

public class CourseTest {
	Course fourStudent;
	Course threeStudent;
	Course twoStudent;
	Course oneStudent;
    Course zeroStudent;
    Course onePoint;
    Course twoPoint;
    Course oneAddStudent;
    Course twoAddStudent;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    // Test Case X to get last portion of code
    public void testAverageWithoutMinWithoutMax4() {
        // Four Students
        fourStudent = new Course("SER300");
        fourStudent.set_points("Hanna", 100);
        fourStudent.set_points("Ashley", 80);
        fourStudent.set_points("Nate", 70);
        fourStudent.set_points("Kendra", 60);
        double ans = fourStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 75.0);
    }
    
    @Test
    // Test Case 1 #48 - #77
    public void testAverageWithoutMinWithoutMax3() {
        // Three Students
        threeStudent = new Course("SER300");
        threeStudent.set_points("Hanna", 100);
        threeStudent.set_points("Ashley", 80);
        threeStudent.set_points("Nate", -5);
        double ans = threeStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 90.0);
    }
    
    @Test
    // Test Case 2 #48 - #58
    public void testAverageWithoutMinWithoutMax2() {
        // Two Students
        twoStudent = new Course("SER200");
        twoStudent.set_points("Hanna", 50);
        twoStudent.set_points("Ashley", 100);
        double ans = twoStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 75.0);
    }
    
    @Test
    // Test Case 3 #48 - #77
    public void testAverageWithoutMinWithoutMax1() {
        // One Student
        oneStudent = new Course("SER100");
        oneStudent.set_points("Hanna", 50);
        double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    }
    
    @Test
    // Edge Case 7 Covers missing loops
    public void testAverageWithoutMinWithoutMax0() {
        // Zero Students
        zeroStudent = new Course("SER000");
        double ans = zeroStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 0.0);
    }
    
    @Test
    public void testSet_points1() {
        // Test points added
        onePoint = new Course("IT100");
        onePoint.set_points("Hanna", 50);
        double ans = onePoint.getStudent_Points("Hanna");
        assertTrue(ans == 50.0);
    }
    
    @Test
    public void testSet_points2() {
        // Test points overwritten correctly
        twoPoint = new Course("IT200");
        twoPoint.set_points("Bob", 50);
        twoPoint.set_points("Bob", 100);
        double ans = twoPoint.getStudent_Points("Bob");
        assertTrue(ans == 100.0);
    }
    
    @Test
    public void testAddStudent1() {
        // Test student not on list
        oneAddStudent = new Course("CS100");
        oneAddStudent.set_points("Hanna", 50);
        Student Joe = new Student("Joe", Major.valueOf("CS"));
        boolean ans = oneAddStudent.addStudent(Joe);
        assertTrue(ans == false);
    }
    
    @Test
    public void testAddStudent2() {
        // Test student already on list
        twoAddStudent = new Course("CS100");
        twoAddStudent.set_points("Hanna", 50);
        twoAddStudent.set_points("Joe", 85);
        Student Joe = new Student("Joe", Major.valueOf("CS"));
        boolean ans = twoAddStudent.addStudent(Joe);
        assertTrue(ans == true);
    }
}

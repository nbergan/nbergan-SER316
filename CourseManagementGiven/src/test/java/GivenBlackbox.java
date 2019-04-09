package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.Course;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades5;
import main.java.CourseGrades4;
import main.java.CourseGrades0;
import main.java.CourseGrades3;

import java.lang.reflect.Constructor;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;
    
   
    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }
    
    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }
    
    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }
    
    
    // ^^^  *** DO NOT CHANGE ABOVE *** ^^^

    //A single zero course
    Course oneBStudent;
    HashMap<String, Integer> oneBStudentExpected = new HashMap<String, Integer>(); 
    
    // A sample course
    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 
    
    // A second course
    Course threeFialStudent;
    HashMap<String, Integer> threeFailExpected = new HashMap<String, Integer>(); 
    
    // A third course
    Course fourNegativeStudent;
    HashMap<String, Integer> fourNegativeExpected = new HashMap<String, Integer>(); 
    
    // A third course
    Course oneOfEachStudent;
    HashMap<String, Integer> oneOfEachExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp() throws Exception {
        
        // all courses should be created like this
        
        //Course created with one Student having
    	oneBStudent = createCourse("SER301");
    	oneBStudent.set_points("Becky",0);
        // this would be the expected result after the method countOccurencesLetterGrades is called
    	oneBStudentExpected.put("A", 0);
    	oneBStudentExpected.put("B", 0);
    	oneBStudentExpected.put("C", 0);
    	oneBStudentExpected.put("D", 0);
    	oneBStudentExpected.put("F", 1);
        
        // Course created with two Students having
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",75);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        twoStudentExpected.put("A", 1);
        twoStudentExpected.put("B", 1);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);
        
        
        // Course created with one pass, zero, fail Students having
        threeFialStudent = createCourse("SER303");
        threeFialStudent.set_points("Fred",99);
        threeFialStudent.set_points("Frank",0);
        threeFialStudent.set_points("Fritz",-97);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        threeFailExpected.put("A", 1);
        threeFailExpected.put("B", 0);
        threeFailExpected.put("C", 0);
        threeFailExpected.put("D", 0);
        threeFailExpected.put("F", 1);
        
        
        // Course created with all negative Students having
        fourNegativeStudent = createCourse("SER303");
        fourNegativeStudent.set_points("Fred",-99);
        fourNegativeStudent.set_points("Frank",-98);
        fourNegativeStudent.set_points("Fritz",-2);
        fourNegativeStudent.set_points("Fritz",-1);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        fourNegativeExpected.put("A", 0);
        fourNegativeExpected.put("B", 0);
        fourNegativeExpected.put("C", 0);
        fourNegativeExpected.put("D", 0);
        fourNegativeExpected.put("F", 0);
        
        
        // Course created with one of each grade Students having
        oneOfEachStudent = createCourse("SER303");
        oneOfEachStudent.set_points("Anna",100);
        oneOfEachStudent.set_points("Bob",75);
        oneOfEachStudent.set_points("Charlie",55);
        oneOfEachStudent.set_points("Debra",40);
        oneOfEachStudent.set_points("Fritz",5);
        oneOfEachStudent.set_points("Nate",-1);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        oneOfEachExpected.put("A", 1);
        oneOfEachExpected.put("B", 1);
        oneOfEachExpected.put("C", 1);
        oneOfEachExpected.put("D", 1);
        oneOfEachExpected.put("F", 1);
    }

    // One Student B test
    @Test
    public void oneBStudent() {
        HashMap<String, Integer> ans = oneBStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(oneBStudentExpected));
    }

    // Sample test
    @Test
    public void twoStudent() {
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
    }

    // Three Fail test
    @Test
    public void threeFialStudent() {
        HashMap<String, Integer> ans = threeFialStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(threeFailExpected));
    }
    
    // Four Negative test
    @Test
    public void fourNegativeStudent() {
        HashMap<String, Integer> ans = fourNegativeStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(fourNegativeExpected));
    }
    
    // One of Each test
    @Test
    public void oneOfEachStudent() {
        HashMap<String, Integer> ans = oneOfEachStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(oneOfEachExpected));
    }
}

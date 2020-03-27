/*
3. Create a class Course that consists of the course code, course name, credit hours and the grade of the course (A, B, C, D and F). The point allocate to each grade is (4, 3, 2, 1 and 0). Then, insert the following information into a linked list. After that, calculate the grade point average for the student. 

Example output
Course Code         Course Name         Credit Hours        Grade 
WXX101              Programming         5                   B 
WXX201              Networking          4                   C
WXX301              Operating System    3                   A

The list consist of
Course : WXX101 (Programming) - 5 credit hours. Grade : B -->
Course : WXX201 (Networking) - 4 credit hours. Grade : C -->
Course : WXX301 (Operating System) - 3 credit hours. Grade : A -->
Total point is 35
Total credit is 12
Grade point average is 2.92
*/
package Lab4;

public class CourseTesterClass {
    public static void main(String[] args) {
        Course main = new Course();
        Course[] c = new Course[3];
        c[0] = new Course("WXX101", "Programming", 5, 'B');
        c[1] = new Course("WXX201", "Networking", 4, 'C');
        c[2] = new Course("WXX301", "Operating Systems", 3, 'A');
        CourseLinkedList<Course> student1 = new CourseLinkedList<>();
        for(Course i : c) student1.addLastNode(i);
        student1.showList();
        main.showSummary();
    }
}

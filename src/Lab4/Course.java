/*
 * 3. Create a class Course that consists of the course code, course name, credit hours and the grade of the course (A, B, C, D and F). The point allocate to each grade is (4, 3, 2, 1 and 0). Then, insert the following information into a linked list. After that, calculate the grade point average for the student. 

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
Grade point average is 2.92 // How? Ans: 35/12
 */
package Lab4;

public class Course {
    private String courseCode;
    private String courseName;
    private char grade;
    private int creditHours;
    private static int totalCreditHours;
    private static int point = 0;
    
    public Course(){
        
    }
    
    public Course(String courseCode, String courseName, int creditHours, char grade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.grade = grade;
        calc();
    }
    
    public void calc(){
        totalCreditHours += creditHours;
        switch(grade){
            case 'A':
                point += (creditHours * 4);
                break;
            case 'B':
                point += (creditHours * 3);
                break;
            case 'C':
                point += (creditHours * 2);
                break;
            case 'D':
                point += (creditHours * 1);
                break;
            default:
                
        }
    }
    
    public void showSummary(){
        System.out.println("\nTotal point is " + point);
        System.out.println("Total credit is " + totalCreditHours);
        System.out.printf("Grade point average is %.2f\n", (double)((point*1.0)/totalCreditHours));
    }

    @Override
    public String toString() {
        return "\nCourse : " + courseCode + '(' + courseName + ") - " + creditHours + " credit hours. Grade : " + grade;
    }
}

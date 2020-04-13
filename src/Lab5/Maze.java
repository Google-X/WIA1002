/*
 * Question 6 bottom.
 */

package Lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    static boolean[] visited, wall;
    static int current, finalPosition;
    static boolean found = false;
    static boolean previouslyPopped = false;
    static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {

        String maze = "";
        String line = "";
        int mazeWidth = 0;

        try {
            Scanner s = new Scanner(new FileInputStream("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab5/Maze.txt"));
            while (s.hasNextLine()) {
                line = s.nextLine();
                maze += line + "\n";
            }
            s.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("File not found!");
        } finally {
            mazeWidth = line.length();
        }
        
        System.out.println("The original maze is");
        System.out.println(maze);
        maze = maze.replaceAll("\n", "");

        visited = new boolean[maze.length()];
        wall = new boolean[maze.length()];
        char[] analysed = maze.toCharArray();
        
        for (int i = 0; i < analysed.length; i++) {
            if (analysed[i] == '#') wall[i] = true;
            else if (analysed[i] == 'S') {
                current = i;
                visited[i] = true;
            }
            else if (analysed[i] == 'F') finalPosition = i;
        }
        
        /**
         * To go up: current -= mazeWidth To go down: current += mazeWidth To go
         * left = current--; To go right = current++; We go in clockwise
         * direction, so: UP -> EAST -> SOUTH -> WEST
         */
        int up, down, left, right;
        while (!found) {
            up = current - mazeWidth;
            right = current + 1;
            down = current + mazeWidth;
            left = current - 1;
            
            if (go(up, path));
            else if (go(right, path));
            else if (go(down, path));
            else if (go(left, path));
            else {
                current = path.pop();
                previouslyPopped = true;
            }
        }
        
        if(found){
            char[] solution = maze.toCharArray();
            while(!path.isEmpty()) solution[path.pop()] = '.';
            
            System.out.println("The Solution is");
            for(int i = 0; i < solution.length; i++){
                System.out.print(solution[i]);
                if((i+1) % 20 == 0) System.out.println();
            }
        } else {
            System.out.println("No solution found!");
        }
    }

    public static boolean go(int position, Stack<Integer> path) {
        if(!wall[position]){
            if (!visited[position]) {
                if(previouslyPopped){
                    path.push(current);
                    previouslyPopped = false;
                }
                current = position;
                if (current == finalPosition) {
                    found = true;
                } else {
                    path.push(current);
                    visited[current] = true;
                }
                return true;
            }
        }
        return false;
    }
}
/*
 * 6. A maze is simply a matrix of cells that are adjacent to one another. The user begins in a special start cell and seeks a path of adjacent cells that lead to the finish cell. A Position is used to identify a unique location within a maze. Any Position can be transformed into another Position by moving to the north, south, east, or west. The Maze class reads a maze description from a file and generates the appropriate adjacency of cells. # is a wall, S marks the start, F marks the finish. Write a program to find the solution from start to finish. 

Keep track of the path with a stack of positions At the current position, extend the path one step by trying to go north, east, south, west. If none of the neighboring squares is available, backtrack by popping a position off the stack. (If the stack is empty, declare failure.) when extending the path, push the new position on the stack. Test to see if the new position can be reached. Store indicator in the new position to make it impassable in the future. If Finish has been reached, output the stack contents as the solution path.

Example output:

The original maze is
####################
#S#       #F   #   #
# ####### #### # # #
#         #  # ### #
##### ### #        #
#   # #   ####### ##
#   # # ### #   #  #
#   # # #   # # ## #
#     #   #   #    #
####################

The Solution is
####################
#S#       #F...#   #
#.####### ####.# # #
#.........#  #.### #
##### ###.#   .... #
#   # #...#######.##
#   # #.### #...#..#
#   # #.#...#.#.##.#
#     #...#...#....#
####################
 */

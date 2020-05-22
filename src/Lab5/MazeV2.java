/*
 * Maze runner by Philemon Khor
 */
package Lab5;

import java.util.Stack; 

public class MazeV2 {
    public static void main(String[] args) { 
        
        String[] input = { 
                "####################", 
                "#S#       #F   #   #", 
                "# ####### #### # # #", 
                "#         #  # ### #", 
                "##### ### #        #", 
                "#   # #   ####### ##", 
                "#   # # ### #   #  #", 
                "#   # # #   # # ## #", 
                "#     #   #   #    #", 
                "####################", 
        }; 
        
        char[][] maze = parseMaze(input); 
        boolean[][] visited = new boolean[maze.length][maze[0].length]; 
        Stack<int[]> stack = new Stack<>(); 

        // You are now current standing at 'S', so push the current location into the stack and mark it as visited 
        // I simply used an int array to represent coordinates, do not try this at home, create a class instead 
        // first element in the array is x, second element is y 
        stack.push(new int[]{1, 1}); 
        visited[1][1] = true; 

        while (!stack.isEmpty()) { 
            // curr is current position where you are currently at 
            int[] curr = stack.peek(); 
            int x = curr[0], y = curr[1]; 

            // check if you are at the destination, break the loop it is true 
            if (maze[y][x] == 'F') break; 
            if (maze[y - 1][x] != '#' && !visited[y - 1][x]) { // trying to move upwards 
                y--; 
            } else if (maze[y + 1][x] != '#' && !visited[y + 1][x]) { // trying to move downwards 
                y++; 
            } else if (maze[y][x - 1] != '#' && !visited[y][x - 1]) { // trying to move leftwards 
                x--; 
            } else if (maze[y][x + 1] != '#' && !visited[y][x + 1]) { // trying to move rightwards 
                x++; 
            } 
            
            // check if we managed to move by comparing it to the ori values 
            if (x != curr[0] || y != curr[1]) { 
                stack.push(new int[]{x, y}); 
                visited[y][x] = true; 
            } else { 
                stack.pop(); // we didn't manage to move to any adjacent cell, backtrack 
            } 
        } 
        if (!stack.isEmpty()) { 
            // pop first, otherwise your 'F' will be replaced by the '.'. Remove this line to see the effect! 
            stack.pop(); 
            
            // likewise, we do not want to pop the last item in the stack, else your 'S' will become '.' 
            while (stack.size() > 1) { 
                int[] curr = stack.pop(); 
                maze[curr[1]][curr[0]] = '.'; // plot the path 
            } 
            for (char[] row : maze) { 
                System.out.println(String.valueOf(row).replaceAll("[]\\[,]", "")); 
            } 
        } else { 
            System.out.println("No solution!"); 
        } 
    } 

    private static char[][] parseMaze(String[] s) { 
        char[][] maze = new char[s.length][s[0].length()]; 
        for (int i = 0; i < maze.length; i++) { 
            for (int j = 0; j < maze[0].length; j++) { 
                maze[i][j] = s[i].charAt(j); 
            } 
        } 
        return maze; 
    } 
} 

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create a graph represented by adjacency lists
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Count the in-degrees for each course
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course); // Add a directed edge
            inDegrees[course]++;
        }

        // Create a queue to perform topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i); // Add courses with no prerequisites to the queue
            }
        }

        int[] order = new int[numCourses];
        int coursesTaken = 0;

        // Perform topological sorting
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[coursesTaken++] = course;

            for (int nextCourse : graph.get(course)) {
                if (--inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If you have taken all courses, return the order; otherwise, return an empty array
        return (coursesTaken == numCourses) ? order : new int[0];
    }
}

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Going up one level
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part); // Push valid directory/file names
            }
        }

        // Reconstruct the canonical path from the stack
        StringBuilder simplifiedPath = new StringBuilder("/");
        for (String dir : stack) {
            simplifiedPath.append(dir).append("/");
        }

        // Remove the trailing '/' if it exists
        if (simplifiedPath.length() > 1) {
            simplifiedPath.setLength(simplifiedPath.length() - 1);
        }

        return simplifiedPath.toString();
    }
}

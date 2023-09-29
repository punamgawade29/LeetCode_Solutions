

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1; // If endGene is not in bank, mutation is not possible
        }

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(startGene);
        visited.add(startGene);
        
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                
                if (currentGene.equals(endGene)) {
                    return mutations; // Mutation path found
                }
                
                char[] geneArray = currentGene.toCharArray();
                
                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];
                    
                    for (char newChar : genes) {
                        if (newChar != originalChar) {
                            geneArray[j] = newChar;
                            String mutatedGene = new String(geneArray);
                            
                            if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                                queue.offer(mutatedGene);
                                visited.add(mutatedGene);
                            }
                        }
                    }
                    
                    geneArray[j] = originalChar; // Revert back to original gene
                }
            }
            
            mutations++;
        }
        
        return -1; // No mutation path found
    }
}

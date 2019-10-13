public class WordLadderProblem {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
        Set<String> wordSet = new HashSet<>(wordList);
        
        if(! wordSet.contains(endWord)) return 0;
        
        // We cn use BFS to fin shortest path
        
        Queue<String> q = new LinkedList<>();
        
        q.offer(beginWord);
        int res = 0;
        
        while(!q.isEmpty()){
            for(int k=q.size();k>0 ;--k){
                String word  = q.poll();
                if(word.equals(endWord)){
                    return res+1;
                }
                for(int i=0;i<word.length();++i){
                    char[] newWord = word.toCharArray();
                    for(char ch = 'a' ;ch<='z';++ch){
                        newWord[i]=ch;
                        String s = new String(newWord);
                        if(wordSet.contains(s) && !s.equals(word)){
                            q.offer(s);
                            wordSet.remove(s);
                        }
                    }
                }
            }    
            ++res;
            
        }
        
        return 0;
    } 
}

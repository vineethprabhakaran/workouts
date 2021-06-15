package com.vineethds.tries;

class DictWord {
    public static Object isFormationPossible(String[] dict,String word) {
        Trie trie = new Trie();
        for(String key : dict){
            trie.insert(key);
        }
        TrieNode curr = trie.getRoot();
        int count = 0;
        int index = 0;
        for(int i = 0; i< word.length() ;i++){
            index = trie.getIndex(word.charAt(i));
            if(curr.children[index] != null){
                if(curr.children[index].isEndWord){
                    count++;
                    curr = trie.getRoot();
                }else{
                    curr = curr.children[index];
                }
            }

        }

        return (count == 2);
    }

    public static void main(String[] args) {
        String dict[] = {"the" ,"hello", "there", "answer", "any", "Dragon",
                "world", "their", "inc"};
        String word = "helloworld";
        boolean res = (boolean) isFormationPossible(dict,word);
        System.out.println(res);
    }

}
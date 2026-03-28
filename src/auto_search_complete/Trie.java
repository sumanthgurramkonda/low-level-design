package auto_search_complete;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        insertDFS(word,0,root);
    }

    public void insertDFS(String word, int index, TrieNode node){
        if(word.length() == index) {
            node.isWord = true;
            node.frequency++;
            return;
        }
        char c = word.charAt(index);
        if(node.child[c-'a']==null){
            node.child[c-'a']=new TrieNode();
        }
        insertDFS(word, index+1, node.child[c-'a']);
    }

    public Map<String, Integer> findMatchings(String word){
        Map<String, Integer> matchings = new HashMap<>();
        if(word==null){return matchings;}
        StringBuilder matchingWord = new StringBuilder(word);
        TrieNode node = getLeafNode(word,0,root);
        searchMatchings(matchings,node,matchingWord);
        return matchings;
    }

    public TrieNode getLeafNode(String word, int index, TrieNode node){
        if(word.length() == index){return node;}
        if(node.child[word.charAt(index)-'a']==null){return null;}
        return getLeafNode(word, index+1, node.child[word.charAt(index)-'a']);
    }

    public void searchMatchings(Map<String, Integer> matchings,TrieNode node,StringBuilder matchingWord){
        if(node==null) return;
        for(int i=0;i<26;i++){
            matchingWord.append((char)('a'+i));
            searchMatchings(matchings,node.child[i],matchingWord);
            matchingWord.deleteCharAt(matchingWord.length()-1);
        }
        if(node.isWord){
            matchings.put(matchingWord.toString(),node.frequency);
        }
    }


    private class TrieNode{
        TrieNode[] child;  // Better to use Map over array. I have used array to keep it simple
        int frequency;
        boolean isWord;

        TrieNode(){
            this.child = new TrieNode[26];
            this.isWord = false;
        }
    }
}

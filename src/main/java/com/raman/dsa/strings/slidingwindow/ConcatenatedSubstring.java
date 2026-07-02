package com.raman.dsa.strings.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedSubstring {

    public static List<Integer> findSubstring(String s,String[] words){
        List<Integer> ans = new ArrayList<>();
        if(s==null || s.length()==0 || words.length==0) return ans;
        HashMap<String,Integer> target = new HashMap<>();
        int wordsLength= words[0].length();
        int arrayLength = words.length;
        int windowLength = wordsLength * arrayLength;

        for(String word: words){
            target.put(word,target.getOrDefault(word,0)+1);
        }
        for(int i=0;i<=s.length()-windowLength;i++){
            Map<String,Integer> current = new HashMap<>();
            int j =0;
            while(j<arrayLength){
                int start = i + j * wordsLength;
                String currentWord = s.substring(start,start+wordsLength);
                current.put(currentWord,current.getOrDefault(currentWord,0)+1);
                j++;
            }
            if(current.equals(target)){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words)); // Output: [0, 9]

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        System.out.println(findSubstring(s2, words2)); // Output: []
    }
}

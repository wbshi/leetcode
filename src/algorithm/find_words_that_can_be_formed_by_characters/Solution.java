package src.algorithm.find_words_that_can_be_formed_by_characters;

import java.util.*;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        List<Character> charList = new ArrayList<>();
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < chars.length(); ++i) {
            charList.add(Character.valueOf(chars.charAt(i)));
        }

        for (String word: words) {
            List<Character> list = new ArrayList<>(charList);
            for (int i = 0; i < word.length(); ++i) {
                if (!list.contains(word.charAt(i))){
                    flag = false;
                    break;
                }
                list.remove(list.indexOf(word.charAt(i)));
            }

            if (flag) {
                count += word.length();
            }
            flag = true;
        }
        return count;
    }
}

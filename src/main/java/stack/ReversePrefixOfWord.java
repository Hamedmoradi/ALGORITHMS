package stack;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        String rest = "";
        boolean flag = true;
        int i = 0;
        if (word.contains(String.valueOf(ch))) {
            for (char s : word.toCharArray()) {
                if (s == ch && i == 0) {
                    flag = false;
                    i++;
                } else if (flag) {
                    stack.push(s);
                } else {
                    rest += s;
                }
            }
            List<Character> reversed = stack.reversed();
            reversed.add(0, ch);
            return reversed.stream().map(String::valueOf).collect(Collectors.joining()).concat(rest);
        } else {
            return word;
        }
    }

//    public String reversePrefix(String word, char ch) {
//        char words[]=word.toCharArray();
//        int index=0;
//        for(int i=0;i<words.length;i++)
//        {
//            if(words[i]==ch)
//            {
//                index=i;
//                break;
//            }
//        }
//        if(index==-1)
//        {
//            return word;
//        }
//
//        int left=0;
//        int right=index;
//        while(left<right){
//            char temp=words[left];
//            words[left]=words[right];
//            words[right]=temp;
//            left++;
//            right--;
//        }
//        return new String(words);
//    }

    public static void main(String[] args) {
        ReversePrefixOfWord obj = new ReversePrefixOfWord();
        System.out.println(obj.reversePrefix("abcdefd", 'q'));
    }
}

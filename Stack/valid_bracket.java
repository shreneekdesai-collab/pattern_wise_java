package Stack;

import java.util.Stack;

public class valid_bracket {
    public static void main(String[] args) {
        System.out.println(checkvalid("({[]})")); // true
        System.out.println(checkvalid("({[])"));  // false
    }

    public static boolean checkvalid(String s){

        Stack<Character> st = new Stack<>();
        boolean check=false;

        for(int i = 0; i < s.length(); i++){
            char t = s.charAt(i);

            if(t == '{' || t == '[' || t == '('){
                st.push(t);
            }
            else {
                if(st.isEmpty()) return false;

                char top = st.peek();

                if((t == '}' && top == '{') ||
                   (t == ']' && top == '[') ||
                   (t == ')' && top == '(')) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            check=true;
        }
        return check;


    }
}

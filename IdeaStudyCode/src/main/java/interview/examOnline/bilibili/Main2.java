package interview.examOnline.bilibili;

import java.util.Stack;

/**
 * ÀàÃèÊö
 *
 * @author yfk
 * @date 2020/8/13
 */
public class Main2 {
    public static void main(String[] args) {
        char[] temp = {'(','[','{'};
        for( int i = 0 ; i < temp.length ; i++){
            int m = temp[i];
            System.out.println(m);
        }

        System.out.println('(' < '[');
        System.out.println(temp.toString());
    }
    //(),{},[]
    public boolean IsValidExp (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++){
            char temp = s.charAt(i);
            if( temp=='(' || temp=='[' || temp=='{'){
                if (stack.peek() < temp)
                    return false;
                stack.add(temp);
            }else{//]})
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(temp!= top)
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}

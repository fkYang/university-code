package interview.examOnline.bilibili;

import java.util.Stack;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/13
 */
public class Mian1 {
     //4个 1-10 的数字，+1*/ 得到24

    public static void main(String[] args) {

        Mian1 goal = new Mian1();
        int [] arr ={7,2,1,10};
        boolean b = goal.Game24Points(arr);
        System.out.println(b);
    }

    public boolean Game24Points (int[] arr) {
        // write code here
        // * / + -
        char [] operations = {'+','-','*','/'};//+ - * /
        char[] op = new char[3];
        return getNext(op, 0, operations, arr);
    }

    //quan pai lie1
    boolean getNext(char[] op ,int index,char [] operations,int[] arr){
        if(index >= 3){
            if(isValaid(op, arr))
                return true;
            return false;
        }
        for( int i = 0 ; i < 4 ; i++){
            op[index] = operations[i];
            boolean next = getNext(op, index + 1, operations,arr);
            if(next)
                return true;
        }
        return false;
    }

    boolean isValaid(char[] op,int[] arr ){

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        numStack.add(arr[0]);
        for(int i = 0 ; i < 3 ; i++){//*/
            if(op[i] == '*' ){
                int top = numStack.pop();
                top = top * arr[i+1];
                numStack.add(top);
            }else if ( op[i] == '/'){
                int top = numStack.pop();
                top = top / arr[i+1];
                numStack.add(top);
            }else{
                numStack.add(arr[i+1]);
                opStack.add(op[i]);
            }
        }
        while(!opStack.isEmpty()){//+-
            char opTemp = opStack.pop();
            int nums = 0;
            switch (opTemp){
                case '+':
                    nums = numStack.pop();
                    nums = nums + numStack.pop();
                    numStack.push(nums);
                    break;
                case '-':
                    nums = numStack.pop();
                    nums = numStack.pop()-nums;
                    numStack.push(nums);
                    break;
            }
        }
        if(numStack.pop() == 24)
            return true;
        return false;
    }
}

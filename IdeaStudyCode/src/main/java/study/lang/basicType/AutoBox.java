package study.lang.basicType;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/19
 */
public class AutoBox {
    public static void main(String[] args) {

        autoBoxInt();
    }

    static  void autoBoxInt(){
        int i = 40;
        Integer i1 = i;//java/lang/Integer.valueOf>
        int x = i1;//<java/lang/Integer.intValue>
        Integer i4 = new Integer(40);
    }
//    int i = 40;
//    Integer i1 = Integer.valueOf(i);
//    int x = i1;
//        new Integer(40);

}

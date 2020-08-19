package study.util.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/19
 */
public class IteratorDemo {
    public static void main(String[] args) {
        testRemove();
    }


    //阻止程序员在不允许修改的时候修改对象，起到保护作用，避免出现未知异常。
    //itetator  iterator期间，对原集合进行修改，异常
    //itr   final void checkForComodification() {
    //            if (modCount != expectedModCount)
    //                throw new ConcurrentModificationException();
    //        }
    static void testRemove(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

                 // 复现方法一
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            iterator.remove();
            if (integer.intValue() == 5) {
   //             arrayList.remove(integer);
            }
        }
        System.out.println(arrayList.toString());
                 //method 2
        iterator = arrayList.iterator();
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }
    }
}

package interview.examOnline.ali;

// ����Ϊ���Ե��ж�����������淶ʾ���������ύ�����Ʒ֡�
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++)
            arr[i] = in.nextInt();
        in.close();

        int result = nums(arr, m);
        System.out.println(result);
        //hashmap������Ԫ��

    }
    //ʱ�临�Ӷȣ���������ߣ�hashmap��һ�ּ�����ϣ���ȥ�ף�����max ���� �Ƿ�  m
    // ==m:ǰ��ļ�����
    // ��= �� �������
    static int nums( int[] arr,int m){
        int result = 0;
        for( int i = 0 ; i < arr.length ; i++){//begin
            Map<Integer , Integer > map = new HashMap<>();
            for( int j = i ; j < arr.length ; j++){//�˿�ʼ������
                int size = 1;
                if(map.containsKey(arr[j])){
                    size = map.get(arr[j]) + 1;//��ǰ���ֵĴ���
                    if(size >= m){
                        result = result + arr.length - j;
                        break;
                    }
                }
                map.put(arr[j],size);
            }

        }
        return  result;
    }

}
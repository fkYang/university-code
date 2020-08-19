package interview.examOnline.bilibili;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/13
 */
//1024 元买价值n的东西，最少收到多少硬币
public class Main3 {
    public static void main(String[] args) {

        int n = 200;
        System.out.println(GetCoinCount(n));

    }
static    public int GetCoinCount (int N) {
        // write code here
        int left = 1024 - N;
        int nums = 0;
        int[] icons = {64,16,4,1};
        for( int i = 0 ; i < 4 ; i++){
            while(left >= icons[i]){
                nums++;
                left = left - icons[i];
            }
        }
        return nums;
    }
}

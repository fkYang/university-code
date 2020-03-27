package leecode;

public class Rook999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
				
		
	}
	public int numRookCaptures(char[][] board) {
		if( board.length != 8 ||board[0].length!= 8)
			return 0;
       int ans = 0;
       int i = 0 , j = 0;
       for( i = 0 ; i < 8 ; i ++) {
    	   for(j = 0 ; j < 8 ; j++) {
    		   if(board[i][j] == 'R')
    			   break; 
    	   }
    	   if( j != 8 )
    		   break;
       }
       if(i== 8 || j == 8)
    	   return 0;
       //left 
       for(int m = i-1 ; m < 8 && m>=0 ;m--) {
    	   int temp = move(board, m, j);
    	   if(temp < 0)
    		   break;
    	   ans += temp;
    	   if( temp == 1)
    		   break;
       }
       //right
       for(int m = i+1 ; m < 8 && m>=0 ;m++) {
    	   int temp = move(board, m, j);
    	   if(temp < 0)
    		   break;
    	   ans += temp;
    	   if( temp == 1)
    		   break;
       }
       //    //up
       for(int n = j-1 ; n < 8 && n>=0 ;n--) {
    	   int temp = move(board, i, n);
    	   if(temp < 0)
    		   break;
    	   ans += temp;
    	   if( temp == 1)
    		   break;
       }
       //down
       for(int n = j+1 ; n < 8 && n>=0 ;n++) {
    	   int temp = move(board, i, n);
    	   if(temp < 0)
    		   break;
    	   ans += temp;
    	   if( temp == 1)
    		   break;
       }

       return ans;
	}
	int move(char[][] board,int i,int j) {
 	   switch(board[i][j]) {
 	   case '.':
 		   return 0;
 	   case 'p':
 		   return 1;
 		default:
 			return -1;
 	   }
	}
}

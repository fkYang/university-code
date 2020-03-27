package SwordToOffer;


public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder t = new StringBuilder();
		t.append("asdewq");
		String tt = t.toString();
		tt = new String("asdewq");
		String temp = "asdewq";
		System.out.println( tt == temp);
		
		String temp2 = "asdewq";
		
		System.out.println(t.toString() == temp);
		
		System.out.println( tt + "  "+ temp);
		System.out.println( tt.hashCode() + "  "+ temp.hashCode());

		System.out.println(temp.equals(t.toString()));
		System.out.println("asdewq" == temp);
		System.out.println(temp == temp2);
	}

}

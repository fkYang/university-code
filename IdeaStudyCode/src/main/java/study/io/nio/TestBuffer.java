package study.io.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		
		
	}
	
	static void test() {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		show(buf);
		//����
		String content = "asawqafasad as";
		buf.put(content.getBytes());	
		System.out.println("���룺");
		show(buf);
		//�л�ģʽ--��
		buf.flip();
		System.out.println("�л�ģʽ��");
		show(buf);
		
		if( buf.hasRemaining())
			System.out.println(buf.remaining());
		
		//��ȡ����
		byte[] dst = new byte[buf.limit()];
		buf.get(dst);
		System.out.println("��ȡ��");
		System.out.println(new String(dst , 0 ,dst.length));
		show(buf);
		buf.flip();
		show(buf);
		
	}
	static void show( Buffer buf) {
		System.out.println( "posotion :" + buf.position());
		System.out.println("limit:" + buf.limit());
		System.out.println("capacity:" + buf.capacity());
		System.out.println("---------------");
	}

}

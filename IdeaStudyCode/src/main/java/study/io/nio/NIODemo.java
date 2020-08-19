package study.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

public class NIODemo {
	static String path="D:\\31577\\����\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//client();
			server();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void client() throws Throwable {
		//1.get channel
		SocketChannel sChanel = SocketChannel.open( new InetSocketAddress("127.0.0.1",9898) );
				
		//2. �л�������ģʽ
		sChanel.configureBlocking(false);
				
		//3. buffer
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		//4 . send
		buf.put(new Date().toString().getBytes());
		buf.flip();
		sChanel.write(buf);
		buf.clear();
		
		//5.close
		sChanel.close();
	}
	
	static void server() throws Throwable {
		//1.��ȡͨ��
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		System.out.println(ssChannel.isBlocking()+"Ĭ�ϵ�ģʽ");
		//2.�л�ģʽ
		ssChannel.configureBlocking(false);
		// 3. �󶨶˿�
		ssChannel.bind(new InetSocketAddress(9898));
		//ssChannel.keyFor()
		///4. ��ȡѡ����
		Selector sel = Selector.open();
//		System.out.println(sel.getClass().getName());
		//5.��ͨ��ע�ᵽѡ����,��ָ��λ���������¼�
		ssChannel.register(sel, SelectionKey.OP_ACCEPT);
		
		//6.��ѯ��ȡѡ�������Ѿ�׼���������¼�||
		while( sel.select() > 0) {
			SocketChannel sChannel22 = ssChannel.accept();
			//7.��ȡ��ǰѡ����������ע���ѡ������Ѿ����ļ����¼�
			Iterator<SelectionKey> it = sel.selectedKeys().iterator();
			
			while( it.hasNext()) {
				
				//8. ��ȡ׼���������¼�
				SelectionKey sk = it.next();
				
				//9.�ж���ʲô�¼�����
				if( sk.isAcceptable()) {
					
					//10.���ܾ�������ȡ�ͻ�������
					SocketChannel sChannel = ssChannel.accept();
					
					//11.�л�������
					sChannel.configureBlocking(false);
					//12.ͨ��ע�ᵽѡ������
					sChannel.register(sel, SelectionKey.OP_READ);
				}else if(sk.isReadable()) {
					//13.��ȡ��������
					SocketChannel sChannel = (SocketChannel) sk.channel();
					//14.������
					ByteBuffer buf = ByteBuffer.allocate(1024);
					int len = 0;
					while( (len = sChannel.read(buf))!= -1) {
						buf.flip();
						System.out.println(new String(buf.array(),0,len));
						buf.clear();
					}
				}
				it.remove();
			}
		}
	}

}

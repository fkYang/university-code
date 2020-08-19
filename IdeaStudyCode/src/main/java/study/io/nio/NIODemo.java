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
	static String path="D:\\31577\\桌面\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";

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
				
		//2. 切换非阻塞模式
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
		//1.获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		System.out.println(ssChannel.isBlocking()+"默认的模式");
		//2.切换模式
		ssChannel.configureBlocking(false);
		// 3. 绑定端口
		ssChannel.bind(new InetSocketAddress(9898));
		//ssChannel.keyFor()
		///4. 获取选择器
		Selector sel = Selector.open();
//		System.out.println(sel.getClass().getName());
		//5.将通道注册到选择器,并指定位监听接收事件
		ssChannel.register(sel, SelectionKey.OP_ACCEPT);
		
		//6.轮询获取选择器上已经准备就绪的事件||
		while( sel.select() > 0) {
			SocketChannel sChannel22 = ssChannel.accept();
			//7.获取当前选择器上所有注册的选择键，已就绪的监听事件
			Iterator<SelectionKey> it = sel.selectedKeys().iterator();
			
			while( it.hasNext()) {
				
				//8. 获取准备就绪的事件
				SelectionKey sk = it.next();
				
				//9.判断是什么事件就绪
				if( sk.isAcceptable()) {
					
					//10.接受就绪，获取客户端连接
					SocketChannel sChannel = ssChannel.accept();
					
					//11.切换非阻塞
					sChannel.configureBlocking(false);
					//12.通道注册到选择器上
					sChannel.register(sel, SelectionKey.OP_READ);
				}else if(sk.isReadable()) {
					//13.获取，读就绪
					SocketChannel sChannel = (SocketChannel) sk.channel();
					//14.读数据
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

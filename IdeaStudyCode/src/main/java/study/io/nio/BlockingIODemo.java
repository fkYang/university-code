package study.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingIODemo {
	static String path="D:\\31577\\桌面\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";

	public static void main (String[] args) {
		// TODO Auto-generated method stub
//		path = BlockingIODemo.class.getClassLoader().getResource("io/nio/").getPath();
//		path = path.substring(1);

	//	System.out.println( );
		Thread myserver = new Thread(()-> {
			try {
				server();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		myserver.start();
		Thread myclient = new Thread(()-> {
			try {
				client();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myclient.start();
	}

	static void client() throws Throwable {
		//1.get channel
		SocketChannel sChanel = SocketChannel.open( new InetSocketAddress("127.0.0.1",9898) );
		
		FileChannel fin = FileChannel.open(Paths.get(path+"1.txt"), StandardOpenOption.READ);
		
		//2. buffer
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		//3. read and send
		while(fin.read(buf) != -1 ) { 
			buf.flip();
			sChanel.write(buf);
			buf.clear();
		}
		
	//	4. close
		fin.close();
		sChanel.close();
	}
	
	static void server() throws Throwable {
		//1.获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		FileChannel fChannel = FileChannel.open(Paths.get(path+"server.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//2.bind connection
		ssChannel.bind(new InetSocketAddress(9898));
		//3. get client channel
		SocketChannel sChannel = ssChannel.accept();
		//4.分配缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		//5. 接受，保存到本地
		while( sChannel.read(buf) != -1) {
			buf.flip();
			fChannel.write(buf);
			buf.clear();
		}
		//6. close
		sChannel.close();
		fChannel.close();
		ssChannel.close();
	}
}

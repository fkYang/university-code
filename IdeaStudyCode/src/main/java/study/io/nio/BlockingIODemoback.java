package study.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingIODemoback {
	static String path="D:\\31577\\桌面\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			client();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void client() throws Throwable {
		SocketChannel sChanel = SocketChannel.open( new InetSocketAddress("127.0.0.1",9898) );
		FileChannel fin = FileChannel.open(Paths.get(path+"1.txt"), StandardOpenOption.READ);
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while(fin.read(buf) != -1 ) { 
			buf.flip();
			sChanel.write(buf);
			buf.clear();
		}
		
		sChanel.shutdownOutput();
		//接受服务器反馈
		int len;
		while( (len =sChanel.read(buf)) != -1){
			buf.flip();
			
			System.out.println(new String(buf.array(),0,len));
			buf.clear();
		}
		System.out.println("get");
		fin.close();
		sChanel.close();
	}
	
	static void server() throws Throwable {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		FileChannel fChannel = FileChannel.open(Paths.get(path+"serverback.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		ssChannel.bind(new InetSocketAddress(9898));

		SocketChannel sChannel = ssChannel.accept();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		while( sChannel.read(buf) != -1) {
			buf.flip();
			fChannel.write(buf);
			buf.clear();
		}
	//	buf.clear();
		buf.put("over".getBytes());
		buf.flip();
		sChannel.write(buf);
		
		//6. close
		sChannel.close();
		fChannel.close();
		ssChannel.close();
	}
}

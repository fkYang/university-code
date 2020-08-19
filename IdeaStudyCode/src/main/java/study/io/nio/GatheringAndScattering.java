package study.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class GatheringAndScattering {

	static String path="D:\\31577\\桌面\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		RandomAccessFile ran = new RandomAccessFile(path+"1.txt", "rw");
	
		//1.获取通道
		FileChannel channel1 = ran.getChannel();
		//2.分配缓冲区
		ByteBuffer buf1 = ByteBuffer.allocate(3);
		ByteBuffer buf2 = ByteBuffer.allocate(200);
		//3.分散读取
		ByteBuffer [] bufs = {buf1,buf2};
		channel1.read(bufs);
		
		for( ByteBuffer byteBuffer : bufs) {
			byteBuffer.flip();
		}
		System.out.println(new String(bufs[0].array()));
		System.out.println("-------------------");
		System.out.println(new String(bufs[1].array()));
		
		//聚集写入
		RandomAccessFile ran2 = new RandomAccessFile(path+"2.txt", "rw");
		FileChannel channel2 = ran2.getChannel();
		channel2.write(bufs);
	}

}

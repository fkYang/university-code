package study.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class TestChannel {
	static String path="D:\\31577\\桌面\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		copyFileTransfer();
	}
	
	static void copyFileTransfer() throws Throwable {
		FileChannel fin = FileChannel.open(Paths.get(path+"1.txt"), StandardOpenOption.READ);
		FileChannel fout = FileChannel.open(Paths.get(path+"3.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
	//	fin.transferTo(0, fin.size(), fout);
		fout.transferFrom(fin, 0,fin.size());
		
		fin.close();
		fout.close();
	}
	
	//通道，非直接缓冲区，文件复制
	static void copyFile() throws Throwable {
		FileInputStream in = new FileInputStream(path+"1.txt");
		FileOutputStream out = new FileOutputStream(path+"2.txt");
		
		//1.get channel
		
		FileChannel finChannel = in.getChannel();
		FileChannel foutChannel = out.getChannel();
		
		//2.分配指定大小的缓冲区,默认初始化，写模式
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		//3.将通道种的数据存入通道，
		while( finChannel.read(byteBuffer) != -1 ) {
			byteBuffer.flip();//切换读数据模式
			foutChannel.write(byteBuffer);//4.缓冲区数据写入通道
			byteBuffer.clear();
		}
		finChannel.close();
		foutChannel.close();
		in.close();
		out.close();
		
		
	}

	//直接缓冲区
	static void copyFileDirect() throws Throwable {
		FileChannel fin = FileChannel.open(Paths.get(path+"1.txt"), StandardOpenOption.READ);
		FileChannel fout = FileChannel.open(Paths.get(path+"3.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		//内存映射文件
		MappedByteBuffer inmapBuffer = fin.map(MapMode.READ_ONLY, 0, fin.size());
		MappedByteBuffer outmapBuffer = fout.map(MapMode.READ_WRITE, 0, fin.size());
		
		//直接对缓冲区对数据进行读写
		byte[] dst = new byte[inmapBuffer.limit()];
		inmapBuffer.get(dst);
		
		outmapBuffer.put(dst);
		
		fin.close();
		fout.close();
		
	}

}

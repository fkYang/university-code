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
	static String path="D:\\31577\\����\\StudyCode\\university-code\\IdeaStudyCode\\target\\classes\\io\\nio\\";
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
	
	//ͨ������ֱ�ӻ��������ļ�����
	static void copyFile() throws Throwable {
		FileInputStream in = new FileInputStream(path+"1.txt");
		FileOutputStream out = new FileOutputStream(path+"2.txt");
		
		//1.get channel
		
		FileChannel finChannel = in.getChannel();
		FileChannel foutChannel = out.getChannel();
		
		//2.����ָ����С�Ļ�����,Ĭ�ϳ�ʼ����дģʽ
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		//3.��ͨ���ֵ����ݴ���ͨ����
		while( finChannel.read(byteBuffer) != -1 ) {
			byteBuffer.flip();//�л�������ģʽ
			foutChannel.write(byteBuffer);//4.����������д��ͨ��
			byteBuffer.clear();
		}
		finChannel.close();
		foutChannel.close();
		in.close();
		out.close();
		
		
	}

	//ֱ�ӻ�����
	static void copyFileDirect() throws Throwable {
		FileChannel fin = FileChannel.open(Paths.get(path+"1.txt"), StandardOpenOption.READ);
		FileChannel fout = FileChannel.open(Paths.get(path+"3.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		//�ڴ�ӳ���ļ�
		MappedByteBuffer inmapBuffer = fin.map(MapMode.READ_ONLY, 0, fin.size());
		MappedByteBuffer outmapBuffer = fout.map(MapMode.READ_WRITE, 0, fin.size());
		
		//ֱ�ӶԻ����������ݽ��ж�д
		byte[] dst = new byte[inmapBuffer.limit()];
		inmapBuffer.get(dst);
		
		outmapBuffer.put(dst);
		
		fin.close();
		fout.close();
		
	}

}

package study.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CharsetDemo {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		CharsetDE();
	}

	static void CharsetDemo() {
		Map<String, Charset> map = Charset.availableCharsets();
		Set<Entry<String, Charset>> set = map.entrySet();
		
		for(Entry<String, Charset>  entry:set) {
			System.out.println( entry.getKey() + " ---" + entry.getValue());
		}
	}
	
	static void CharsetDE() throws Throwable {
		Charset cs = Charset.forName("GBK");
		//»ñµÃ±àÂëÆ÷
		CharsetEncoder en = cs.newEncoder();
		//decoder
		CharsetDecoder de = cs.newDecoder();

		CharBuffer cbuffer = CharBuffer.allocate(1024);
		
		cbuffer.put("hello ×Ö·ûji");
		cbuffer.flip();
		
		//±àÂë
		ByteBuffer bBuffer = en.encode(cbuffer);
		for( int i = 0 ; i < bBuffer.limit();i++) {
			System.out.println(bBuffer.get());
		}
		bBuffer.flip();
		
	
		//jiema
		CharBuffer cBuffer2 = de.decode(bBuffer);
		System.out.println(cBuffer2.toString());
		
		bBuffer.flip();
		Charset cs2 = Charset.forName("UTF-8");
		cBuffer2 = cs2.decode(bBuffer);
		System.out.println(cBuffer2.toString());
	}
}

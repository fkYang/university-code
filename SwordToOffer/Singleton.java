package SwordToOffer;


public class Singleton {
	//volatile 防止重排序，使得未初始化的类对象被使用
	//volatile，内存屏障，可见性，防止重排序
	private static volatile Singleton instance;
	public Singleton getInstance() {
		//第一个判断，防止过多阻塞
		if( instance == null ) {
			synchronized (Singleton.class) {
				//第二个判断，防止在阻塞期间，其他进程完成初始化
				if( instance == null )
					instance = new Singleton();
			}
		}
		
		return instance;
	}
	//	
	private Singleton(){
		
	}
	
}

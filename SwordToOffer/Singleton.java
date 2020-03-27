package SwordToOffer;


public class Singleton {
	//volatile ��ֹ������ʹ��δ��ʼ���������ʹ��
	//volatile���ڴ����ϣ��ɼ��ԣ���ֹ������
	private static volatile Singleton instance;
	public Singleton getInstance() {
		//��һ���жϣ���ֹ��������
		if( instance == null ) {
			synchronized (Singleton.class) {
				//�ڶ����жϣ���ֹ�������ڼ䣬����������ɳ�ʼ��
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

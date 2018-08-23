
public class BFS {
	public static int run[]=new int[9];//��¼�Ƿ������
	public static GraphList head[]=new GraphList[9];
	public static int MAXSIZE = 10;//������е��������
	static int [] queue =new int [MAXSIZE];//������������
	static int front=-1;//ָ�����е�ǰ��
	static int rear=-1;//ָ����к��
	//�������ݵĴ���
	public static void enqueue(int value) {
		if(rear>=MAXSIZE) return;
		rear++;
		queue[rear]=value;
	}
	//��������ȡ��
	public static int dequeue(){
		if(front==rear)
			return -1;
		front++;
		return queue[front];
	}
	//�������������
	public static void bfs(int current) {
		Node tempnode;//��ʱ�ڵ�ָ��
		enqueue(current);//��һ��������ջ
		run[current]=1;//��������������Ϊ1
		System.out.print("["+current+"]");//��ӡ�������Ķ���
		while(front!=rear) {//�ж��Ƿ�ն���
			current=dequeue();
			tempnode=head[current].first;//��¼Ŀǰ����λ��
			while(tempnode!=null) {
				if(run[tempnode.x]==0) {
					enqueue(tempnode.x);
					run[tempnode.x]=1;
					System.out.print("["+tempnode.x+"]");
				}
				tempnode=tempnode.next;
			}
			
		}
		
	}
	public static void main(String[] args) {
		int Data[][]= //ͼ�α�����������
			{
					{1,2},{2,1},{1,3},{3,1},{2,4},{4,2},{2,5},{5,2},{3,6},{6,3},
					{3,7},{7,3},{4,5},{5,4},{6,7},{7,6},{5,8},{8,5},{6,8},{8,6}
			};
		int DataNum;
		int i,j;
		System.out.println("ͼ�ε��ڽӱ����ݣ�");
		for (i=1;i<9;i++) {//8������
			run[i]=0;//�趨���ж���Ϊδ������
			head[i]=new GraphList();
			System.out.print("����"+i+"=>");
			for(j=0;j<20;j++) {//20����
				if(Data[j][0]==i) {//��������б�ı�����ͬ���Ѷ�������б�
					DataNum=Data[j][1];
					head[i].insert(DataNum);
				}
			}
			head[i].print();
		}
		System.out.println("������ȱ�������");
		bfs(1);
		System.out.println();
	}
}

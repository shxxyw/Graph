
public class BFS {
	public static int run[]=new int[9];//记录是否遍历过
	public static GraphList head[]=new GraphList[9];
	public static int MAXSIZE = 10;//定义队列的最大容量
	static int [] queue =new int [MAXSIZE];//队列数组声明
	static int front=-1;//指到队列的前端
	static int rear=-1;//指向队列后端
	//队列数据的存入
	public static void enqueue(int value) {
		if(rear>=MAXSIZE) return;
		rear++;
		queue[rear]=value;
	}
	//队列数据取出
	public static int dequeue(){
		if(front==rear)
			return -1;
		front++;
		return queue[front];
	}
	//广度优先搜索法
	public static void bfs(int current) {
		Node tempnode;//临时节点指针
		enqueue(current);//第一个顶点入栈
		run[current]=1;//将遍历过顶点设为1
		System.out.print("["+current+"]");//打印遍历过的顶点
		while(front!=rear) {//判断是否空队列
			current=dequeue();
			tempnode=head[current].first;//记录目前顶点位置
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
		int Data[][]= //图形边线数组声明
			{
					{1,2},{2,1},{1,3},{3,1},{2,4},{4,2},{2,5},{5,2},{3,6},{6,3},
					{3,7},{7,3},{4,5},{5,4},{6,7},{7,6},{5,8},{8,5},{6,8},{8,6}
			};
		int DataNum;
		int i,j;
		System.out.println("图形的邻接表内容：");
		for (i=1;i<9;i++) {//8个顶点
			run[i]=0;//设定所有顶点为未遍历过
			head[i]=new GraphList();
			System.out.print("顶点"+i+"=>");
			for(j=0;j<20;j++) {//20条边
				if(Data[j][0]==i) {//如果起点和列表的表首相同，把顶点加入列表
					DataNum=Data[j][1];
					head[i].insert(DataNum);
				}
			}
			head[i].print();
		}
		System.out.println("广度优先遍历顶点");
		bfs(1);
		System.out.println();
	}
}

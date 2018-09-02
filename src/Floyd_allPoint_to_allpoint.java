//图形的邻接矩阵类声明
 class Adjacency_Floyd{
	final int INFINITE=9999;
	public int [][] Graph_Matrix;//n*n的邻接表
	public Adjacency_Floyd(int[][] Weight_Path,int number) {
		// TODO Auto-generated constructor stub
		int i,j;
		int start_point,end_point;
		Graph_Matrix=new int [number][number];
	
		//先赋初值
		for(i=1;i<number;i++)
			for(j=1;j<number;j++)
				if(i!=j)
					Graph_Matrix[i][j]=INFINITE;
				else
					Graph_Matrix[i][j]=0;
		
		for(i=0;i<Weight_Path.length;i++) {
			start_point=Weight_Path[i][0];
			end_point=Weight_Path[i][1];
			Graph_Matrix[start_point][end_point]=Weight_Path[i][2];
			}
	}
	//显示图形
	public void printGraph_Matrix() {
		for(int i=1;i<Graph_Matrix.length;i++) {
			for(int j=1;j<Graph_Matrix[i].length;j++) {
				if(Graph_Matrix[i][j]==INFINITE)
					System.out.print(" x ");
				else {
					if(Graph_Matrix[i][j]==0) 
						System.out.print(" ");
					System.out.print(Graph_Matrix[i][j]+" ");
					}
			}
			System.out.println();
		}
	}
}

//Floyd算法类
class Floyd extends Adjacency_Floyd{
	private int[][] cost;
	private int capcity;
	//构造函数
	public Floyd(int[][] Weight_Path,int number) {
		// TODO Auto-generated constructor stub
	    super(Weight_Path,number);
		cost = new int[number][];
		capcity=Graph_Matrix.length;
		for(int i = 0;i<capcity;i++)
			cost[i]=new int[number];
		
		
	}
	//所有顶点两两之间的最短距离
	public void shortestPath() {
		
		//初始第一趟A0即初始的Graph_Matrix
		for(int i=1;i<Graph_Matrix.length;i++)
			for(int j=i;j<Graph_Matrix.length;j++) {//其实读取数据为无向图
				cost[i][j]=cost[j][i]=Graph_Matrix[i][j];//要有向图直接用cost[i][j]读取矩阵，i，j从1开始
				
			}
		
		for(int k=1;k<Graph_Matrix.length;k++)//从A0到An进行循环
			for(int i=1;i<Graph_Matrix.length;i++)
				for(int j=1;j<Graph_Matrix.length;j++)
					if(cost[i][j]>cost[i][k]+cost[k][j])
						cost[i][j]=cost[i][k]+cost[k][j];
		System.out.print("顶点 vex1 vex2 vex3 vex4 vex5 vex6 \n");
		for(int i=1;i<Graph_Matrix.length;i++) {
			System.out.print("vex"+i+" ");
			for(int j=1;j<Graph_Matrix.length;j++) {
				//调整显示位置，显示距离数组
				if(cost[i][j]<10) System.out.print(" ");
				if(cost[i][j]<100)System.out.print(" ");
				System.out.print(" "+cost[i][j]+" ");
					
			}
			System.out.println();
		}
	}
}
public class Floyd_allPoint_to_allpoint {
	public static void main(String[] args) {
		int Weight_Path[][]= {{1,2,10},{2,3,20},{2,4,25},{3,5,18},
				{4,5,22},{4,6,95},{5,6,77}};
		Floyd object = new Floyd(Weight_Path,7);
		System.out.println("=====================================");
		System.out.println("此范例图形的相邻矩阵如下： ");
		System.out.println("=====================================");
		object.printGraph_Matrix();
		System.out.println("=====================================");
		System.out.println("所有顶点两两之间最短距离：");
		System.out.println("=====================================");
		object.shortestPath();
	}
	
}


public class DFS {
	public static int run[]=new int[9];
	public static GraphList head[]=new GraphList[9];
//	深度优先遍历的子程序
	public static void dfs(int current) {
		run[current]=1;
		System.out.print("["+current+"]");
		
		while ((head[current].first)!=null) {
			if(run[head[current].first.x]==0)//如果顶点尚未遍历，就调用dfs递归调用
				dfs(head[current].first.x);
			head[current].first=head[current].first.next;
		}
	}
	
	public static void main (String args[]) {
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
		//打印深度优先遍历的顶点
		dfs(1);
		System.out.println();
	}
}

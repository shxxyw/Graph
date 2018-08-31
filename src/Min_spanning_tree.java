/*
 * 测试最小成本生成树
 * 利用Kruskal算法
 */
public class Min_spanning_tree {
	public static int VERTS=6;//顶点数
	public static int v[] = new int [VERTS+1]; 
	public static Node_Min_spanning_tree NewList = new Node_Min_spanning_tree();
	
	public static int findmincost() {
		int minval=100;
		int retptr=0;
		int a=0;
		while(NewList.Next[a]!=-1) {
			if(NewList.val[a]<minval && NewList.find[a]==0) {
				minval=NewList.val[a];
				retptr=a;
			}
			a++;
		}
		NewList.find[retptr]=1;
		return retptr;
	}
	public static void mintree() {
		int i,result=0;
		int mceptr;
		int a=0;
		for(i=0;i<=VERTS;i++)
			v[i]=0;
		while(NewList.Next[a]!=-1) {
			mceptr=findmincost();
			v[NewList.from[mceptr]]++;//设标记，表示用过一次，每一个路径只能用一次
			v[NewList.to[mceptr]]++;
			if(v[NewList.from[mceptr]]>1 && v[NewList.to[mceptr]]>1) {
				v[NewList.from[mceptr]]--;
				v[NewList.to[mceptr]]--;
				result=1;//不执行操作
			}else
				result=0;
			if(result==0) {
				System.out.print("起始顶点["+NewList.from[mceptr]+"] 终止顶点[");
				System.out.print(NewList.to[mceptr]+"] 路径长度["+NewList.val[mceptr]+"]");
				System.out.println();
			}
			a++;
		}
	}
	public static void main(String args[]) {
		//图形数据声明
		int Data[][]= {
				{1,2,6}	,{1,6,12},{1,5,10},{2,3,3},{2,4,5},
				{2,6,8},{3,4,7},{4,6,11},{4,5,9},{5,6,16} 
		};
		int DataNum;
		int fromNum;
		int toNum;
		int findNum;//作为一个标志，记录是否访问过该路径
		int Header = 0;
		int FreeNode;
		int i,j;
		System.out.println("建立图形表：");
		/*打印图形邻接表的内容*/
		for(i=0;i<10;i++) {
			for(j=1;j<=VERTS;j++) {
				if(Data[i][0]==j) {
					fromNum = Data[i][0];
					toNum = Data[i][1];
					DataNum = Data[i][2];
					findNum=0;
					FreeNode = NewList.FindFree();
					NewList.Create(Header, FreeNode, DataNum, fromNum, toNum, findNum);
				}
			}
		}
		NewList.PrinterList(Header);
		System.out.println("建立最小成本生成树");
		mintree();
	}

}


class Node_Min_spanning_tree{
	int MaxLength=20;
	int from[] = new int [MaxLength];
	int to[] = new int [MaxLength];
	int find[] = new int [MaxLength];
	int val[] = new int[MaxLength];
	int Next[] = new int [MaxLength];//链表下一个节点的位置
	
	public Node_Min_spanning_tree() {
		for(int i=0;i<MaxLength;i++) {
			Next[i]=-2;//-2表示未用的节点
		}
	}
	
//	搜索可用的节点位置
	public int FindFree() {
		int i;
		for(i=0;i<MaxLength;i++)
			if(Next[i]==-2)
				break;
		return i;
	}
	
//	建立链表
	public void Create(int Header,int FreeNode,int DataNum,int fromNum,
			int toNum,int findNum) {
		int Pointer;//现在节点位置
		if(Header==FreeNode) {//新的链表
			val[Header] = DataNum;//设定数据编号
			from[Header]=fromNum;
			find[Header]=findNum;
			to[Header]=toNum;
			Next[Header]=-1;//下一个节点的位置，-1表示空节点
		}
		else {
			Pointer = Header;//现在的节点为头节点
			val[FreeNode] = DataNum;//设定数据编号
			from[FreeNode] = fromNum;
			find[FreeNode] = findNum;
			to[FreeNode] = toNum;
			//设定数据名字
			Next[FreeNode] = -1;//下一个节点的位置，-1表示空节点
			//找寻链表尾端
			while(Next[Pointer]!=-1)
				Pointer = Next[Pointer];
			//将新节点串联在原表的尾端
			Next[Pointer] = FreeNode;
		}
	}
	
//	打印链表数据
	public void PrinterList(int Header) {
		int Pointer;
		Pointer = Header;
		while(Pointer != -1) {
			System.out.print("起始顶点["+from[Pointer]+"] 终止顶点[");
			System.out.print(to[Pointer]+"] 路径长度["+val[Pointer]+"]");
			System.out.println();
			Pointer = Next[Pointer];
		}
	}
}
/*
 * ������С�ɱ�������
 * ����Kruskal�㷨
 */
public class Min_spanning_tree {
	public static int VERTS=6;//������
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
			v[NewList.from[mceptr]]++;//���ǣ���ʾ�ù�һ�Σ�ÿһ��·��ֻ����һ��
			v[NewList.to[mceptr]]++;
			if(v[NewList.from[mceptr]]>1 && v[NewList.to[mceptr]]>1) {
				v[NewList.from[mceptr]]--;
				v[NewList.to[mceptr]]--;
				result=1;//��ִ�в���
			}else
				result=0;
			if(result==0) {
				System.out.print("��ʼ����["+NewList.from[mceptr]+"] ��ֹ����[");
				System.out.print(NewList.to[mceptr]+"] ·������["+NewList.val[mceptr]+"]");
				System.out.println();
			}
			a++;
		}
	}
	public static void main(String args[]) {
		//ͼ����������
		int Data[][]= {
				{1,2,6}	,{1,6,12},{1,5,10},{2,3,3},{2,4,5},
				{2,6,8},{3,4,7},{4,6,11},{4,5,9},{5,6,16} 
		};
		int DataNum;
		int fromNum;
		int toNum;
		int findNum;//��Ϊһ����־����¼�Ƿ���ʹ���·��
		int Header = 0;
		int FreeNode;
		int i,j;
		System.out.println("����ͼ�α���");
		/*��ӡͼ���ڽӱ�������*/
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
		System.out.println("������С�ɱ�������");
		mintree();
	}

}


class Node_Min_spanning_tree{
	int MaxLength=20;
	int from[] = new int [MaxLength];
	int to[] = new int [MaxLength];
	int find[] = new int [MaxLength];
	int val[] = new int[MaxLength];
	int Next[] = new int [MaxLength];//������һ���ڵ��λ��
	
	public Node_Min_spanning_tree() {
		for(int i=0;i<MaxLength;i++) {
			Next[i]=-2;//-2��ʾδ�õĽڵ�
		}
	}
	
//	�������õĽڵ�λ��
	public int FindFree() {
		int i;
		for(i=0;i<MaxLength;i++)
			if(Next[i]==-2)
				break;
		return i;
	}
	
//	��������
	public void Create(int Header,int FreeNode,int DataNum,int fromNum,
			int toNum,int findNum) {
		int Pointer;//���ڽڵ�λ��
		if(Header==FreeNode) {//�µ�����
			val[Header] = DataNum;//�趨���ݱ��
			from[Header]=fromNum;
			find[Header]=findNum;
			to[Header]=toNum;
			Next[Header]=-1;//��һ���ڵ��λ�ã�-1��ʾ�սڵ�
		}
		else {
			Pointer = Header;//���ڵĽڵ�Ϊͷ�ڵ�
			val[FreeNode] = DataNum;//�趨���ݱ��
			from[FreeNode] = fromNum;
			find[FreeNode] = findNum;
			to[FreeNode] = toNum;
			//�趨��������
			Next[FreeNode] = -1;//��һ���ڵ��λ�ã�-1��ʾ�սڵ�
			//��Ѱ����β��
			while(Next[Pointer]!=-1)
				Pointer = Next[Pointer];
			//���½ڵ㴮����ԭ����β��
			Next[Pointer] = FreeNode;
		}
	}
	
//	��ӡ��������
	public void PrinterList(int Header) {
		int Pointer;
		Pointer = Header;
		while(Pointer != -1) {
			System.out.print("��ʼ����["+from[Pointer]+"] ��ֹ����[");
			System.out.print(to[Pointer]+"] ·������["+val[Pointer]+"]");
			System.out.println();
			Pointer = Next[Pointer];
		}
	}
}
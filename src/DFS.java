
public class DFS {
	public static int run[]=new int[9];
	public static GraphList head[]=new GraphList[9];
//	������ȱ������ӳ���
	public static void dfs(int current) {
		run[current]=1;
		System.out.print("["+current+"]");
		
		while ((head[current].first)!=null) {
			if(run[head[current].first.x]==0)//���������δ�������͵���dfs�ݹ����
				dfs(head[current].first.x);
			head[current].first=head[current].first.next;
		}
	}
	
	public static void main (String args[]) {
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
		//��ӡ������ȱ����Ķ���
		dfs(1);
		System.out.println();
	}
}

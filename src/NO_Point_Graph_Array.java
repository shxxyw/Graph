
public class NO_Point_Graph_Array {
public static void main(String args[]) {
//	ͼ�θ��ߵ���ʼֵ���յ�ֵ
	int [][] data= {{1,2},{2,1},{1,5},{5,1},{2,3},{3,2},{2,4},{4,2},{3,4},{4,3},{3,5},
			{5,3},{4,5},{5,4}};
	int arr[][]=new int[6][6];
	int i,j,k,tmpi,tmpj;
	for(i=0;i<6;i++)
		for(j=0;j<6;j++)
			arr[i][j]=0;
//	��ȡͼ������
	for(i=0;i<14;i++)
 {
				tmpi=data[i][0];
				tmpj=data[i][1];
				arr[tmpi][tmpj]=1;//�бߵĵط�Ϊ1
			}
//	���
	System.out.print("����ͼ�ξ���\n");
	for(i=0;i<6;i++) {
		for(j=0;j<6;j++){
			System.out.print("["+arr[i][j]+"]");
		}System.out.println();
	}
}
}

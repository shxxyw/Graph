class Node{
	int x;
	Node next;
	public Node(int x) {
	this.x=x;
	this.next=null;
	}
}
class GraphList{
	public Node first;
	public Node last;
	public boolean isEmpty() {
		return first==null;
	}
	public void print() {
		Node current = first;
		while(current!=null) {
			System.out.print("["+current.x+"]");
			current=current.next;
		}
		System.out.println();
	}
	public void insert(int x) {
		Node newNode=new Node(x);
		if(this.isEmpty()) {
			first=newNode;
			last=newNode;
		}else {
			last.next=newNode;
			last=last.next;
		}
	}
}
public class adjacency_list {
	public static void main(String[] args) {
		
	
//	图形各边的起始值及终点值
	int [][] data= {{1,2},{2,1},{1,5},{5,1},{2,3},{3,2},{2,4},{4,2},{3,4},{4,3},{3,5},
			{5,3},{4,5},{5,4}};
	int DataNum;
	int i,j;
	System.out.println("邻接表内容为：");
	GraphList head[]=new GraphList[6];
	for(i=1;i<6;i++) {
		head[i]=new GraphList();
		System.out.print("顶点"+i+"=>");
		for(j=0;j<14;j++) {
			if(data[j][0]==i) {
				DataNum=data[j][1];
				head[i].insert(DataNum);
			}
		} head[i].print();
	}
	}
}

//dfs and bfs with hasCycle method (for directed graph only)

import java.util.*;

public class App{
	
	public static boolean hasCycle(int des,byte [][] a,int vertices){
		if(dfs(a,vertices,des)==-9){return true;}
		return false;
	}
	
	public static void bfs(byte [][] a,int vertices,int source){            //passing adjacency matrix and no of vertices
		byte []b=new byte[vertices];
		Arrays.fill(b,(byte)-1);
		Stack <Integer> st=new Stack<>();
		st.push(source);                                                 //assigning source
		while(!st.isEmpty()){
			b[st.peek()]=(byte)0;                                   //assigning waiting status
			System.out.println(st.elementAt(0));
			int pop=st.elementAt(0);b[pop]=(byte)1;st.removeElementAt(0);                       //assigning processed status
			for(int i=0;i<vertices;i++){
				if(a[pop][i]!=0 && b[i]!=(byte)0 && b[i]!=(byte)1 ){
					st.push(i);b[i]=(byte)0;                        //assigning waiting status
				}}}
	}
	
	
	public static int dfs(byte [][] a,int vertices,int source){            //passing adjacency matrix and no of vertices
		int ret=0;
		byte []b=new byte[vertices];
		Arrays.fill(b,(byte)-1);
		Stack <Integer> st=new Stack<>();
		st.push(source);                                                 //assigning source
		while(!st.isEmpty()){
			b[st.peek()]=(byte)0;                                   //assigning waiting status
			System.out.println(st.peek());
			int pop=st.pop();b[pop]=(byte)1; ret=pop;                       //assigning processed status
			for(int i=0;i<vertices;i++){
				if(a[pop][i]!=0 && b[i]==(byte)1 && i==source){return -9;}
				if(a[pop][i]!=0 && b[i]!=(byte)0 && b[i]!=(byte)1 ){
					st.push(i);b[i]=(byte)0;                        //assigning waiting status
				}}}return ret;
	}
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int vertices=in.nextInt(),source=in.nextInt();
		byte [][]a=new byte [vertices][vertices];
		for(int i=0;i<vertices;i++){
			int size =in.nextInt();
			for(int j=0;j<size;j++){
				a[i][in.nextInt()]=1;                                //taking adjacency entries
			}
		}
		System.out.println(hasCycle(source,a,vertices));                                            //function call
	}}

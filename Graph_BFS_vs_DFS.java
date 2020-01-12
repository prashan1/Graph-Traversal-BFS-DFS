import java.util.LinkedList;
import java.util.*;
class Graph_BFS_vs_DFS{
	static class Graph{
		
		int size = 0 ;
		LinkedList< Integer > start[] ;
		 
		 public Graph(int size){
			 
			 this.size = size;
			 start = new LinkedList[ size ];
			 int p = size;
			for(int i = 0 ; i < size ; i++)
				 start[ i ] = new LinkedList<>();
		 }
		 
		 public void add( int src , int dest ){						
			 
		 start[ src ].add( dest );
		
		 }
	}
	
	public static void main( String[] arg){
		
		Graph g = new Graph(4);
		 g.add(0, 1); 
        g.add(0, 2); 
        g.add(1, 2); 
        g.add(2, 0); 
        g.add(2, 3); 
        g.add(3, 3); 
		boolean[] checkLoop1 = new boolean[ 4 ];
		System.out.println( "BFS");
		DisplayBFS(g,2,checkLoop1);
		System.out.println( "\nDFS");
		boolean[] checkLoop2 = new boolean[ 4 ];
		DisplayDFS(g,2,checkLoop2);
	}
	
	public static void DisplayBFS(Graph graph,  int  s ,boolean[] checkLoop){        		//BFS
		
		Queue< Integer > q = new LinkedList<>();
		
		checkLoop[ s ] = true;
		q.offer( s );
		
		while( !q.isEmpty() ){
			
			int store = q.poll();
			
			System.out.print( store +" ");
				
				for(int n : graph.start[ store ]){	
				if( checkLoop[ n ] )
					continue;
				
				checkLoop[ n ] = true;
				q.offer( n );
			}
		}
	}
	
	public static void DisplayDFS( Graph g , int root,boolean[] checkLoop){       				//DFS
		
		checkLoop[ root ] = true;
		System.out.print( root+ " ");
		 
			for(int n : g.start[ root])
			if(!checkLoop[ n ] )
				DisplayDFS(  g ,  n , checkLoop );
			
	
	}
	
	
}
			
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
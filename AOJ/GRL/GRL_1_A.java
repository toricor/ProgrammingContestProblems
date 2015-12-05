import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    static void dijkstra(ArrayList<Node> nodes, int start){
        Comparator<Node> comparator = new NodeCostComparator();
        PriorityQueue<Node> pq      = new PriorityQueue<Node>(10, comparator);
        nodes.get(start).cost = 0;
        pq.add(nodes.get(start));
        
        while (!pq.isEmpty()){
        	Node done_node = pq.poll();
        	for (int i = 0; i < done_node.edge_to.size(); i++){
        		int to 	 	 = done_node.edge_to.get(i);
        		int cost 	 = done_node.edge_cost.get(i);
        		int new_cost = done_node.cost + cost;
        		int to_cost  = nodes.get(to).cost;
        		if (to_cost < 0 || new_cost < to_cost){
        			nodes.get(to).cost = new_cost;
        			if (!pq.contains(nodes.get(to))){
        				pq.add(nodes.get(to));
        			}
        		}
        	}
        }
    }
    static void print_results(ArrayList<Node> nodes){    
        for (int i = 0; i < nodes.size(); i++){
            int cst = nodes.get(i).cost;
            if (cst == -1){
                System.out.println("INF");
            }else{
                System.out.println(cst);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        int r = Integer.parseInt(line[2]);
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < V; i++){
            ArrayList<Integer> edge_to   = new ArrayList<Integer>();
            ArrayList<Integer> edge_cost = new ArrayList<Integer>();
            Node node = new Node(-1, edge_to, edge_cost);
            nodes.add(node);
        }
        
        for (int i = 0; i < E; i++){
            String[] line2 = br.readLine().split(" ");
            int s = Integer.parseInt(line2[0]);
            int t = Integer.parseInt(line2[1]);
            int d = Integer.parseInt(line2[2]);
            nodes.get(s).edge_to.add(t);
            nodes.get(s).edge_cost.add(d);
        }
        dijkstra(nodes, r);
        print_results(nodes);
    }
}
class NodeCostComparator implements Comparator<Node>{
    @Override
    public int compare(Node x, Node y){
        int value = x.cost - y.cost;
        if (value < 0){
            return -1;
        }
        if (value > 0){
            return 1;
        }
        return 0;
    }
}

class Node{
    int cost;
    ArrayList<Integer> edge_to;
    ArrayList<Integer> edge_cost;
    
    Node(int cost, ArrayList<Integer> edge_to, ArrayList<Integer> edge_cost){
        this.cost       = cost;
        this.edge_to    = edge_to;
        this.edge_cost  = edge_cost;
    }
}

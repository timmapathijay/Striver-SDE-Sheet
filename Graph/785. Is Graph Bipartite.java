class Node{
    int nodeValue, set;
    public Node(int nodeValue, int set)
    {
        this.nodeValue = nodeValue;
        this.set = set;
    }
}
class Solution {
    private boolean checkIsBipartite(int startNode, int[][] graph, int[] set)
    {
        // 1 - set A  , 2 - set B , 0 - not yet put into any set
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startNode, 1));
        set[startNode] = 1;
        while(!queue.isEmpty())
        {
            Node node = queue.poll();
            // add adjacent nodes in sets
            for(int neighborNode : graph[node.nodeValue])
            {
                if(set[neighborNode] == 0)
                {
                    set[neighborNode] = set[node.nodeValue] == 1 ? 2 : 1;
                    queue.add(new Node(neighborNode, set[neighborNode]));
                }
                else if(set[neighborNode] == set[node.nodeValue])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] set = new int[V];
        for(int i = 0; i < V; i++)
        {
            if(set[i] == 0)
            {
                if(checkIsBipartite(i, graph, set) == false)
                return false;
            }
        }
        return true;        
    }
}
// TC : V + (V + 2E)
// SC : V(visited) + V(Queue)

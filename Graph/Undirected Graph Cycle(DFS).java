class Solution {
    private boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adjList, 
    boolean[] visited, int parentNode){
        visited[node] = true;
        // Adjacent-Node 
        for(Integer neighbourNode : adjList.get(node))
        {
            if(!visited[neighbourNode])
            {
                if(detectCycle(neighbourNode, adjList, visited, node))
                return true;
            }
            else if(neighbourNode != parentNode)
            return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        // Multiple-Components
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(detectCycle(i, adjList, visited, -1))
                return true;
            }
        }
        return false;
    }
}
// TC : V + E + V(Multiple-Components) + (V + 2E) (DFS Traversal)
// SC : V(Visited Array) + (V + 2E)[Adj-List] + V[Recursive-Stack-Space]  

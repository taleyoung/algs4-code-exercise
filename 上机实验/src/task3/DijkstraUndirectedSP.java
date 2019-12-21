package task3;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.IndexMultiwayMinPQ;

import edu.princeton.cs.algs4.Stack;

public class DijkstraUndirectedSP{
    private double[] distTo;
    private Edge[] edgeTo;
//    private IndexMinPQ<Double> pq;
    private IndexMultiwayMinPQ<Double> pq;
    private EdgeWeightedGraph mGraph;
    private Point2D []point2DS;
    private int from;
    private int to;
    public DijkstraUndirectedSP(EdgeWeightedGraph G,Point2D[] point){
        point2DS=point;
        mGraph=G;
        for(Edge e : G.edges()){
            if(e.weight()<0)
                throw new IllegalArgumentException("权重不能为负数！");
        }
        distTo =new double[G.V()];
        edgeTo =new Edge[G.V()];
        for(int v=0;v<G.V();v++)
            distTo[v]=Double.POSITIVE_INFINITY;
//        pq=new IndexMinPQ<>(G.V());
        //想法三，使用更快的优先队列 三路堆
        pq=new IndexMultiwayMinPQ<Double>(G.V(),3);
    }
    public void setFrom(int from){
        initDijkstra();
        this.from =from;
        distTo[from]=0.0;
        pq.insert(from,distTo[from]);
    }
    public void setTo(int to){
        this.to =to;
    }
    //优化二,Dijkstra 通过将 d[w]更新为 d[v] + 从 v 到 w 的距离来松弛边 v-w。
    // 对于地图， 则将d[w]更新为d[v] + 从v到w的距离 + 从w到d的欧式距离 − 从v到d的欧式距离。
    private void relax(Edge e,int v){
        int w = e.other(v);
//        double weight = distTo[v] + e.weight();
        double weight = distTo[v] + e.weight() + point2DS[v].distanceTo(point2DS[to]) - point2DS[w].distanceTo(point2DS[to]) ;
        if (distTo[w] > weight) {
            distTo[w] = weight;
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }
    public double distTo(int v){
        return distTo[v];
    }
    //想法一，Dijkstra 算法的朴素实现检查图中的所有 V 个顶点。优化方案是一旦发现目的地的最短路径就停止搜索。
    public boolean hasPathTo(int v){
        while(!pq.isEmpty()){
            int x = pq.delMin();
            if(x==v){
                return true;
            }
            for(Edge e : mGraph.adj(x))
                relax(e,x);
        }
        return distTo[v]<Double.POSITIVE_INFINITY;
    }
    public void initDijkstra(){
        for (int i = 0; i<mGraph.V();i++){
            if (pq.contains(i)) {
                pq.delete(i);
            }
            if (edgeTo[i]!=null) {
                edgeTo[i] = null;
            }
            if (!Double.isInfinite(distTo(i))) {
                distTo[i] = Double.POSITIVE_INFINITY;
            }
        }
    }
    public Iterable<Edge> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }
}
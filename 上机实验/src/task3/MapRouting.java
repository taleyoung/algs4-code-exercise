package task3;


import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Scanner;




public class MapRouting {
    public static void init_Point(In in, Point2D[] p){
        for (int i = 0; i<p.length;i++){
            int q =in.readInt();
            int x =in.readInt();
            int y =in.readInt();
            p[i] = new Point2D(x,y);
        }

    }

    public static void init_Graph(In in, int b,EdgeWeightedGraph e,Point2D[] a){
        for (int i = 0;i<b;i++){
            int q = in.readInt();
            int l = in.readInt();
            double weight = a[q].distanceTo(a[l]);
            e.addEdge(new Edge(q, l, weight));
        }

    }

    public static void findRoute(EdgeWeightedGraph mDigraph,Point2D[] mpoint){
        Scanner in =new Scanner(System.in);

        DijkstraUndirectedSP msp = new DijkstraUndirectedSP(mDigraph,mpoint);

        while (true){
            StdOut.println("请输入两个顶点");
            int from =in.nextInt();
            int to =in.nextInt();
            msp.setFrom(from);
            msp.setTo(to);
            boolean boo = msp.hasPathTo(to);
            if (boo){
                StdOut.println("最短路径为：");
                for (Edge e : msp.pathTo(to)){
                    StdOut.println(e+" ");
                }
                StdOut.println(from+"->"+to+"的最短路径长度为："+ msp.distTo(to));
                StdOut.println();
            }else {
                StdOut.println("不存在一条路径");
            }
        }
    }
    public static void main(String[] args) {
        In in=new In("usa.txt");
        int a=in.readInt();
        int b=in.readInt();
        EdgeWeightedGraph mDigraph=new EdgeWeightedGraph(a);
        Point2D []mPoints=new Point2D [a];
        init_Point(in,mPoints);
        init_Graph(in,b,mDigraph,mPoints);
        findRoute(mDigraph,mPoints);
    }

}

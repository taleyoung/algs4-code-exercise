package task1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class Main {
    private int trialNum;

    private double[] preP;
    public Main(int n,int trialNum) {
        if (n<1 || trialNum<1) throw new IllegalArgumentException("Illegal n or trialNum,please check");
        this.trialNum = trialNum;
        preP = new double[trialNum];
        for(int i=0;i<trialNum;i++) {
            Percolation p = new Percolation(n);
            while(!p.percolates()) {
                int row = StdRandom.uniform(n)+1;
                int col = StdRandom.uniform(n)+1;
                p.open(row,col);
                if (p.percolates()) break;
            }
            preP[i] = (double)p.numberOfOpenSites()/(n*n);
        }
    }

    // 均值
    public double mean() {
        return StdStats.mean(preP);
    }

    // 标准差
    public double stddev() {
        return StdStats.stddev(preP);
    }

    //置信区间
    public double confidenceLo() {
        return mean()-1.96*stddev()/Math.sqrt(trialNum);
    }
    public double confidenceHi() {
        return mean()+1.96*stddev()/Math.sqrt(trialNum);
    }

    public static void main(String[] args) {
        int n =80,trialNum=1000;
        Main ps = new Main(n,trialNum);
        StdOut.println("方格尺寸 :" + n+"*"+n);
        StdOut.println("实验次数 :" + trialNum);
        StdOut.println("平均值为 :"+ ps.mean());
        StdOut.println("标准差为 :"+ps.stddev());
        StdOut.println("置信区间为 :["+ps.confidenceLo() +"，" + ps.confidenceHi() + "]");
    }


}
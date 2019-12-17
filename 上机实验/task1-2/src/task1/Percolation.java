package task1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n ;
    //格子状态
    private boolean[] eachStatus ;

    private int openNum;

    private WeightedQuickUnionUF uf;

    public Percolation(int n){
        if(n<=0) throw new IllegalArgumentException("illegal value of n!");
        this.n = n;
        eachStatus = new boolean[(n+1)*(n+2)];

        for(int i=0; i< eachStatus.length;i++) {
            eachStatus[i]=false;
        }
        uf = new WeightedQuickUnionUF((n+1)*(n+2));

    }

    //二维->一维
    private int oneDimention(int row, int col){
        return row*(n+1)+col;
    }

    public void open(int row, int col){
        if(row<1 || row>n || col<1 || col>n) throw new IllegalArgumentException("illegal row or col!");
        if(!isOpen(row,col)) {
            eachStatus[oneDimention(row,col)]=true;
            openNum++;
            int temp1 = oneDimention(row,col);
            if(row==1){
                uf.union(0,temp1);
            }
            if(row==n) {
                uf.union((n+1)*(n+1),temp1);
            }
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for(int i=0; i<4;i++){
                int tempX = row+dx[i];
                int tempY = col+dy[i];
                int temp2 = oneDimention(tempX,tempY);
                if (eachStatus[temp2]){
                    uf.union(temp1,temp2);
                }
            }
        }
    }

    public boolean isOpen(int row, int col){
        if(row<1 || row>n || col<1 || col>n) throw new IllegalArgumentException("illegal row or col!");
        return eachStatus[oneDimention(row,col)];
    }



    public int numberOfOpenSites() {
        return openNum;
    }

    public boolean percolates() {
        return uf.connected(0,(n+1)*(n+1));
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(1, 2);
        p.open(2, 2);
        p.open(3, 2);
        StdOut.println(p.isOpen(1,1));
        StdOut.println(p.percolates());
    }

}
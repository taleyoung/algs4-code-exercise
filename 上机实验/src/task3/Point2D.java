package task3;

class Point2D {
    private  double x;
    private  double y;
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Point2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
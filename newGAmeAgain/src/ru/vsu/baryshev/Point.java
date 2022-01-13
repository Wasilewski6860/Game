package ru.vsu.baryshev;
 class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }
    public int returnX(Point point){
        return point.x;
    }
    public int returnY(Point point){
        return point.y;
    }


}

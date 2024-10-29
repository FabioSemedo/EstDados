package Prac3;

public class Rectangle {
    Point a, b;
    /*
     * |--------b
     * |--------|
     * a--------|
     * 
     * b.x > a.x
     * b.y > a.y
     */

    public Rectangle(int x1, int y1, int x2, int y2){
        a = new Point(x1,y1);
        b = new Point(x2,y2);
    }

    public Rectangle(Point p1, Point p2){
        a = p1;
        b = p2;
    }

    public int area(){
        return  Math.abs((b.x-a.x)*(b.y-a.y));
    }

    public int perimeter(){
        return Math.abs(b.x-a.x)*2 + Math.abs(b.y-a.y)*2;
    }

    public boolean pointInside(Point p){
        boolean flag = true;

        flag = flag && (a.x <= p.x) && (p.x <= b.x);
        flag = flag && (a.y <= p.y) && (p.y <= b.y);
        
        return (flag);
    }

    public boolean rectangleInside(Rectangle r){
        boolean flag = true;
        
        flag = pointInside(r.a) && pointInside(r.b);
        
        return flag;
    }
}

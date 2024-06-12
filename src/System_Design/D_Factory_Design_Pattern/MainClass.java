package System_Design.D_Factory_Design_Pattern;

import System_Design.D_Factory_Design_Pattern.Normal_Factory_Design.Shape;
import System_Design.D_Factory_Design_Pattern.Normal_Factory_Design.ShapeFactory;

public class MainClass {

    public static void main(String[] args) {

        ShapeFactory shapeFactoryobj = new ShapeFactory();
        Shape s1 = shapeFactoryobj.getShape("RECTANGLE");
        Shape s2 = shapeFactoryobj.getShape("SQUARE");
        Shape s3 = shapeFactoryobj.getShape("CIRCLE");
        Shape s4 = shapeFactoryobj.getShape("R");  // will give Null-pointer to You.
        s1.draw();
        s2.draw();
        s3.draw();

    }
}

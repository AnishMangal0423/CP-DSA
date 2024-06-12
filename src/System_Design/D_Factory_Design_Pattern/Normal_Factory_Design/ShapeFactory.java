package System_Design.D_Factory_Design_Pattern.Normal_Factory_Design;

public class ShapeFactory {

    public Shape getShape(String input){

        switch (input){

            case "CIRCLE":
                return new Circle();

            case "RECTANGLE":
                return new Rectangle();

            case "SQUARE":
                return new Sqaure();

            default:
                return null;
        }
    }
}

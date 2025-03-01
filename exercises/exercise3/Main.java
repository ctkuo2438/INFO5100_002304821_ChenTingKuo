package exercise3;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Circle c = new Circle(5);
            Triangle t = new Triangle(6, 4, 5, 5);
            Rectangle r = new Rectangle(6, 8);
            Square s = new Square(6);

            // Serialize the objects to a file
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.writeObject(t);
            out.writeObject(r);
            out.writeObject(s);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in shapes.ser");

            // Deserialize the objects from the file
            FileInputStream fileIn = new FileInputStream("shapes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Circle deserializedC = (Circle) in.readObject();
            Triangle deserializedT = (Triangle) in.readObject();
            Rectangle deserializedR = (Rectangle) in.readObject();
            Square deserializedS = (Square) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("\nDeserialized Circle:");
            System.out.println("Shape Name: " + deserializedC.name);
            System.out.println("Area: " + deserializedC.calculateArea());
            System.out.println("Perimeter: " + deserializedC.calculatePerimeter());
            deserializedC.displayColor();

            System.out.println("\nDeserialized Triangle:");
            System.out.println("Shape Name: " + deserializedT.name);
            System.out.println("Area: " + deserializedT.calculateArea());
            System.out.println("Perimeter: " + deserializedT.calculatePerimeter());
            deserializedT.displayColor();

            System.out.println("\nDeserialized Rectangle:");
            System.out.println("Shape Name: " + deserializedR.name);
            System.out.println("Area: " + deserializedR.calculateArea());
            System.out.println("Perimeter: " + deserializedR.calculatePerimeter());
            deserializedR.displayColor();

            System.out.println("\nDeserialized Square:");
            System.out.println("Shape Name: " + deserializedS.name);
            System.out.println("Area: " + deserializedS.calculateArea());
            System.out.println("Perimeter: " + deserializedS.calculatePerimeter());
            deserializedS.displayColor();

        } catch (IOException e) {
            System.err.println("Error accessing file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}


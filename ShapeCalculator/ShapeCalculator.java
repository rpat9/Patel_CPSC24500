package ShapeCalculator;

import java.util.Scanner;

/**
 * This program is designed to calculate the area of 3 simple shapes: rectangle, circle, and triangle.
 */

 public class ShapeCalculator{

    /**
     * Prints the customized welcome banner right when the program begins.
     */
    public void WelcomeBanner(){
        System.out.println("*".repeat(65));
        System.out.printf("%41s", "SHAPE CALCULATOR\n");
        System.out.println("*".repeat(65));
        System.out.println();
    }

    /**
     * The function calculates the circumference and area of the circle based on the given radius.
     * @param radius The radius of the circle.
     */
    public void calculateCircle(double radius){
        double circumference = Math.PI*2*radius;
        double area = Math.PI*radius*radius;

        System.out.printf("The area of the circle is %.2f, and the circumference is %.2f.\n", area, circumference);
    }

    /**
     * The function calculates the area and the perimeter of the rectangle based on given length and width.
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     */
    public void calculateRectangle(double length, double width){
        double area = length*width;
        double perimeter = 2*(length+width);

        System.out.printf("The area of the rectangle is %.2f, and the perimeter is %.2f.\n", area, perimeter);
    }

    /**
     * This function calculates the area and the perimeter of the triangle based on the given side1, side2, and side3.
     * @param side1 First side of the triangle
     * @param side2 Second side of the triangle
     * @param side3 Third side of the triangle
     */
    public void calculateTriangle(double side1, double side2, double side3){
        double area = (side1*side2)/2;
        double perimeter = side1+side2+side3;

        System.out.printf("The area of the triangle is %.2f, and the perimeter is %.2f.\n", area, perimeter);
    }
    public static void main(String[] args) {

        ShapeCalculator shape = new ShapeCalculator();
        Scanner scan = new Scanner(System.in);
        shape.WelcomeBanner();
        String choice;

        while(true){
            System.out.print("Enter C for circle, R for rectangle, or T for triangle: ");
            choice = scan.next();

            //Accounting for 'Q'
            if(choice.equalsIgnoreCase("q")){
                System.out.println("Thank you for using Shape Calcualtor!");
                break;

            } else if(choice.equalsIgnoreCase("c")){

                System.out.print("Enter Radius: ");
                double radius  = scan.nextDouble();
                shape.calculateCircle(radius);

            } else if(choice.equalsIgnoreCase("r")){

                System.out.print("Enter the length and width: ");
                double length  = scan.nextDouble();
                double width = scan.nextDouble();
                shape.calculateRectangle(length, width);

            } else if (choice.equalsIgnoreCase("t")){

                System.out.print("Enter the lengths of the 3 sides: ");
                double a = scan.nextDouble();
                double b = scan.nextDouble();
                double c = scan.nextDouble();
                shape.calculateTriangle(a, b, c);

            } else {
                System.out.print("This is not a recognized shape.\n");
            }
        }

        scan.close();
    }
 }
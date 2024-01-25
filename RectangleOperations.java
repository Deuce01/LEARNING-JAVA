import java.util.Scanner;

public class RectangleOperations{
    public static void main (String[] args){
	 Scanner scanner = new Scanner(System.in);
	 
	 System.out.println(" enter the width: ");
	 double width = scanner.nextDouble();
	 
	  System.out.println(" enter the length: ");
	 double length = scanner.nextDouble();
	 
	 
	 double area = width*length;
	 double perimeter = 2*(width+length);
	 
	 System.out.println("Area:"+area);
	 System.out.println("perimeter:"+perimeter);
	 
	 scanner.close();
	}
}

	 
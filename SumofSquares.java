public class SumofSquares {
 public static void main(String[] args){
     int num = 1 ;
     int sum = 0 ;

    while (num <= 15) {
      sum += num*num;
      num++;
    }
     System.out.println("sum is" +sum);
    }
}
/*   Name: Darelle Gochuico
   Schedule : 3:00-5:30 M-W

   Create a two(s) sets of a (3x3) two dimensional array representing a matrix,
   compute the sum of the two(2) matrix and display as a result matrix

   Example:

   matrixA, matrixB content should be inputted(input values must be from 0-9 only)

   matrix A          matrix B

   1   2   3        1   2   3
   4   5   6        4   5   6
   7   8   9        7   8   9

   result matrix < output
    2   4   6
    8  10  12
   14  16  18
*/

public class MyArray{
    private int i, j;
    final private int row = 3, col = 3;
    private int matrix[][] = new int[row][col], result[][] = new int[row][col];
    final String int_error = "Only accepts integers less than ten and non-negative inputs", alpha_error = "Alphanumeric inputs are disallowed";

    // constructor
    public MyArray(){}

    public void setMatrix(){
        for(i = 0; i < row; i++){
            for(j = 0; j < col;){
                try{
                    System.out.print("row " + i + " col " + j + ": "); matrix[i][j] = new java.util.Scanner(System.in).nextInt();
                    if (matrix[i][j] > 9 || matrix[i][j] < 0){ System.out.println(int_error); } else { j++; }
                }catch(Exception e){ System.out.println(alpha_error); } 
            }
        }
    }

    public int getMatrixValues(int i, int j){
        return matrix[i][j];
    }

    public void getMatrix(){
        for(i = 0; i < row; i++){
            for(j = 0; j < col; j++){
                System.out.print(matrix[i][j] + "\t");
            }
                System.out.print("\n\n");
        }
    }
}// end of class

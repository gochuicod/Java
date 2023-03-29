public class Main{
    public static void main(String[] args){
        char set_values, operate;
        do{
            System.out.print("\n--Set Matrix A--\n");
            matrixA.setMatrix();
            System.out.print("\n--Set Matrix B--\n");
            matrixB.setMatrix();
            System.out.print("\n--Matrix A--\n");
            matrixA.getMatrix();
            System.out.print("\n--Matrix B--\n");
            matrixB.getMatrix();
                do{
                    System.out.print("\nEnter operation(+/-*): ");
                    char operator = new java.util.Scanner(System.in).next().charAt(0);
                    System.out.print("\n\n--Matrix A and B Output--\n");
                    getOutput(operator);
                    System.out.print("Operate again? ");
                    operate = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
                }while(operate == 'y');
            System.out.print("\nReset values? ");
            set_values = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
        }while(set_values == 'y');
    }//end of main

    public static MyArray matrixA = new MyArray();
    public static MyArray matrixB = new MyArray();

    public static void getOutput(char operator){
        //addition
        int result[][] = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                switch(operator){
                    case '+':
                        result[i][j] = matrixA.getMatrixValues(i,j) + matrixB.getMatrixValues(i,j);
                        break;
                    case '-':
                        result[i][j] = matrixA.getMatrixValues(i,j) - matrixB.getMatrixValues(i,j);
                        break;
                    case '*':
                        result[i][j] = matrixA.getMatrixValues(i,j) * matrixB.getMatrixValues(i,j);
                        break;
                    case '/':
                        result[i][j] = matrixA.getMatrixValues(i,j) / matrixB.getMatrixValues(i,j);
                        break;
                    default:
                        break;
                }
                System.out.print(result[i][j] + "\t");
            }
                System.out.print("\n\n");
        }
    }
}// end of class

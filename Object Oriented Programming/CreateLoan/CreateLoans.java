/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    Finals Programming Exercise 1
*/

public class CreateLoans{
    public static void main(String[] args){
        char option;
        do{
            System.out.print("\nLoan Type(B for business, P for personal, V to view, Q to quit): ");
            option = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
            switch(option){
                case 'b':
                    setBusinessLoan();
                    break;
                case 'p':
                    setPersonalLoan();
                    break;
                case 'v':
                    displayOptions();
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("\nInvalid Type!");
            }
        }while(option != 'q');
    }//end of main

    public static BusinessLoan[] BLoan = new BusinessLoan[5];
    public static PersonalLoan[] PLoan = new PersonalLoan[5];
    public static int BLoanCount, PLoanCount;

    public static void setBusinessLoan(){
        System.out.print("Enter current prime interest rate: ");
        double interest_rate = new java.util.Scanner(System.in).nextDouble();
        System.out.print("Enter loan number(eg. 111-111-222): ");
        String loan_number = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter last name: ");
        String customer_lastname = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter term(in years): ");
        int term = new java.util.Scanner(System.in).nextInt();
        int loan_amount;
        do{
            System.out.print("Enter loan amount(100000 max): ");
            loan_amount = new java.util.Scanner(System.in).nextInt();
        }while(loan_amount > 100000);
        BLoan[BLoanCount] = new BusinessLoan(loan_number, customer_lastname, term, loan_amount);
        BLoan[BLoanCount].setPrimeInterestRate(interest_rate);
        BLoanCount++;
    }

    public static void setPersonalLoan(){
        System.out.print("Enter current prime interest rate: ");
        double interest_rate = new java.util.Scanner(System.in).nextDouble();
        System.out.print("Enter loan number(eg. 111-111-222): ");
        String loan_number = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter last name: ");
        String customer_lastname = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter term(in years): ");
        int term = new java.util.Scanner(System.in).nextInt();
        int loan_amount;
        do{
            System.out.print("Enter loan amount(100000 max): ");
            loan_amount = new java.util.Scanner(System.in).nextInt();
        }while(loan_amount > 100000);
        PLoan[PLoanCount] = new PersonalLoan(loan_number, customer_lastname, term, loan_amount);
        PLoan[PLoanCount].setPrimeInterestRate(interest_rate);
        PLoanCount++;
    }

    public static void displayOptions(){
        char option;
        System.out.print("View Loan(B for Business, P for Personal): ");
        option = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
        switch(option){
            case 'b':
                displayBusinessLoans();
                break;
            case 'p':
                displayPersonalLoans();
                break;
            default:
                System.out.println("\nInvalid View Type!");
        }
    }

    public static void displayBusinessLoans(){
        System.out.println("\n" + PLoan[0].company_name);
        for(int i = 0; i < BLoanCount; i++){
            System.out.println("\nBusiness Loan #" + (i+1) + "\nCurrent prime interest rate: " + BLoan[i].getPrimeInterestRate() + "%" + "\n" + BLoan[i] + "\nTotal amount owed: " + BLoan[i].totalAmountOwed());
        }
    }

    public static void displayPersonalLoans(){
        System.out.println("\n" + PLoan[0].company_name);
        for(int i = 0; i < PLoanCount; i++){
            System.out.println("\nPersonal Loan #" + (i+1) + "\nCurrent prime interest rate: " + PLoan[i].getPrimeInterestRate() + "%" + "\n" + PLoan[i] + "\nTotal amount owed: " + PLoan[i].totalAmountOwed());
        }
    }
}//end of class

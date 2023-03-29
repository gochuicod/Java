/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    Finals Programming Exercise 1
*/

public class BusinessLoan extends Loan{
    //constructors
    public BusinessLoan(String loan_number, String customer_lastname, int term, int loan_amount){
        super(loan_number, customer_lastname, term, loan_amount);
        super.setInterestRate(0.01);
    }
    public BusinessLoan(){}

    //allowable operations
    public double totalAmountOwed(){
        double output = super.getLoanAmount() + (super.getLoanAmount() * super.getInterestRate() * super.getTerm());
        return output;
    }
}//end of class 

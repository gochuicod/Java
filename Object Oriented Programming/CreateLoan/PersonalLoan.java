/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    Finals Programming Exercise 1
*/

public class PersonalLoan extends Loan{
    //constructors
    public PersonalLoan(String loan_number, String customer_lastname, int term, int loan_amount){
        super(loan_number, customer_lastname, term, loan_amount);
        super.setInterestRate(0.02);
    }
    public PersonalLoan(){}

    public double totalAmountOwed(){
        double output = super.getLoanAmount() + (super.getLoanAmount() * super.getInterestRate() * super.getTerm());
        return output;
    }
}//end of class

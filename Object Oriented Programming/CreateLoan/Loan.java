/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    Finals Programming Exercise 1
*/

public abstract class Loan implements LoanConstants{
    //attributes
    private String loan_number, customer_lastname;
    private double interest_rate, prime_interest_rate;
    private int term, loan_amount;

    //constructors
    public Loan(String loan_number, String customer_lastname, int term, int loan_amount){
        this.loan_number = loan_number; this.customer_lastname = customer_lastname;
        if((term == short_term) || (term == medium_term) || (term == long_term)) this.term = term;
        else this.term = short_term;
        this.loan_amount = loan_amount;
    }
    public Loan(){}

    //setters
    public void setLoanNumber(String loan_number){ this.loan_number = loan_number; }
    public void setCustomerLastName(String customer_lastname){ this.customer_lastname = customer_lastname; }
    public void setInterestRate(double interest_rate){ this.interest_rate = interest_rate; }
    public void setPrimeInterestRate(double prime_interest_rate){ this.prime_interest_rate = prime_interest_rate; }
    public void setTerm(int term){ this.term = term; }
    public void setLoanAmount(int loan_amount){ this.loan_amount = loan_amount; }

    //getters
    public String getLoanNumber(){ return loan_number; }
    public String getCustomerLastName(){ return customer_lastname; }
    public double getInterestRate(){ return interest_rate; }
    public double getPrimeInterestRate(){ return prime_interest_rate; }
    public int getTerm(){ return term; }
    public int getLoanAmount(){ return loan_amount; }
    
    //override toString()
    public String toString(){
        StringBuffer sb = new StringBuffer();
        String newline = System.lineSeparator();
            sb.append("Loan Number: " + getLoanNumber() + newline + "Customer Name: " + getCustomerLastName() + newline + "Term(s): " + getTerm() + " year(s)" + newline + "Amount loaned: " + getLoanAmount());
        return sb.toString();
    }
}//end of class

/**
Name: Darelle Gochuico
Schedule: 4:30 PM - 7:30 PM, Monday and Wednesday

A bank in your town updates its customers’ accounts at the end of each  month. The  bank offers two types of accounts: savings and checking. 
Every customer must maintain a minimum balance. If a customer’s balance falls below the minimum balance, there is a service charge of $10.00 
for savings accounts and $25.00 for checking accounts. If the balance at the end of the month is at least the minimum balance, the account 
receives interest as follows:

a. Savings account receive 4% interest
b. Checking accounts with balances of up to $5000 more than the minimum balance receive 3% interest, otherwise, the interest is 5%.

Write a program that reads a customer’s account number (int type) account type (char type; s or S for savings, c or C for checking), minimum 
balance that the account should maintain and current balance. The program should then output the account number, account type, current balance, 
and new balance or an appropriate error message.
*/

import java.util.Scanner; import java.util.regex.*;

public class CustomerBalance{
    public static double savings_new_balance = 0, checking_new_balance, savings_service_charge = 10, checking_service_charge = 25, current_balance; 
    public static final int min_balance = 110; public static int account_number; public static char account_type, withdraw_deposit; 
    public static String savings_info = "\n~Savings Account~\n\nBenefits:\n- 4% interest with balances greater than the minimum\n\nOfficial Receipt\n",
    savings_receipt = "\nMinimum Balance to maintain: $" + min_balance + "\nYour Balance: $", 
    checking_info = "\n~Checking Account~\n\nBenefits:\n- 3% interest with balances of up to $5000 more than minimum" + 
    "\n- 5% interest with balances of not up to $5000 more than minimum\n\nOfficial Receipt\n",
    checking_receipt = "\nMinimum Balance to maintain: $" + min_balance + "\nYour Balance: $",
    savings_deduction_prompt = "\n\nCharged $10 for service fee from account. Did not meet minimum required Balance.",
    checking_deduction_prompt = "\n\nCharged $25 for service fee from account. Did not meet minimum required Balance.",new_session = "\n\nStart a new session? (y/n): ";

    public static void main(String... args) {
        char session;
        do{
            welcomeMessage(); getAccount(); accountType(); withdrawOrDeposit(); amount(); negative(); futureSession(); savingsProcess(); exitMessage();
            newSession(); session = new java.util.Scanner(System.in).next().charAt(0);
        }while(session == 'y');

    }

    public static void welcomeMessage(){
        System.out.print("\n-- Welcome to FBank eFficient Banking! --\n\n");
    }

    public static int getAccount(){
        System.out.print("Account Number: "); account_number = new java.util.Scanner(System.in).nextInt();
        return account_number;
    }

    public static char accountType(){
        System.out.print("Account Type (s for savings, c for checking): "); account_type = new java.util.Scanner(System.in).next().charAt(0);
        return account_type;
    }

    public static char withdrawOrDeposit(){
        System.out.print("Withdraw or Deposit? (w/d): "); withdraw_deposit = new java.util.Scanner(System.in).next().charAt(0);
        return withdraw_deposit;
    }
    
    public static double amount(){
        System.out.print("Amount to withdraw or deposit(in USD): "); current_balance = new java.util.Scanner(System.in).nextDouble();
        return current_balance;
    }

    public static double negative(){
        if (withdraw_deposit == 'w'){ current_balance = -(current_balance); } return current_balance;
    }

    public static double futureSession(){
        if (account_type == 's'){ current_balance += savings_new_balance; } else { current_balance += checking_new_balance; } return current_balance;
    }

    public static double savingsProcess(){
        if (account_type == 's'){ 
            System.out.print(savings_info +  "\nAccount Number: " + account_number + "\nAccount Type: Savings" + savings_receipt + current_balance);
            if (current_balance >= min_balance) { 
                savings_new_balance = (current_balance + (current_balance * 0.04)); System.out.printf("\nNew Balance: $%.2f",savings_new_balance);
            } else { 
                savings_new_balance = current_balance - savings_service_charge;
                System.out.printf("\nNew Balance: $%.2f", savings_new_balance); System.out.print(savings_deduction_prompt);
            }
        } else if (account_type == 'c'){
            System.out.print(checking_info + "\nAccount Number: " + account_number + "\nAccount Type: Checking" + checking_receipt + current_balance);
            if (current_balance < min_balance){
                checking_new_balance = current_balance - checking_service_charge; 
                System.out.printf("\nNew Balance: $%.2f",checking_new_balance); 
                System.out.print(checking_deduction_prompt);
            } else if (current_balance <= (min_balance + 5000)){
                checking_new_balance = current_balance + (current_balance * 0.05);
                System.out.printf("\nNew Balance: $%.2f",checking_new_balance);
            } else if (current_balance >= (min_balance + 5000)){
                checking_new_balance = current_balance + (current_balance * 0.03);
                System.out.printf("\nNew Balance: $%.2f",checking_new_balance);
            }
        }
                return checking_new_balance;
    }

    public static void exitMessage(){
        System.out.print("\n\n-- Program end --\n");
    }

    public static void newSession(){
        System.out.print(new_session);
    }
}

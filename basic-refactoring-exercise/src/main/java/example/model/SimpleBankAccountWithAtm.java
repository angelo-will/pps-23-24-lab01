package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{

    private double transactionFee;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, double transactionFee) {
        super(holder, balance);
        this.transactionFee = transactionFee;
    }

    @Override
    public void depositWithAtm(int id, double depositAmount) {
        this.deposit(id, depositAmount - this.transactionFee);
    }

    @Override
    public void withdrawWithAtm(int id, double withdrawAmount) {
        this.withdraw(id, withdrawAmount + this.transactionFee);    
    }



    public double getFee(){
        return this.transactionFee;
    }
    
}

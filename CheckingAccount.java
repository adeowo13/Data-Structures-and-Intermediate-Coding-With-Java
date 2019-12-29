public class CheckingAccount
{
  private double balance;

  public CheckingAccount(double initialBalance)
  {
    balance = initialBalance;
  }

  public double getBalance()
  {
    return balance;
  }

  public void deposit(double amount)
  {
    balance += amount;
  }

  public boolean withdraw(double amount)
  {
    // perform the withdrawal if there's enough money to take out
    // return true to signal success
    if (amount <= balance)
    {
      balance -= amount;
      return true;
    }

    // if we can't perform the withdrawal, return false to signal failure
    return false;
  }

}
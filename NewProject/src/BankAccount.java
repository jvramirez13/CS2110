import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
public class BankAccount {
	private double balance;
	private Lock balanceChangeLock;
	private Condition sufficientFundsCondition;
	
	public BankAccount() {
		balance = 0;
		this.balanceChangeLock  = newReentrantLock();
		this.sufficientFundsCondition = this.balanceChangeLock.newCondition();
	}

	public void deposit(double amount) {
		this.balanceChangeLock.lock();
		try {
			System.out.print("Depositing " + amount);
			double newBalance = balance + amount;
			System.out.println(", new balance is " + newBalance);
			balance = newBalance;
			this.suffiicentFUndsCondition.signalAll();
		} finally {
			this.balanceChangeLock.unlock();
		}
	}

	public void withdraw(double amount) throws InterruptedException {
			this.balanceChangeLock.lock();
			try {
				while(balance < amount) {
					this.sufficientFundsCondition.await();
				}
				System.out.print("Withdrawing " + amount);
				double newBalance = balance - amount;
				System.out.println(", new balance is " + newBalance);
				balance = newBalance;
			} finally {
				this.balanceChangeLock.unlock();
			}
			 
	}

	public double getBalance() {
		return balance;
	}
}

//Defines a credit card
//NEEDS MODIFICATION

public class CreditCard
{
	private Money balance;		//the current balance
	private Money creditLimit;	//the approved credit limit
	private Person owner;		//the owner of the credit card

	//Constructor creates a credit card for the Person parameter
	//with an approved credit limit of the Money parameter
	//and sets the balance to a Money amount of zero 
	public CreditCard(Person newCardholder, Money limit) 
	{
		this.owner = newCardholder;
		this.creditLimit = limit;
		balance.setCents(0);
		balance.setDollars(0);
	}

	//Accessor method returns the balance
	public Money getBalance()
	{
		return this.balance;
	}

	//Accessor method returns the credit limit
	public Money getCreditLimit()
	{
		return this.creditLimit;
	}

	//Accessor method returns information about the owner
	public String getPersonals()
	{
		return this.owner.toString();
	}
	
	//Method to make a charge to the credit card (but only if
	//the credit limit will not be exceeded)
	public void charge(Money amount)
	{
		if (amount.add(this.balance).compareTo(this.creditLimit) < 0) {
			System.out.println("Errror: Exceeds credit limit!");
		} else {
			amount.add(this.balance);
		}
	}

	//Method to make a payment to the credit card
	public void payment(Money amount)
	{
		amount.subtract(this.balance);
	}		
}
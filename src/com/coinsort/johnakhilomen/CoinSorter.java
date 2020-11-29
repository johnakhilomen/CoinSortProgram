package com.coinsort.johnakhilomen;

import java.util.ArrayList;
import java.util.Arrays;


public class CoinSorter {
	//Lets declare field variables for currency, minimum coin input value, maximum coin input value and coin list
	private String _currency;
	private int _minCoinIn;
	private int _maxCoinIn;
	private ArrayList<String> _coinList;
	public ArrayList<Integer> createMultiCoinList = new ArrayList<Integer>();
	
	//A constructor to initialize currency, minimum coin input value, maximum coin input value and coin list
	public CoinSorter(String currency, int minCoinIn, int maxCoinIn, ArrayList<String> coinList)
	{
		_currency = currency;
		_minCoinIn = minCoinIn;
		_maxCoinIn = maxCoinIn;
		_coinList = coinList;
	}
	//An empty constructor in case I need to instantiate this class without initializations
	public CoinSorter()	{ }
	
	//setters
	public void setCurrency(String currency) 
	{
		_currency = currency;
	}
	public void setMinCoinIn(int minCoinIn) 
	{
		_minCoinIn = minCoinIn;
	}
	public void setMaxCoinIn(int maxCoinIn) 
	{
		_maxCoinIn = maxCoinIn;
	}
	public void setCoinList(ArrayList<String> coinList) 
	{
		_coinList = coinList;
	}	
	//getters
	public String getCurrency() 
	{
		return _currency;
	}
	public int getMinCoinIn() 
	{
		return _minCoinIn;
	}
	public int getMaxCoinIn() 
	{
		return _maxCoinIn;
	}
	public ArrayList<String> getCoinList()
	{
		return _coinList;
	}
	
	//Convert any value from pound sterling to pennies by multiplying 100 to it
	public int ConvertFromPoundToPenny(int pound)
	{
		return pound * 100;
	}
	
	//Returns a concatenated string including the coin list in circulation
	public String printCoinList()
	{
		return "The current coin denominations are in circulation: "+String.join(", ", _coinList);
	}
	
	/*Algorithm for for coin Calculator
	 * User can make exchange from pound sterling to any coin type in circulation
	 * User can make exchange from a pennies to  to any coin type in circulation
	 */
	public String coinCalculator(int totalValue, int coinType) 
	{
		//First check if the current currency is set to pound sterling
		if(getCurrency()=="£")
		{
			//then override the value in totalValue by converting it to pennies
			totalValue = ConvertFromPoundToPenny(totalValue);
			//and set the currency to penny
			setCurrency("P");	
		}
		//Lets get the number of coins by dividing the coinType from total value and store in variable numberOfCoins
		int numberOfCoins = (int) Math.floor(totalValue / coinType);
		//Lets get the remainder coins by dividing the coinType from total value and store in variable numberOfCoinsRemainder
		int numberOfCoinsRemainder = totalValue % coinType;
		/* No we do a check if the user is making exchange to Pound sterling. There are only £2 and £1 (pound sterling) 
		*among other coins in circulation. We check if it's one of them 
		*/
		if (getCurrency()=="P" && (coinType == 2 || coinType == 1))
		{
			/*then override the value in numberOfCoins by converting it to pound sterling. We multiply 100 to coin type
			 * and divide the result from total value
			 */
			numberOfCoins = (int) Math.floor(totalValue / (coinType*100));
			//and override the remainder coins as well
			numberOfCoinsRemainder = totalValue % (coinType*100);
			//and set the currency to pound sterling
			setCurrency("£");		
		}
		//format a string for the method to return as result
		String msg = "A total of "+numberOfCoins +" x " +coinType+ getCurrency()+" coins can be exchanged";
		//Returns message result if no remainder. Returns the message concatenated with remainder value if there is.
		return numberOfCoinsRemainder == 0 ? msg : msg+", with a remainder of P"+numberOfCoinsRemainder;
	}
	
	public String multiCoinCalculator(int totalValue, int coinTypeToExclude) 
	{
		//Lets declare counters for P200, P100, P50, P30, P20, P10
		int p200 = 0;
		int p100 = 0;
		int p50 = 0;
		int p30 = 0;
		int p20 = 0;
		int p10 = 0;
		
		//Declare a new list 
		ArrayList<Integer> newList = new ArrayList<Integer>();
		//Lets remove the label "P" from the coin types and convert from string to integer
		for (int i = 0; i < _coinList.size(); i++)
		{
			//conversion is done here after remove the first character in the string which is "P"
			int coinT = Integer.parseInt(_coinList.get(i).substring(1));
			//add the converted value to the declared new list
			newList.add(coinT);
		}
		//Lets iterate the new list to remove the coin type to exclude from the list 
		for (int i = 0; i < newList.size(); i++)
		{
			//removal of coin type to exclude is done here
			if(newList.get(i) == coinTypeToExclude)
			{
				newList.remove(i);
				break;
			}
			else
			{
				continue;
			}
		}
		//First check if the current currency is set to pound sterling
		if(getCurrency()=="£")
		{
			//then override the value in totalValue by converting it to pennies
			totalValue = ConvertFromPoundToPenny(totalValue);
			//and set the currency to penny
			setCurrency("P");	
		}
		
		//Lets process the multiple coin calculator
		processMultiCoinList(totalValue, newList);
		//Lets store the processed multiple coins
		var processedMultiCoinList = createMultiCoinList;
		//Lets count each coin types in the processed multiple coins
		for (int i = 0; i < processedMultiCoinList.size(); i++)
		{
			if(processedMultiCoinList.get(i)==200)
		      {
		        p200++;
		      }
		      else if(processedMultiCoinList.get(i)==100)
		      {
		        p100++;
		      }
		      else if(processedMultiCoinList.get(i)==50)
		      {
		        p50++;
		      }
		      else if(processedMultiCoinList.get(i)==30)
		      {
		        p30++;
		      }
		      else if(processedMultiCoinList.get(i)==20)
		      {
		        p20++;
		      }
		      else if(processedMultiCoinList.get(i)==10)
		      {
		        p10++;
		      }
		}
		//format a string for the method to return as result
		String msg = "The coins exchanged are: "+p200+" x 200 "+getCurrency()+" ( or "+p200+" x 2£) , "+p100+" x 100"+getCurrency()+
				" ( or "+p100+" x 1£) , "+p50+" x 50"+getCurrency()+", "+p30+" x 30"+getCurrency()+", "
				+p20+" x 20"+getCurrency()+", "+p10+" x 10"+getCurrency();
		//Returns the message if no remainder. Returns the message concatenated with remainder value if there is.
		return remainderValue == 0 ? msg : msg+", with a remainder of P"+remainderValue;
		
	}
	//declare a field variable for remainder value when calculating multiple coins
	private int remainderValue = 0;
	/*Algorithm for calculating multiple coins
	 * This algorithm is recursive
	 * It recursively subtract vales in the coin list from the total value until the list size is 0
	 */
	public ArrayList<Integer> processMultiCoinList(int totalValue, ArrayList<Integer> arr)
	{
		//A base to check when the total value or list size is 0. If the total value or list size is 0
		//then we return the result array
		if(totalValue == 0 || arr.size() == 0) 
		{
		   return arr;
		}
		else 
		{
		//if totalValue is greater than or equal to the first item in the list
		  if(totalValue >= arr.get(0)) 
		  {
		  //we subtract that value from the list and store the result in t
		  int t = totalValue - arr.get(0);
		  // Collect the subtracted value from the list and store in the createMultiCoinList list
		  createMultiCoinList.add(arr.get(0));
		  //return the recursive method with the remainder value after subtraction
		  return processMultiCoinList(t,arr);
		  }		  
		 else 
		  {
		  //if the total value is less than the last value in the coin list which is 10, the rest is the remainder
		  if(totalValue < 10) 
		  {
			//store the remainder value here as remainder coin
			remainderValue = totalValue;
			return arr;
		  }
		  //Now let's remove the subtracted coin from the coin list
		  arr.remove(0);
		  //and return the coin list 
		  return processMultiCoinList(totalValue,arr);
		} 
	
		}
		
	}

}

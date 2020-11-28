package com.coinsort.johnakhilomen;

import java.util.ArrayList;
import java.util.Arrays;


public class CoinSorter {
	
	private String _currency;
	private int _minCoinIn;
	private int _maxCoinIn;
	private ArrayList<String> _coinList;
	public ArrayList<Integer> createMultiCoinList = new ArrayList<Integer>();
	
	public CoinSorter(String currency, int minCoinIn, int maxCoinIn, ArrayList<String> coinList)
	{
		_currency = currency;
		_minCoinIn = minCoinIn;
		_maxCoinIn = maxCoinIn;
		_coinList = coinList;
	}
	
	public CoinSorter()
	{
		
	}
	
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
		
	public int ConvertFromPoundToPenny(int pound)
	{
		return pound * 100;
	}
		
	public String printCoinList()
	{
		return "The current coin denominations are in circulation: "+String.join(", ", _coinList);
	}
	
	public String coinCalculator(int totalValue, int coinType) 
	{
		if(getCurrency()=="£")
		{
			totalValue = ConvertFromPoundToPenny(totalValue);
			setCurrency("P");	
		}
		int numberOfCoins = (int) Math.floor(totalValue / coinType);
		int numberOfCoinsRemainder = totalValue % coinType;
		if (getCurrency()=="P" && (coinType == 2 || coinType == 1))
		{
			numberOfCoins = (int) Math.floor(totalValue / (coinType*100));
			numberOfCoinsRemainder = totalValue % (coinType*100);
			setCurrency("£");		
		}
		String msg = "A total of "+numberOfCoins +" x " +coinType+ getCurrency()+" coins can be exchanged";
		return numberOfCoinsRemainder == 0 ? msg : msg+", with a remainder of "+numberOfCoinsRemainder+"P";
	}
	
	public String multiCoinCalculator(int totalValue, int coinTypeToExclude) 
	{
		int p200 = 0;
		int p100 = 0;
		int p50 = 0;
		int p30 = 0;
		int p20 = 0;
		int p10 = 0;
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < _coinList.size(); i++)
		{
			int coinT = Integer.parseInt(_coinList.get(i).substring(1));
			newList.add(coinT);
		}
		
		for (int i = 0; i < newList.size(); i++)
		{
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
		if(getCurrency()=="£")
		{
			totalValue = ConvertFromPoundToPenny(totalValue);
			setCurrency("P");	
		}
		
		
		processMultiCoinList(totalValue, newList);
		var yy = createMultiCoinList;
		for (int i = 0; i < yy.size(); i++)
		{
			System.out.println(i);
		}
		for (int i = 0; i < yy.size(); i++)
		{
			if(yy.get(i)==200)
		      {
		        p200++;
		      }
		      else if(yy.get(i)==100)
		      {
		        p100++;
		      }
		      else if(yy.get(i)==50)
		      {
		        p50++;
		      }
		      else if(yy.get(i)==30)
		      {
		        p30++;
		      }
		      else if(yy.get(i)==20)
		      {
		        p20++;
		      }
		      else if(yy.get(i)==10)
		      {
		        p10++;
		      }
		}
		
		String msg = "The coins exchanged are: "+p200+" x 200 "+getCurrency()+" ( or "+p200+" x 2£) , "+p100+" x 100"+getCurrency()+
				" ( or "+p100+" x 1£) , "+p50+" x 50"+getCurrency()+", "+p30+" x 30"+getCurrency()+", "
				+p20+" x 20"+getCurrency()+", "+p10+" x 10"+getCurrency();
		return remainderValue == 0 ? msg : msg+", with a remainder of "+remainderValue+"P";
		
	}
	
	public String displayProgramConfigs()
	{
		return "";
	}

	public int remainderValue = 0;
	public ArrayList<Integer> processMultiCoinList(int n, ArrayList<Integer> arr)
	{
		if(n == 0 || arr.size() == 0) 
		{
		   return arr;
		}
		else 
		{
		  if(n >= arr.get(0)) 
		  {
		  int t = n - arr.get(0);
		  createMultiCoinList.add(arr.get(0));
		  return processMultiCoinList(t,arr);
		  }
		  
		else 
		{
		 if(n < 10) 
		 {
			remainderValue = n;
			return arr;
		 }
		arr.remove(0);
		return processMultiCoinList(n,arr);
		
		} 
	
		}
		
	}

}

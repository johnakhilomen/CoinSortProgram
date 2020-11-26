package com.coinsort.johnakhilomen;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinSorter {
	
	private String _currency;
	private int _minCoinIn;
	private int _maxCoinIn;
	private ArrayList<Integer> _coinList;
	
	public CoinSorter(String currency, int minCoinIn, int maxCoinIn, ArrayList<Integer> coinList)
	{
		_currency = currency;
		_coinList = coinList;
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
		return "The current coin denominations are in circulation: "+_coinList.toString() ;
	}
	
	public String coinCalculator(int totalValue, int coinType) 
	{
		int numberOfCoins = (int) Math.floor(totalValue / coinType);
		int numberOfCoinsRemainder = totalValue % coinType;
		String msg = "A total of "+numberOfCoins +" x " +coinType+ getCurrency()+" coins can be exchanged";
		return numberOfCoinsRemainder == 0 ? msg : msg+", with a remainder of "+numberOfCoinsRemainder+getCurrency();
	}
	
	public String multiCoinCalculator(int totalValue, int coinTypeToExclude) 
	{
		int p200 = 0;
		int p100 = 0;
		int p50 = 0;
		int p30 = 0;
		int p20 = 0;
		int p10 = 0;
		  
		//Integer[] intArr = new Integer[] {200,100,50,30,20,10};
		Integer[] intArr = new Integer[] {200,100,30,10};
		toCoins(562, new ArrayList<Integer>(Arrays.asList(intArr)));
		var yy = y;
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
		return "The coins exchanged are: "+p200+" x 200p, "+p100+" x 100p, "+p50+" x 50p, "+p30+" x 30p, "
		+p20+" x 20p, "+p10+" x 10p, with a remainder of 2p";
	}
	
	public String displayProgramConfigs()
	{
		return "";
	}

	public ArrayList<Integer> y = new ArrayList<Integer>();

	public ArrayList<Integer> toCoins(int n, ArrayList<Integer> arr)
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
		  y.add(arr.get(0));
		  return toCoins(t,arr);
		  }
		  
		else 
		{
		 if(n < 10) 
		 {
			return arr;
		 }
		arr.remove(0);
		return toCoins(n,arr);
		
		} 
	
		}
		
	}

}

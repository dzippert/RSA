public class HHsehrLongConvert
{
  private int[] zahlcA, zahlcB, zahlcG, zahlcI, zahlc1, zahlc2, intresc, resint, wert, wertres;
  private int resintx;
  private long[] zahlcC, zahlc3, zahlcH, reslongarr;
  private long reslong, zahlcJ;
  private int i, j, k, l, m, n;
  private String Resxc, Strresc, Strrescl;
  private String ZahlcD, ZahlcE, ZahlcF, Zahlstr1, Zahlstr2, Zahlstr3;

  public int[] getIntInt(int[] zahlcA)
  {
    this.zahlcA = zahlcA;
    intInt(zahlcA);
    return intresc;

  }
  public String getIntStr(int[] zahlcB)
  {
    this.zahlcB = zahlcB;
    intStr(zahlcB);
    return Strresc;
  }

  public String getLongStr(long[] zahlcC)
  {
    this.zahlcC = zahlcC;
    longStr(zahlcC);
    return Strrescl;
  }

  public int[] getStrInt(String ZahlcD)	// 4-Stelliges int-Array
  {
    this.ZahlcD = ZahlcD;
    strInt(ZahlcD);
    return resint;
  }

  public long getStrLong(String ZahlcF)
  {
    this.ZahlcF = ZahlcF;
    strLong(ZahlcF);
    return reslong;    
  }

  public long[] getStrLongArray(String ZahlcE)	// 1-Stelliges long-Array
  {
    this.ZahlcE = ZahlcE;
    strLongArr(ZahlcE);
    return reslongarr;    
  }

  public long getIntLong(int[] zahlcG)
  {
    this.zahlcG = zahlcG;
    String Zwstr = getIntStr(zahlcG);
    strLong(Zwstr);
    return reslong;
  }

  public long[] getIntLongArray(int[] zahlcI)
  {
    this.zahlcI = zahlcI;
    String Zwstr = getIntStr(zahlcI);
    strLongArr(Zwstr);
    return reslongarr;
  }

  public int[] getLongInt(long zahlcJ)
  {
    this.zahlcJ = zahlcJ;
    Long longObject = new Long(zahlcJ);
    String Zwstr = longObject.toString();
    strInt(Zwstr);
    return resint;
  }

  public int[] getLongArrInt(long[] zahlcH)
  {
    this.zahlcH = zahlcH;
    String Zwstr = getLongStr(zahlcH);
    strInt(Zwstr);
    return resint;
  }

  public HHsehrLongConvert()
  {
    // (Klasse)
  }

  private void intInt(int[] zahlc1)
  {
    this.zahlc1 = zahlc1;
    int x = zahlc1.length;
    i = 0; j = 0;
    boolean end=false;
    while (end==false)
    {
      if (zahlc1[j]!=0) 
      {
	end = true;
      }
      else
      {
	i++; j++;
      }
      if (j>=x) end = true;
    }
    k = zahlc1.length - i;
    if (k==0)
    {
      intresc = new int[1];
      intresc[0] = 0;
    }
    else
    {
      intresc = new int[k];
      for (l=0; l<k; l++)
      {
        intresc[l] = zahlc1[l+i];
      }
    }
  }

  private void intStr(int[] zahlc2)
  {
    this.zahlc2 = zahlc2;
    k = zahlc2.length;
    boolean minus = false;
    if (zahlc2[k-1]<0)
    {
      for(i=0; i<k; i++)
      {
	zahlc2[i] *= (-1); minus = true;
      }
    }
    Integer intObject = new Integer(zahlc2[0]);
    Strresc = intObject.toString();
    if (k>1)
    {
      for (l=1; l<k; l++)
      {
        intObject = new Integer(zahlc2[l]);
        Resxc = intObject.toString();
        if (zahlc2[l]>9)
        {
          if (zahlc2[l]>99)
          {
            if (zahlc2[l]>999)
            {
              Strresc += Resxc;
            }
	    else
  	    {
  	     Strresc += "0"+Resxc;
	    }
          }
          else
          {
  	    Strresc += "00"+Resxc;
          }
        }
        else
        {
          if (zahlc2[l]==0)
          {
  	    Strresc += "0000";
          }
          else
          {
            Strresc += "000"+Resxc;
          }
        }
      }
    }
    if (minus==true)
    {
      Strresc = "-"+Strresc;
    }
  }

  private void longStr(long[] zahlc3)
  {
    this.zahlc3 = zahlc3;
    k = zahlc3.length;
    boolean minus = false;
    if (zahlc3[k-1]<0)
    {
      for(i=0; i<k; i++)
      {
	zahlc3[i] *= (-1L); minus = true;
      }
    }
    Strrescl = (minus==true)? "-" : "";
    j = 0;
    for (l=0; l<k; l++)
    {
      if(zahlc3[l]!=0)
      {
	Long longObject = new Long(zahlc3[l]);
	Strrescl += longObject.toString(); j++;
      }
      else
      {
	if (j>0)
	  Strrescl += "0";
      }
    }
    if (j==0)
      Strrescl += "0";
  }

  private void strInt(String Zahlstr1)
  {
    this.Zahlstr1 = Zahlstr1;
    k = Zahlstr1.length();
    String Substr = Zahlstr1.substring(0, 1); boolean minus = false;
    if (Substr=="-")
    {
      Zahlstr1 = Zahlstr1.substring(1, k); minus = true;
    }
    m = k % 4;
    n = (m==0)? 0 : 1;
    l = k - m;
    j = (m==0)? l / 4 : (l / 4) + 1;

    String Strsub;
    resint = new int[j];
    if (m!=0)
    {
      Strsub = Zahlstr1.substring(0, m);
      Integer intObject = Integer.valueOf(Strsub);
      resint[0] = intObject.intValue();
    }
    l = 0;
    for (i=n; i<j; i++)
    {
      Strsub = Zahlstr1.substring(m+l*4, m+(l+1)*4); l++;
      Integer intObject = Integer.valueOf(Strsub);
      resint[i] = intObject.intValue();
    }
    if (minus==true)
    {
      neg(resint); resint = wertres;
    }
  }

  private void strLongArr(String Zahlstr2)
  {
    this.Zahlstr2 = Zahlstr2;
    k = Zahlstr2.length();
    reslongarr = new long[k];
    String Stringzahl;
    for (i=0; i<k; i++)
    {
      Stringzahl = Zahlstr2.substring(i, i+1);
      Long longObject = Long.valueOf(Stringzahl);
      reslongarr[i] = longObject.longValue();
    }
  }

  private void strLong(String Zahlstr3)
  {
    this.Zahlstr3 = Zahlstr3;
    Long longObject = Long.valueOf(Zahlstr3);
    reslong = longObject.longValue();
  }

  private void neg(int[] wert)
  {
    this.wert = wert; int a = wert.length;
    wertres = new int[a];
    for(i=0; i<a; i++)
    {
      wertres[i] = wert[i] * (-1);
    }
  }
}

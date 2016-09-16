import java.util.*;

public class HsehrLong
{
	private int w, x, y, y2, z, h, i, j, k, l;
	private int[] zahlres, plus, zwresult, intres, intresadd, wert, wertres;
	private long zahlreslr, rest;
	private long[] zahlresl, resquot;
	private long[][] resquot0rest1;
	private String zwres, strres, resx, qq;
	private boolean grkl, grkll, klgr, nullen;
	private int[] resultAdd, resultSub, resultProd, resultQuot, resultMod, resmod, quot;

	public int[] getIntAddInt(int[] zahlA, int[] zahlB)
	{
	  int[] zahla = zahlA;
	  int[] zahlb = zahlB;
	  int a = zahla.length; int b = zahlb.length; int i;
	  if (zahla[a-1] < 0)
	  {
	    if (zahlb[b-1] < 0)
	    {
	      neg(zahla); zahla = wertres;
	      neg(zahlb); zahlb = wertres;
	      add(zahla, zahlb);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intresadd = hslc.getIntInt(resultAdd);
	      neg(intresadd); intresadd = wertres;
	    }
	    else
	    {
	      neg(zahla); zahla = wertres;
	      intresadd = getIntSubInt(zahlb, zahla);
	    }
	  }
	  else
	  {
	    if (zahlb[b-1] < 0)
	    {
	      neg(zahlb); zahlb = wertres;
	      intresadd = getIntSubInt(zahla, zahlb);
	    }
	    else
	    {
	      add(zahla, zahlb);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intresadd = hslc.getIntInt(resultAdd);
	    }
	  }
	  return intresadd;
	}

	public String getIntAddStr(int[] zahlC, int[] zahlD)
	{
	  int[] zahlc = zahlC;
	  int[] zahld = zahlD;
	  zahlres = getIntAddInt(zahlc, zahld);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getIntStr(zahlres);
	  return strres;
	}

	public int[] getIntSubInt(int[] zahlE, int[] zahlF)
	{
	  int[] zahle = zahlE;
	  int[] zahlf = zahlF;
	  int a = zahle.length; int b = zahlf.length; int i;
	  if (zahle[a-1] < 0)
	  {
	    if (zahlf[b-1] < 0)
	    {
	      neg(zahle); zahle = wertres;
	      neg(zahlf); zahlf = wertres;
	      grkll(zahlf, zahle);
	      sub(zahlf, zahle);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultSub);
	      if (grkll == false)
	      {
	        neg(intres); intres = wertres;
	      }	      
	    }
	    else
	    {
	      neg(zahle); zahle = wertres;
	      add(zahle, zahlf);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultAdd);	      
	      neg(intres); intres = wertres;
	    }
	  }
	  else
	  {
	    if (zahlf[b-1] < 0)
	    {
	      neg(zahlf); zahlf = wertres;
	      add(zahle, zahlf);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultAdd);	      
	    }
	    else
	    {
	      grkll(zahle, zahlf);
	      sub(zahle, zahlf);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultSub);
	      if (grkll == false)
	      {
		neg(intres); intres = wertres;
	      }
	    }
	  }
	  return intres;
	}

	public String getIntSubStr(int[] zahlG, int[] zahlH)
	{
	  int[] zahlg = zahlG;
	  int[] zahlh = zahlH;
	  zahlres = getIntSubInt(zahlg, zahlh);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getIntStr(zahlres);
	  return strres;
	}

	public int[] getIntProdInt(int[] zahlI, int[] zahlJ)
	{
	  int[] zahli = zahlI;
	  int[] zahlj = zahlJ;
	  int a = zahli.length; int b = zahlj.length; int i, j;
	  if (zahli[a-1] < 0)
	  {
	    if (zahlj[b-1] < 0)
	    {
	      neg(zahli); zahli = wertres;
	      neg(zahlj); zahlj = wertres;
	      prod(zahli, zahlj);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultProd);
	    }
	    else
	    {
	      neg(zahli); zahli = wertres;
	      prod(zahli, zahlj);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultProd);
	      neg(intres); intres = wertres;
	    }
	  }
	  else
	  {
	    if (zahlj[b-1] < 0)
	    {
	      neg(zahlj); zahlj = wertres;
	      prod(zahli, zahlj);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultProd);
	      neg(intres); intres = wertres;
	    }
	    else
	    {
	      prod(zahli, zahlj);
	      HHsehrLongConvert hslc = new HHsehrLongConvert();
	      intres = hslc.getIntInt(resultProd);
	    }
	  }
	  return intres;
	}

	public String getIntProdStr(int[] zahlK, int[] zahlL)
	{
	  int[] zahlk = zahlK;
	  int[] zahll = zahlL;
	  zahlres = getIntProdInt(zahlk, zahll);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getIntStr(zahlres);
	  return strres;
	}

	public int[] getIntQuadratInt(int[] zahlM)
	{
	  int[] zahlm = zahlM;
	  quadrat(zahlm);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  intres = hslc.getIntInt(resultProd);
	  return intres;
	}

	public String getIntQuadratStr(int[] zahlN)
	{
	  int[] zahln = zahlN;
	  zahlres = getIntQuadratInt(zahln);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getIntStr(zahlres);
	  return strres;
	}

	public int[] getIntModInt(int[] zahlO, int[] modzahlP)
	{
	  int[] zahlo = zahlO;
	  int[] zahlp = modzahlP;
	  mod(zahlo, zahlp);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  intres = hslc.getIntInt(resultMod);
	  return intres;
	}

	public String getIntModStr(int[] zahlQ, int[] modzahlR)
	{
	  int[] zahlq = zahlQ;
	  int[] zahlr = modzahlR;
	  zahlres = getIntModInt(zahlq, zahlr);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getIntStr(zahlres);
	  return strres;
	}

	public int[] getIntQuotInt(int[] zahlCC, int[] zahlDD)
	{
	  int[] zahlcc = zahlCC;
	  int[] zahldd = zahlDD;
	  modquot(zahlcc, zahldd);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  quot = hslc.getStrInt(qq);
	  return quot;
	}

	public String getIntQuotStr(int[] zahlEE, int[] zahlFF)
	{
	  int[] zahlee = zahlEE;
	  int[] zahlff = zahlFF;
	  zahlres = getIntQuotInt(zahlee, zahlff);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getIntStr(zahlres);
	  return strres;
	}

	public long[] getLongQuotLong(long[] zahlS, long zahlT)
	{
	  long[] zahls = zahlS;
	  long zahlt = zahlT;
	  quot(zahls, zahlt);
	  return resquot;
	}

	public long getLongQuotRestLong(long[] zahlSr, long zahlTr) // äquivalent zu Mod
	{
	  long[] zahlsr = zahlSr;
	  long zahltr = zahlTr;
	  quot(zahlsr, zahltr);
	  return rest;
	}

	public String getLongQuotStr(long[] zahlU, long zahlV)
	{
	  long[] zahlu = zahlU;
	  long zahlv = zahlV;
	  zahlresl = getLongQuotLong(zahlu, zahlv);
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  strres = hslc.getLongStr(zahlresl);
	  return strres;
	}

	public String getLongQuotRestStr(long[] zahlUr, long zahlVr) // äquivalent zu Mod
	{
	  long[] zahlur = zahlUr;
	  long zahlvr = zahlVr;
	  zahlreslr = getLongQuotRestLong(zahlur, zahlvr);
	  Long longObject = new Long(zahlreslr);
	  strres = longObject.toString();
	  return strres;
	}

	public boolean getGrkl(int[] zahlW, int[] zahlX)
	{
	  int[] zahlw = zahlW; int[] zahlx = zahlX;
	  grkl(zahlw, zahlx);
	  return grkl;
	}

	public boolean getGrkll(int[] zahlY, int[] zahlZ)
	{
	  int[] zahly = zahlY; int[] zahlz = zahlZ;
	  grkll(zahly, zahlz);
	  return grkll;
	}

	public boolean getKlgr(long zahlAA, long zahlBB)
	{
	  long zahlaa = zahlAA; long zahlbb = zahlBB;
	  klgr(zahlaa, zahlbb);
	  return klgr;
	}

	public int[] getNeg(int[] zahlCC)
	{
	  int[] zahlcc = zahlCC;
	  neg(zahlcc);
	  return wertres;
	}


	public HsehrLong()
	{
	  // (Klasse - Konstruktor)
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

	private void add(int[] zahl100, int[] zahl200)
	{
	  int[] zahl1 = zahl100;
	  int[] zahl2 = zahl200;		
	  int x = zahl1.length;
	  int y = zahl2.length;
	  int w = (x==y)? x : Math.min(x,y);
	  int z = (x==y)? x : Math.max(x,y);

	  int[] plus = new int[w+1];
	  resultAdd = new int[z+1];

	  plus[w] = 0;
	  for (int j=0; j<w; j++)
	  {
	    resultAdd[z-j] = (zahl1[x-1-j] + zahl2[y-1-j] + plus[w-j]) % 10000;
	    plus[w-1-j] = (zahl1[x-1-j]+zahl2[y-1-j]>=10000)? 1 : 0; //(zahl1[x-1-j] + zahl2[y-1-j] + plus[w-j] - result[z-j]) / 10000;
	  }
	  int[] zahlX = new int[z+1];
	  zahlX[0] = 0;
	  for (int l=1; l<=z; l++)
	  {
	    zahlX[l] = (x==z)? zahl1[l-1] : zahl2[l-1];
	  }
	  for (int i=w; i<=z; i++)
	  {
	    resultAdd[z-i] = (i==w)? zahlX[z-i] + plus[0] : zahlX[z-i];
	  }
	}

	private void sub(int[] zahl101, int[] zahl201)
	{
	  int[] zahl300 = zahl101;
	  int[] zahl400 = zahl201;
	  int w = zahl300.length;
	  int z = zahl400.length;
	  grkl(zahl300, zahl400);
	  int[] zahl3 = (grkll==true/*w>=z*/)? zahl300 : zahl400;
	  int[] zahl4 = (grkl==false/*w<z*/)? zahl300 : zahl400;
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  zahl3 = hslc.getIntInt(zahl3);
	  zahl4 = hslc.getIntInt(zahl4);
	  int x = zahl3.length;
	  int y = zahl4.length;
	  int[] zahlX = new int[x];
	  for (int k=0; k<x; k++)
	  {
	    zahlX[x-1-k] = (k<y)? zahl4[y-1-k] : 0;
	  }
	  int[] plus = new int[x+1];
	  resultSub = new int[x];

	  plus[x] = 0;
	  for (int j=0; j<x; j++)
	  {
	    resultSub[x-1-j] = (10000 + zahl3[x-1-j] - zahlX[x-1-j] - plus[x-j]) % 10000;
	    plus[x-1-j] = (zahl3[x-1-j]>=zahlX[x-1-j]+plus[x-j])? 0 : 1; //(zahl1[x-1-j] + zahl2[y-1-j] + plus[w-j] - result[z-j]) / 10000;
	  }
	}

	private void prod(int[] zahl102, int[] zahl202)
	{
	  int[] zahl5 = zahl102;
	  int[] zahl6 = zahl202;		
	  int x = zahl5.length;
	  int y = zahl6.length;
	  int z = x + y;

	  int[] plus = new int[y+1];	 
	  int[] zwresult = new int[y+1];
	  resultProd = new int[z];
	  for (int l=0; l<z; l++)
	  {
	    resultProd[l] = 0;		
	  }
		
	  for (int j=0; j<x; j++)
	  {	
	    plus[y] = 0;
	    for (i=0; i<y; i++)
	    {
	      zwresult[y-i] = (zahl5[x-1-j] * zahl6[y-1-i] + plus[y-i]) % 10000;
	      plus[y-1-i] = (zahl5[x-1-j] * zahl6[y-1-i] + plus[y-i] - zwresult[y-i]) / 10000;
	    }
	    zwresult[0] = plus[0];

	    for (int k=0; k<y+1; k++)
	    {
	      resultProd[z-1-j-k] += zwresult[y-k];
	      if (resultProd[z-1-j-k]>9999)
	      {
		resultProd[z-2-j-k] += (resultProd[z-1-j-k]-(resultProd[z-1-j-k]%10000))/10000;
		resultProd[z-1-j-k] %= 10000;
	      }
	    }
	  }
	}

	private void quadrat(int[] zahl103)
	{
	  int[] zahl7 = zahl103;
	  prod(zahl7, zahl7);
	}
	
	private void mod(int[] zahl104, int[] modzahl204) // ..., long zahl2) ?
	{
	  int[] zahl8 = zahl104;
	  int[] zahl9 = modzahl204;
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  zahl8 = hslc.getIntInt(zahl8);
	  zahl9 = hslc.getIntInt(zahl9);
	  int y = zahl9.length;

	  grkll(zahl8, zahl9);
	  while (grkll==true)
	  {
	    int x = zahl8.length;
	    int[] zahl10 = new int[x];
	    if (x>y)
	    {
	      int h = 0; int hz = 0; boolean hb = false;
	      while (hb==false)
	      {
		if (zahl9[hz]==zahl8[hz])
		{
		  hz++;
		  if (hz==y)
		  {
		    hb =true; h = 0;
		  }
		}
		else
		{
	          h = (zahl9[hz]>zahl8[hz])? 1 : 0;
		  hb = true;
		}
	      }
	      if (h==1) zahl10[0] = 0;
	      for (int i=h; i<x; i++)
	      {
		zahl10[i] = (i<y+h)? zahl9[i-h] : 0;
	      }
	    }
	    else
	    {
	      zahl10 = zahl9;
	    }
	    int[] zahl11 = getIntSubInt(zahl8, zahl10);
	    grkll(zahl11, zahl9);
	    zahl8 = zahl11;
	  }
	  int z = zahl8.length;
	  resultMod = new int[z];
	  resultMod = zahl8;
	}

	private void modquot(int[] zahl109, int[] zahl209)
	{
	  int[] zahl20 = zahl109;
	  int[] zahl21 = zahl209;
	  HHsehrLongConvert hslc = new HHsehrLongConvert(); Vector qv; qv = new Vector(); String[] qs;
	  zahl20 = hslc.getIntInt(zahl20);
	  zahl21 = hslc.getIntInt(zahl21);
	  int x = zahl20.length; int xx = x, yy, zz, sz, q = 0, qi, r = 0; qq = "";
	  int y = zahl21.length; int i; int[] zahl22; int[] zahl23;
	  Integer intObject;

	  grkll(zahl20, zahl21); yy = xx; zz = 0;
	  while (grkll==true)
	  {
	    if (yy!=xx)
	    {
	      qv.addElement(q);

	      for (i=1; i<zz; i++)
	      {
		qv.addElement('0');
	      }
	      q = r; r = 0;
	    }
	    zahl22 = new int[xx];
	    if (xx>y)
	    {
	      int h = 0; int hz = 0; boolean hb = false;
	      while (hb==false)
	      {
		if (zahl21[hz]==zahl20[hz])
		{
		  hz++;
		  if (hz==y)
		  {
		    hb =true; h = 0;
		  }
		}
		else
		{
	          h = (zahl21[hz]>zahl20[hz])? 1 : 0;
		  hb = true;
		}
	      }
	      if (h==1)
	      {
		r++;
	      }
	      else
	      {
		q++;
	      }
	      if (h==1) 
	      {
		zahl22[0] = 0;
	      }
	      for (i=h; i<xx; i++)
	      {
		zahl22[i] = (i<y+h)? zahl21[i-h] : 0;
	      }
	    }
	    else
	    {
	      zahl22 = zahl21;
	      q++;
	    }
	    zahl23 = getIntSubInt(zahl20, zahl22);
	    grkll(zahl23, zahl21);
	    zahl20 = zahl23;
	    yy = xx; xx = zahl20.length; zz = yy - xx;
	  }
	  qv.addElement(q);
	  for (i=1; i<zz; i++)
	  {
	    qv.addElement('0');
	  }
	  if (r!=0) qv.addElement(r);
	  sz = qv.size(); qs = new String[sz];
	  qs[0] = qv.get(0).toString();	
	  intObject = Integer.valueOf(qs[0]);
	  qi = intObject.intValue();
	  qq += (qi==0)? "" : qs[0];if (sz==1 & qi==0) qq = "0";
	  for (i=1; i<sz; i++)
	  {
	    qs[i] = qv.get(i).toString();
	    switch (qs[i].length())
	    {
	      case 1: qq += "000"+qs[i]; break;
	      case 2: qq += "00"+qs[i]; break;
	      case 3: qq += "0"+qs[i]; break;
	      default: qq += qs[i]; break;
	    }
	  }
	  int z = zahl20.length;
	  resmod = new int[z];
	  resmod = zahl20;
	}

	private void grkl(int[] zahl105, int[] zahl205)    // falls: zahl1 = zahl2, grkl = false!!!
	{
	  int[] zahl12 = zahl105;
	  int[] zahl13 = zahl205;
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  zahl12 = hslc.getIntInt(zahl12);
	  zahl13 = hslc.getIntInt(zahl13);
	  int x = zahl12.length;
	  int y = zahl13.length;
	  if (x>y) grkl = true;
	  if (x<y) grkl = false;
	  if (x==y)
	  {
	    grkl = false; int i = 0;
	    while (i<x)
	    {
	      if (zahl12[i]==zahl13[i]) 
	      {
		i++;
	      }
	      else
	      {
		grkl = (zahl12[i]>zahl13[i])? true : false;
		i = x;
	      }
	    }
	  }
	}

	private void grkll(int[] zahl108, int[] zahl208)    // falls: zahl1 = zahl2, grkll = true!!!
	{
	  int[] zahl18 = zahl108;
	  int[] zahl19 = zahl208;
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  zahl18 = hslc.getIntInt(zahl18);
	  zahl19 = hslc.getIntInt(zahl19);
	  int x = zahl18.length;
	  int y = zahl19.length;
	  if (x>y) grkll = true;
	  if (x<y) grkll = false;
	  if (x==y)
	  {
	    grkll = true; int i = 0;
	    while (i<x)
	    {
	      if (zahl18[i]==zahl19[i]) 
	      {
		i++;
	      }
	      else
	      {
		grkll = (zahl18[i]<zahl19[i])? false : true;
		i = x;
	      }
	    }
	  }
	}

	private void klgr(long zahl107, long zahl207)    // falls: zahl1 = zahl2, klgr = true!!!
	{
	  long zahl16 = zahl107;
	  long zahl17 = zahl207;
	  klgr = (zahl16<zahl17)? false : true;
	}

	private void quot(long[] zahl106, long zahl206)
	{
	  long[] zahl14 = zahl106; long zahl15 = zahl206;
	  HHsehrLongConvert hslc = new HHsehrLongConvert();
	  int j = zahl14.length;
	  rest = 0; long restx; boolean gr = false; int k = 0;
	  for (int i=0; i<j; i++)
	  {
	    rest *= 10; rest += zahl14[i];
	    klgr(rest, zahl15);
	    if (gr==false)
	    {
	      if (klgr==true)
	      {
		resquot0rest1 = new long[2][j-i]; resquot = new long[j-i];
		resquot0rest1[1][0] = rest % zahl15;
		rest -= resquot0rest1[1][0];
		resquot0rest1[0][0] = rest / zahl15;
		resquot[0] = resquot0rest1[0][0];
		rest = resquot0rest1[1][0]; k++;
		gr = true;
	      }
	      if (i==j-1 & k==0)
	      {
		resquot0rest1 = new long[2][1]; resquot = new long[1];
		resquot0rest1[0][0] = 0; resquot[0] = resquot0rest1[0][0];
	      }
	    }
	    else
	    {
	      resquot0rest1[1][0] = rest % zahl15;
	      rest -= resquot0rest1[1][0];
	      resquot0rest1[0][k] = rest / zahl15;
	      resquot[k] = resquot0rest1[0][k];
	      rest = resquot0rest1[1][0]; k++;
	    }
	  }
	  resquot0rest1[1][0] = rest;
	}



/*		Integer iObject = Integer.valueOf(str);
		inte = iObject.intValue();	}
	public void cStringIntegerArray(String[] strA)	{
		this.strA = strA;
		arrayInt = new int[strA.length];
		for (int i = 0; i < strA.length; i++)
		{
			Integer iObject = Integer.valueOf(strA[i]);
			arrayInt[i] = iObject.intValue();
		}	}
	public void cStringIntegerMatrix(String[][] strM)	{
		this.strM = strM;
		matrixInt = new int[strM.length][strM[0].length];
		for (int i = 0; i < strM[0].length; i++)
		{
			for (int j = 0; j < strM.length; j++)
			{
				Integer iObject = Integer.valueOf(strM[j][i]);
				matrixInt[j][i] = iObject.intValue();
			}
		}	}

	public void cStringDouble(String str)	{
		this.str = str;
		Double dObject = Double.valueOf(str);
		dbl = dObject.doubleValue();	}
	public void cStringDoubleArray(String[] strA)	{
		this.strA = strA;
		arrayDbl = new double[strA.length];
		for (int i = 0; i < strA.length; i++)
		{
			Double dObject = Double.valueOf(strA[i]);
			arrayDbl[i] = dObject.doubleValue();
		}	}
	public void cStringDoubleMatrix(String[][] strM)	{
		this.strM = strM;
		matrixDbl = new double[strM.length][strM[0].length];
		for (int i = 0; i < strM[0].length; i++)
		{
			for (int j = 0; j < strM.length; j++)
			{
				Double dObject = Double.valueOf(strM[j][i]);
				matrixDbl[j][i] = dObject.doubleValue();
			}
		}	}

	public void cStringLong(String str)	{
		this.str = str;
		Long lObject = Long.valueOf(str);
		lng = lObject.longValue();	}
	public void cStringLongArray(String[] strA)	{
		this.strA = strA;
		arrayLng = new long[strA.length];
		for (int i = 0; i < strA.length; i++)
		{
			Long lObject = Long.valueOf(strA[i]);
			arrayLng[i] = lObject.longValue();
		}	}
	public void cStringLongMatrix(String[][] strM)	{
		this.strM = strM;
		matrixLng = new long[strM.length][strM[0].length];
		for (int i = 0; i < strM[0].length; i++)
		{
			for (int j = 0; j < strM.length; j++)
			{
				Long lObject = Long.valueOf(strM[j][i]);
				matrixLng[j][i] = lObject.longValue();
			}
		}	} */
}

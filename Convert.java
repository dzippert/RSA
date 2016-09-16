import java.util.*;

public class Convert
{
  private String[] Str, StrArr, StrA, StrCode, SCode, Astr;
  private String[][] StrMat, StrM, Mstr, CodeStrM, MAscii, Ascii;
  private int n, m;

  public String[][] getStrArrStrM(String[] StrArr, int m)
  {
    this.StrArr = StrArr; this.m = m;
    strArrstrM(StrArr, m);
    return StrM;
  }

  public String[] getStrMatStrA(String[][] StrMat)
  {
    this.StrMat = StrMat;
    strMatstrA(StrMat);
    return StrA;
  }

  public String[][] getStrCodeStrM(String[] StrCode)
  {
    this.StrCode = StrCode;
    strCodestrM(StrCode);
    return CodeStrM;
  }

  public String[] getAsciiStr(String[][] MAscii)
  {
    this.MAscii = MAscii;
    asciistr(MAscii);
    return Astr;
  }


  public Convert()
  {
    // (Klasse)
  }

  private void strArrstrM(String[] Str, int n)
  {
    this.Str = Str; this.n = n; int l = Str.length; int llmax = 0; int i, ll, r, s, q, zv;
    if((n-2)%3==0) n--;
    for(i=2; i<l; i++)
    {
      r = Str[i].length();
      if (r>llmax) llmax = r;
    }
    q = llmax / (n - 2);
    StrM = new String[l][q+1]; llmax = q + 1;
    for(i=0; i<l; i++)
    {
      ll = Str[i].length(); r = ll % (n - 2); 
      q = (i<2)? 0 : ll / (n - 2); s = 0;
      if (r!=0 & i>1)
      {
        zv = (int) (Math.random()*10);
	StrM[i][0] = "1" + Str[i].substring(0, r) + zv;
	s = 1;
      }
      for(int j=s; j<llmax; j++)
      {
	if (i<2)
	{
	  StrM[i][j] = (j>q)? "leer" : Str[i];
	}
	else
	{
        zv = (int) (Math.random()*10);
StrM[i][j] = (j>q-((s+1)%2))? "leer" : "1"+Str[i].substring(s*(r+(n-2)*(j-1))+((s+1)%2)*((n-2)*j), s*(r+(n-2)*j)+((s+1)%2)*((n-2)*(j+1)))+zv;
	}
      }
    }
  }

  private void strMatstrA(String[][] Mstr)
  {
    this.Mstr = Mstr;
    int l = Mstr.length; int k = Mstr[0].length; StrA = new String[l];
    for(int i=0; i<l; i++)
    {
      StrA[i] = "";
      for(int j=0; j<k; j++)
      {
	StrA[i] += (j==0)? Mstr[i][j] : " "+Mstr[i][j];
      }
    }
  }

  private void strCodestrM(String[] SCode)
  {
    this.SCode = SCode;
    int i, j, k, l = 0, s, t, p; int n = SCode.length;
    String Wort; String[] StrWort; Vector wortv; boolean boo;
    HHsehrLongConvert hslc = new HHsehrLongConvert();
 
    for (i=0; i<n; i++)
    {
      t = 0; s = SCode[i].indexOf(' '); p = 1;
      while (s!=-1)
      {
	t = s; s = SCode[i].indexOf(' ', t+1); p++;
      }
      if (p>l) l = p;
    }
    CodeStrM = new String[n][l];
    for (i=0; i<n; i++)
    {
      t = 0; s = SCode[i].indexOf(' '); boo = false; wortv = new Vector();
      if (s!=-1)
      {
	Wort = SCode[i].substring(0, s);
      }
      else
      {
	Wort = (SCode[i].length()>0)? SCode[i].substring(0, SCode[i].length()) : "leer";
      }
      wortv.addElement(Wort); if (s==-1) boo = true;
      while (boo==false)
      {
	t = s + 1; s = SCode[i].indexOf(' ', t+1);
	if (s!=-1)
	{
	  Wort = SCode[i].substring(t, s);
	}
	else
	{
	  Wort = SCode[i].substring(t, SCode[i].length());
	}
	wortv.addElement(Wort);
 	if (s==-1) boo = true;
      }
      k = wortv.size();
      for (j=0; j<l; j++)
      {
	CodeStrM[i][j] = (j<k)? wortv.get(j).toString() : "leer";
      }     
    }
  }

  private void asciistr(String[][] Ascii)
  {
    this.Ascii = Ascii; int i, j, k, l, x, zahl; char c; Integer intObject; Character cObject;
    Astr = new String[Ascii.length]; String Buchstaben;
    for(i=0; i<Ascii.length; i++)
    {
      Astr[i] = "";
      for(j=0; j<Ascii[0].length; j++)
      {
	x = Ascii[i][j].length();
	if (Ascii[i][j]!="leer" & x>1)
	{
	  Astr[i] += (j==0)? Ascii[i][j].substring(0, x-1) : Ascii[i][j].substring(1, x-1);
	}
      }
    }
    for(i=0; i<Ascii.length; i++)
    {
      x = Astr[i].length(); x = (x - 1) / 3; k = 0;
      Buchstaben = "";
      while(k<x)
      {
        intObject = Integer.valueOf(Astr[i].substring(1+3*k, 4+3*k));
	zahl = intObject.intValue();
	c = (char) zahl;
	cObject = new Character(c);
	Buchstaben += cObject.toString();
	k++;
      }
      Astr[i] = Buchstaben;
    }
  }

  private void asciistrOLD(String[][] Ascii)
  {
    this.Ascii = Ascii; int i, j, k, x, zahl; char c; Integer intObject; Character cObject;
    Astr = new String[Ascii.length];
    for(i=0; i<Ascii.length; i++)
    {
      Astr[i] = "";
      for(j=0; j<Ascii[0].length; j++)
      {
	x = Ascii[i][j].length(); x = (x - 1) / 3; k = 0;
	while(k<x)
	{
	  if (Ascii[i][j]!="leer")
	  {
	    intObject = Integer.valueOf(Ascii[i][j].substring(1+3*k, 4+3*k));
	    zahl = intObject.intValue();
	    c = (char) zahl;
	    cObject = new Character(c);
	    Astr[i] += cObject.toString();
	    k++;
	  }
	}
      }
    }
  }
}

import java.io.*;
import java.util.*;

class Read
{
  private String Dateiname, Datei, Eintrag;
  private Vector zeilen;
  private int n;
  private String[] StrArr, StrArray;
  private int[][] matrix; 
 
  public int getN()
  {
    return n;
  }

  public String[] getTextStr()
  {
    readtext();
    return StrArr;    
  }

  public String[] getCodeStr()
  {
    readcode();
    return StrArray;
  }

  public Read(String Dateiname)
  {
    this.Dateiname = Dateiname;
    Datei = Dateiname+".txt";
    try
    {
      FileReader fr = new FileReader(Datei);
      BufferedReader br = new BufferedReader(fr);
    
      zeilen = new Vector();

      Eintrag = "";
      n = 0; // Anzahl Zeilen
//      m = 0; // Anzahl Spalten
      while ( (Eintrag = br.readLine()) != null )
      {
        zeilen.addElement(Eintrag);
        int l = Eintrag.length();
//        if (l > m)
//          m = l;
      }
      n = zeilen.size();

      br.close();
    }
    catch(IOException ioe)
    {
      // IO-Exception
    } 
  }

  private void readtext()
  {
    String[] Arraystr = new String[n]; char[] zeichen;
    StrArr = new String[n+2]; // StrArr[0] = C, StrArr[1] = R=p*q ?
    int ascii, m, a;

//    matrix = new int[n+2][m]; // matrix[0][0] = C, matrix[1][0] = R=p*q

    for (int i=0; i<n; i++)
    {
      StrArr[i+2] = "";
      Arraystr[i] = zeilen.get(i).toString();
      m = Arraystr[i].length(); 
      if (m!=0)
      {
	zeichen = new char[m];
	for (int j=0; j<m; j++)
	{
	  zeichen[j] = Arraystr[i].charAt(j);
	  ascii = (int) zeichen[j]; Integer intObject =new Integer(ascii);
				    StrArr[0] = intObject.toString();
          if (ascii>9)
          {
            if (ascii>99)
            {
  	      StrArr[i+2] += StrArr[0];
	    }
            else
            {
  	      StrArr[i+2] += "0"+StrArr[0];
            }
          }
          else
          {
            if (ascii==0)
            {
  	      StrArr[i+2] += "000";
            }
            else
            {
              StrArr[i+2] += "00"+StrArr[0];
            }
          }
        }
      }
    }
    StrArr[0] = "c="; StrArr[1] = "p*q=";
  }

  public void readcode()
  {
    StrArray = new String[n];
    for (int i=0; i<n; i++)
    {
      StrArray[i] = zeilen.get(i).toString();
    }
    // trim:
    boolean boo; String Sub; char c; int lsub, ascii, k;
    for(int j=0; j<n; j++)
    {
      k = 0;
      lsub = StrArray[j].length();
      Sub = StrArray[j].substring(lsub-1);
      c = Sub.charAt(0);
      ascii = (int) c;
      boo = (ascii==32)? true : false;
      while(boo==true)
      {
	StrArray[j] = StrArray[j].substring(0, lsub-1-k); k++;
	Sub = (lsub>k)? StrArray[j].substring(lsub-k-1) : "X";
	c = Sub.charAt(0);
	ascii = (int) c;		
	if(ascii!=32) boo = false;
      }
    }

  }

}

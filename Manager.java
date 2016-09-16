public class Manager
{
  private int lp, lq, lb;
  private int[] p, q, c, pq;
  private int[][] pqcxy;
  private String Quelldatei, Zieldatei, CD;
  private String[] Info;

  public String[] getInfoCod()
  {
    HHsehrLongConvert hslc = new HHsehrLongConvert();
    for(int i=0; i<5; i++)
    {
      Info[i] = hslc.getIntStr(pqcxy[i]);
    }
    return Info;
  }

  public String[] getInfoDecod()
  {
    HHsehrLongConvert hslc = new HHsehrLongConvert();
    for(int i=0; i<5; i++)
    {
      Info[i] = hslc.getIntStr(pqcxy[i]);
    }
    return Info;
  }

  public Manager(int[] p, int[] q, int[] c, String Quelldatei, String Zieldatei, String CD)
  {
    // Konstruktor
    this.p = p; this.q = q; this.c = c; this.Quelldatei = Quelldatei; this.Zieldatei = Zieldatei; this.CD = CD;
    if(CD=="c")
    {
      // Länge der Blöcke ermitteln:
      int lp1, lp2, lq1, lq2;
      lp1 = p.length - 1;
      if (p[0]>999) lp2 = 4;
      else
      {
	if (p[0]>99) lp2 = 3;
	else
	{
	  if (p[0]>9) lp2 = 2;
	  else lp2 = 1;
	}
      }
      lq1 = q.length - 1;
      if (q[0]>999) lq2 = 4;
      else
      {
	if (q[0]>99) lq2 = 3;
	else
	{
	  if (q[0]>9) lq2 = 2;
	  else lq2 = 1;
	}
      }
      lp = 4 * lp1 + lp2;
      lq = 4 * lq1 + lq2;
      lb = lp + lq - 1;

      codieren();
    }
    else
    {
      decodieren();
    }
  }

  private void codieren()
  {
    int i, j, lx, ly, lz; int[] zahl, zahlc;
    String CL; String[] Str, Code; String[][] Matrix, MCode;

    HsehrLong hsl = new HsehrLong();
    HHsehrLongConvert hslc = new HHsehrLongConvert();
    Convert cv = new Convert();
    RSAcalc rsa = new RSAcalc();
    //Primtest mit p und q, ggt-Test, ><-Test mitm y. --> Check.java	
    //Check test = new Check(p, q, c);
    //pqcxy = test.getParameter();

	//GGT - Test:
	GGT test = new GGT(p, q, c);
	pqcxy = test.getTest();

    // Nachricht auslesen:
    Read rd = new Read(Quelldatei); Str = rd.getTextStr();
    Matrix = cv.getStrArrStrM(Str, lb);
    lx = Matrix.length; ly = Matrix[0].length;

    //RSA:
    MCode = new String[lx][ly];
    //erste 2 Zeilen:
    lz = pqcxy[2].length;
    CL = "";
    for(i=0; i<lz; i++)
    {
      CL += pqcxy[2][i];
    }
    MCode[0][0] = Matrix[0][0]+CL;
    pq = hsl.getIntProdInt(pqcxy[0], pqcxy[1]);	
    lz = pq.length;
    CL = "";
    for(i=0; i<lz; i++)
    {
      CL += pq[i];
    }
    MCode[1][0] = Matrix[1][0]+CL;
    for(i=1; i<ly; i++)
    {
      MCode[0][i] = "";
      MCode[1][i] = "";
    }
    MCode[1][0] = Matrix[1][0]+CL;
    for(i=2; i<lx; i++)
    {
      for(j=0; j<ly; j++)
      {
        if(Matrix[i][j]=="leer")
        {
          MCode[i][j] = "";
        }
        else
        {
          zahl = hslc.getStrInt(Matrix[i][j]);
          zahlc = rsa.getCode(pqcxy[0], pqcxy[1], pqcxy[2], zahl);
          MCode[i][j] = hslc.getIntStr(zahlc);
        }
      }
    }
    Code = cv.getStrMatStrA(MCode);
    Write wr = new Write(Zieldatei, Code);
  }

  private void decodieren()
  {
    int i, j, lx, ly; int[] zahl, zahlc;
    String[] Str, Quelle; String[][] Matrix, MQuelle;
    String StrC;

    HHsehrLongConvert hslc = new HHsehrLongConvert();
    Convert cv = new Convert();
    RSAcalc rsa = new RSAcalc();

    // c aus Quelldatei auslesen:
    Read rd = new Read(Quelldatei); Str = rd.getCodeStr();
    StrC = Str[0].substring(2);
    c = hslc.getStrInt(StrC);

    //Primtest mit p und q, ggt-Test, ><-Test mitm y. --> Check.java
    //Check test = new Check(p, q, c);
    //pqcxy = test.getParameter();

    //GGT - Test:
    GGT test = new GGT(p, q, c);
    pqcxy = test.getTest();
	
    Matrix = cv.getStrCodeStrM(Str);
    lx = Matrix.length; ly = Matrix[0].length;
    //RSA
    MQuelle = new String[lx-2][ly];
    for(i=2; i<lx; i++)
    {
      for(j=0; j<ly; j++)
      {								//System.out.println(Matrix[i][j]+", ij:"+i+","+j);
        if(Matrix[i][j]=="leer")
        {
          MQuelle[i-2][j] = "";
        }
        else
        {
          zahl = hslc.getStrInt(Matrix[i][j]);
          zahlc = rsa.getQuelle(pqcxy[0], pqcxy[1], pqcxy[2], zahl);
          MQuelle[i-2][j] = hslc.getIntStr(zahlc);		//System.out.println(Matrix[i][j]);
        }
      }
    }
    Quelle = cv.getAsciiStr(MQuelle);
    Write wr = new Write(Zieldatei, Quelle);
  }
}

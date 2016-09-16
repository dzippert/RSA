public class RSAcalc
{
  private int[] p, q, c, nachricht, code, resc, res;

  public int[] getCode(int[] p, int[] q, int[] c, int[] nachricht)
  {
    this.p = p; this.q = q; this.c = c; this.nachricht = nachricht;
    cod(p, q, c, nachricht);
    return resc;
  }

  public int[] getQuelle(int[] p, int[] q, int[] c, int[] code)
  {
    this.p = p; this.q = q; this.c = c; this.code = code;
    decod(p, q, c, code);
    return res;
  }


  public RSAcalc()
  {
    // Konstruktor
  }

  private void cod(int[] p, int[] q, int[] c, int[] nachricht)
  {
    this.p = p; this.q = q; this.c = c; this.nachricht = nachricht;
    HsehrLong hsl = new HsehrLong();
    int[] zw1, zw2, zw3, zw4, zw5; int [] pq;
    pq = hsl.getIntProdInt(p, q);

    int[] zwei = new int[1]; zwei[0] = 2; int[] zweipot = new int[1]; int[] ii; boolean kl, lgr; int i, j;
    int[] l = c;
    zw1 = hsl.getIntModInt(nachricht, pq); zw3 = new int[1]; zw3[0] = 1;
    lgr = hsl.getGrkll(l, zwei); // int z = 0;
    while (lgr==true)
    {
      zweipot = new int[1]; zweipot[0] = 1; i = 0; ii = new int[1]; ii[0] = 1;
      zw4 = zw1;
      kl = false;
      while (kl == false)
      {
	if (i!= 0)
	{
	  zweipot = hsl.getIntProdInt(zweipot, zwei);
	}
	ii = hsl.getIntProdInt(ii, zwei);
	kl = hsl.getGrkl(ii, l); i++;
      }
      for (j=0; j<i-1; j++)
      {
	zw2 = hsl.getIntQuadratInt(zw4);
	zw4 = hsl.getIntModInt(zw2, pq);
	/* if (z==0)
	     Testen, ob zw4 = 1; wenn ja,  l = hsl.getIntModInt(l, zweipot?);
	*/
      }
      l = hsl.getIntModInt(l, zweipot); lgr = hsl.getGrkll(l, zwei);
      zw5 = hsl.getIntProdInt(zw3, zw4);
      zw3 = hsl.getIntModInt(zw5, pq); // z++;
    }
    zwei[0] = 1; lgr = hsl.getGrkll(l, zwei);
    if (lgr==true)
    {
      zw5 = hsl.getIntProdInt(zw3, zw1);
      zw3 = hsl.getIntModInt(zw5, pq);
    }  
    resc = zw3;					// N^c mod r = G
  }

  private void decod(int[] p, int[] q, int[] c, int[] code)
  {
    this.p = p; this.q = q; this.c = c; this.code = code;
    HsehrLong hsl = new HsehrLong();
    int[] zw1, zw2, zw3, zw4, zw5; int [] pq;
    pq = hsl.getIntProdInt(p, q);
	
    int[] pe, qe; int[] zwei = new int[1]; zwei[0] = 1;
    pe = hsl.getIntSubInt(p, zwei); qe = hsl.getIntSubInt(q, zwei);
    Euklid ekl = new Euklid(); int[] y = ekl.getY(pe, qe, c);

    zwei[0] = 2; int[] zweipot = new int[1]; int[] ii; boolean kl, lgr; int i, j;
    int[] l = y;
    zw1 = hsl.getIntModInt(code, pq); zw3 = new int[1]; zw3[0] = 1;
    lgr = hsl.getGrkll(l, zwei);
    while (lgr==true)
    {
      zweipot = new int[1]; zweipot[0] = 1; i = 0; ii = new int[1]; ii[0] = 1;
      zw4 = zw1;
      kl = false;
      while (kl == false)
      {
	if (i!= 0)
	{
	  zweipot = hsl.getIntProdInt(zweipot, zwei);
	}
	ii = hsl.getIntProdInt(ii, zwei);
	kl = hsl.getGrkl(ii, l); i++;
      }
      for (j=0; j<i-1; j++)
      {
	zw2 = hsl.getIntQuadratInt(zw4);
	zw4 = hsl.getIntModInt(zw2, pq);
      }
      l = hsl.getIntModInt(l, zweipot); lgr = hsl.getGrkll(l, zwei);
      zw5 = hsl.getIntProdInt(zw3, zw4);
      zw3 = hsl.getIntModInt(zw5, pq);
    }
    zwei[0] = 1; lgr = hsl.getGrkll(l, zwei);
    if (lgr==true)
    {
      zw5 = hsl.getIntProdInt(zw3, zw1);
      zw3 = hsl.getIntModInt(zw5, pq);
    }  
    res = zw3;						// G^y mod r = R
  }
}

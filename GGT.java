public class GGT
{
  int[] p, q, c, pp, qq, cc;
  int[][] pqcxy;

  public int[][] getTest()
  {
    HHsehrLongConvert hslc = new HHsehrLongConvert();
    for(int i=0; i<pqcxy.length; i++)
    {
      pqcxy[i] = hslc.getIntInt(pqcxy[i]);
    }
    return pqcxy;
  }

  public GGT(int[] pp, int[] qq, int[] cc)
  {
    this.pp = pp; this.qq = qq; this.cc = cc;
    test(pp, qq, cc);
  }

  private void test(int[] p, int[] q, int[] c)
  {
    this.p = p; this.q = q; this.c = c;
    HsehrLong hsl = new HsehrLong();
    int[] drei = new int[1]; drei[0] = 3; int[] eins = new int[1]; eins[0] = 1; int[] nul = new int[1]; nul[0] = 0; int i, k; int[] r, j, pe, qe;
    r = hsl.getIntModInt(c, drei);
    if(r[0]%3==1) c = hsl.getIntAddInt(c, eins);
    pe = hsl.getIntSubInt(p, eins); qe = hsl.getIntSubInt(q, eins);
    Euklid ekl = new Euklid(); int[] ggt, x, y; boolean bggt;
    ggt = ekl.getGgT(pe, qe, c); x = ekl.getX(pe, qe, c); y = ekl.getY(pe, qe, c);
    bggt = hsl.getGrkl(ggt, eins);
    while(bggt==true | y[0]<0)
    {
      c = hsl.getIntAddInt(c, eins);
      r = hsl.getIntModInt(c, drei);
      if(r[0]%3==1)
      {
	c = hsl.getIntAddInt(c, eins);
      }
      ggt = ekl.getGgT(pe, qe, c); x = ekl.getX(pe, qe, c); y = ekl.getY(pe, qe, c);
      bggt = hsl.getGrkl(ggt, eins);
    }
    k = 0; j = new int[5];
    j[0] = p.length; if(j[0]>k) k = j[0];
    j[1] = q.length; if(j[1]>k) k = j[1];
    j[2] = c.length; if(j[2]>k) k = j[2];
    j[3] = x.length; if(j[3]>k) k = j[3];
    j[4] = y.length; if(j[4]>k) k = j[4];
    pqcxy = new int[5][k];
    for(i=0; i<k; i++)
    {
      pqcxy[0][k-1-i] = (i<j[0])? p[j[0]-1-i] : 0;
      pqcxy[1][k-1-i] = (i<j[1])? q[j[1]-1-i] : 0;
      pqcxy[2][k-1-i] = (i<j[2])? c[j[2]-1-i] : 0;
      pqcxy[3][k-1-i] = (i<j[3])? x[j[3]-1-i] : 0;
      pqcxy[4][k-1-i] = (i<j[4])? y[j[4]-1-i] : 0;
    } 
  }
}

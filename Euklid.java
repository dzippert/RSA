public class Euklid
{
	private int[] P, Q, C;
	private int[] c, d, r, nullint;
	private int[] e, f, g, h, i, j, q;
	private int[] ggT, x, y;
	private int n, k; private boolean notnull;

	public int[] getGgT(int[] P, int[] Q, int[] C)
	{
		this.P = P; this.Q = Q; this.C = C;
		ggt(P, Q, C);
		return ggT;
	}
	public int getN(int[] P, int[] Q, int[] C)
	{
		this.P = P; this.Q = Q; this.C = C;
		ggt(P, Q, C);
		return n;
	}
	public int[] getX(int[] P, int[] Q, int[] C)
	{
		this.P = P; this.Q = Q; this.C = C;
		bezout(P, Q, C);
		return x;
	}
	public int[] getY(int[] P, int[] Q, int[] C)
	{
		this.P = P; this.Q = Q; this.C = C;
		bezout(P, Q, C);
		return y;
	}
	public int[] getGgTb(int[] P, int[] Q, int[] C)
	{
		this.P = P; this.Q = Q; this.C = C;
		bezout(P, Q, C);
		return ggT;
	}


	public Euklid()
	{
	  // Konstruktor
	}

	private void ggt(int[] P, int[] Q, int[] C)
	{
		// ggT(a, b) bestimmen (Euklid)
		this.P = P; this.Q = Q; this.C = C;
		HsehrLong hsl = new HsehrLong();
		nullint = new int[1]; nullint[0] = 0;
		c = hsl.getIntProdInt(P, Q); d = C; n = 0;
		do
		{
			r = hsl.getIntModInt(c, d);
			notnull = hsl.getGrkl(r, nullint); n += 1;
			if (notnull==true) 
			{
			  c = d;
			  d = r;
			}
		}
		while (notnull == true);
		ggT = d;
	}

	private void bezout(int[] P, int[] Q, int[] C)
	{
		// Lemma von Bezout:
		this.P = P; this.Q = Q; this.C = C;			int iiii=0;
		nullint = new int[1]; nullint[0] = 0; int[] zw1;	
		HsehrLong hsl = new HsehrLong(); HHsehrLongConvert hslc = new HHsehrLongConvert();
		c = hsl.getIntProdInt(P, Q); d = C; n = 0;
		do
		{
			switch(n)
			{
				case 0:
				{
					r = hsl.getIntModInt(c, d);
					notnull = hsl.getGrkl(r, nullint);
					if (notnull == false)
					{
						x = new int[1]; y = new int[1];
						x[0] = 0;	y[0] = 1;
					}
					else
					{
						q = hsl.getIntQuotInt(c, d);
						e = new int[1]; e[0] = 1;
						q = hsl.getNeg(q);
						f = q;

						c = d;
						d = r;
					}
				}
				break;

				case 1:
			    {
					r = hsl.getIntModInt(c, d);
					notnull = hsl.getGrkl(r, nullint);
					if (notnull == false)
					{
						x = e;
						y = f;
					}
					else
					{
						q = hsl.getIntQuotInt(c, d);
						q = hsl.getNeg(q);
						g = hsl.getIntProdInt(q, e);
						int[] eins = new int[1]; eins[0] = 1;
						zw1 = hsl.getIntProdInt(q, f);
						h = hsl.getIntAddInt(eins, zw1);
						c = d;
						d = r;
					}
				}
				break;
				default:
				{
					r = hsl.getIntModInt(c, d);
					notnull = hsl.getGrkl(r, nullint);
					if (notnull == false)
					{
						x = g;
						y = h;
					}
					else
					{
						q = hsl.getIntQuotInt(c, d);
						zw1 = hsl.getIntProdInt(q, g);
						i = hsl.getIntSubInt(e, zw1);
						zw1 = hsl.getIntProdInt(q, h);
						j = hsl.getIntSubInt(f, zw1);
					e = g;
					f = h;
					g = i;
					h = j;
					c = d;
					d = r;
					}
				}
			}
			n += 1;
		} 
		while (notnull == true);
		ggT = d;
	}
}

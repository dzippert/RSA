import java.io.*;

class Write
{
  private String Dateiname, Dateinamex, Datei;
  private String[] Text, Textx; 
  FileWriter writer;
  File file; 

  public Write(String Dateiname, String[] Text)
  {
    this.Dateiname = Dateiname; this.Text = Text;
    schreiben(Dateiname, Text);
  }

  private void schreiben(String Dateinamex, String[] Textx)
  {
    this.Dateinamex = Dateinamex; this.Textx = Textx;
    Datei = Dateinamex+".txt"; int i = Textx.length;
    file = new File(Datei);
    try
    {
      writer = new FileWriter(file ,true); // true, falls die Datei bereits existiert
      for(int j=0; j<i; j++)
      {
	writer.write(Textx[j]);
	if (j!=i-1)
	writer.write(System.getProperty("line.separator")); // Platformunabhängiger Zeilenumbruch wird in den Stream geschrieben
      }
      writer.flush();
      writer.close();

    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
  }
}

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class RSAgui extends Frame implements ActionListener, WindowListener, ItemListener
{
	// Deklaration der Elemente:
	String bStart_text, quellpfad, zielpfad;
	Label labTitle, labP, labQ, labC, labPQ, labQuelle, labZiel, labtxt, labtxt2, labInfo;
	TextField tfP, tfQ, tfC, tfQuelle, tfZiel, tfPQ;
	CheckboxGroup cbGroup; Checkbox cbCod, cbDecod;
	Button bStart, bReset;
	TextArea taInfo;

	Font fntTitle, fntLab, fntLabtxt, fntTF, fntAusgabe;

	public static void main(String[] args)
	{
	  RSAgui gui = new RSAgui();
	}

	public RSAgui()
	{
	  // Fenstergroesse festlegen:
	  setSize(780, 455);

	  // Definition Layout:
	  setLayout(null);

	  addWindowListener(this);

	  // Konstruktion und Verwaltung der Schriftobjekte:
	  fntTitle = new Font("SansSerif", 1, 16);
	  fntLab = new Font("SansSerif", 1, 14); fntLabtxt = new Font("Serif", 2, 14);
	  fntTF = new Font("SansSerif", 0, 14);
	  fntAusgabe = new Font("Monospaced", 0, 12);

	  // Definition der Farben:
	  //colBlau = new Color(0, 0, 255);
	  //colRot = new Color(255, 0, 0);

	  // Definition der Elemente:
	  labTitle = new Label("RSA-Verschlüsselungs-Assistent");
	  labP = new Label("P:");
	  labQ = new Label("Q:");
//	  labC = new Label("C:");
//	  labPQ = new Label("(P * Q):");
	  labQuelle = new Label("Quelldatei:");
	  labZiel = new Label("Zieldatei:");
	  labtxt = new Label(".txt");
	  labtxt2 = new Label(".txt");
	  labInfo = new Label("Info:");

	  tfP = new TextField("12347");
	  tfQ = new TextField("54331");
//	  tfC = new TextField("");
	  tfQuelle = new TextField("./daten/testdatei");
	  tfZiel = new TextField("./daten/testdatei_codiert");

	  // --> StrP = tfP.getText(); StrQ = tfQ.getText(); Integer intObj = Integer(StrP); -> int intP = intObj.intValue(); <--
//	  tfPQ = new TextField("");

	  cbGroup = new CheckboxGroup();
	  cbCod = new Checkbox("codieren", cbGroup, true);
	  cbDecod = new Checkbox("decodieren", cbGroup, false);

	  Checkbox chk = cbGroup.getSelectedCheckbox();
	  bStart_text = (chk==cbCod)? "Codieren" : "Decodieren";
	  bStart = new Button(bStart_text);
	  bReset = new Button("Reset");

	  taInfo = new TextArea();

	  // Platzierung / Dimensionierung jeder Komponente: "setBounds(int x, int y, int b, int h)"
	  labTitle.setBounds(20, 30, 350, 40);
	  labP.setBounds(20, 70, 350, 25);
	  labQ.setBounds(400, 70, 350, 25);
//	  labC.setBounds(20, 135, 350, 25);
//	  labPQ.setBounds(400, 135, 350, 25);
	  labQuelle.setBounds(20, 200, 350, 25);
	  labZiel.setBounds(400, 200, 350, 25);
	  labInfo.setBounds(20, 265, 350, 25);
	  tfP.setBounds(20, 100, 350, 25);
	  tfQ.setBounds(400, 100, 350, 25);
//	  tfC.setBounds(20, 165, 350, 25);
//	  tfPQ.setBounds(400, 165, 350, 25);
	  tfQuelle.setBounds(20, 230, 325, 25);	labtxt.setBounds(345, 230, 25, 25);
	  tfZiel.setBounds(400, 230, 325, 25);	labtxt2.setBounds(725, 230, 25, 25);
	  cbCod.setBounds(600, 285, 150, 25);
	  cbDecod.setBounds(600, 315, 150, 25);
	  bStart.setBounds(600, 350, 150, 40);
	  bReset.setBounds(600, 395, 150, 40);
	  taInfo.setBounds(20, 295, 560, 140);

	  // Hinzufuegen der Komponenten: "add(Component c)"
	  add(labTitle);	add(labP);	add(labQ);	//add(labC);
	  add(labInfo);	//add(labPQ);	
	  add(labQuelle);	add(labZiel);	add(labtxt);	add(labtxt2);
	  add(tfP);	add(tfQ);	//add(tfC);	add(tfPQ);
	  add(tfQuelle);	add(tfZiel);
	  add(cbCod);	add(cbDecod);

	  add(bStart);	add(bReset);
	  add(taInfo);

	  // Item- & Action- Listeners hinzufügen
          cbCod.addItemListener(this);
          cbDecod.addItemListener(this);

	  bStart.addActionListener(this);
	  bReset.addActionListener(this);

	  // Komponenten mit Font-Eigenschaften ausstatten: "setFont(Font f)"
	  labTitle.setFont(fntTitle);
	  labP.setFont(fntLab);
	  labQ.setFont(fntLab);
//	  labC.setFont(fntLab);
//	  labPQ.setFont(fntLab);
	  labQuelle.setFont(fntLab);	labtxt.setFont(fntLabtxt);
	  labZiel.setFont(fntLab);	labtxt2.setFont(fntLabtxt);
	  labInfo.setFont(fntLab);
	  tfP.setFont(fntTF);
	  tfQ.setFont(fntTF);
//	  tfC.setFont(fntTF);
//	  tfPQ.setFont(fntTF);
	  tfQuelle.setFont(fntTF);
	  tfZiel.setFont(fntTF);
	  cbCod.setFont(fntLab);
	  cbDecod.setFont(fntLab);
	  bStart.setFont(fntLab);
	  bReset.setFont(fntLab);
	  taInfo.setFont(fntAusgabe);

	  // Farben den Komponenten zuordnen:
	  //labText1.setForeground(colBlau);
	  //labSuche1.setForeground(colRot);
	  //labSuche2.setForeground(colRot);
	  //labSuche3.setForeground(colRot);
	  //bInfo.setBackground(colRot);
	  //bNeu.setBackground(colBlau);
	  //bVersuch.setBackground(Color.ORANGE);
	  // Fenster am Bildschirm sichtbar machen:
	
//	  tfPQ.setEditable(false);
 	  setVisible(true);
	}

	// *** Listener-Interface-Methoden:
	//     * aus ActionListener:
	public void actionPerformed(ActionEvent e)
	{
	  if (e.getSource() == bStart)
	    startClicked();
	  if (e.getSource() == bReset)
	    resetClicked();
	}
	//     * aus WindowListener
	public void windowClosing(WindowEvent e)
	{
	  dispose();
	  System.exit(0);
	}
	public void windowClosed(WindowEvent e)	{}
	public void windowOpened(WindowEvent e)	{}
	public void windowActivated(WindowEvent e)	{}
	public void windowDeactivated(WindowEvent e)	{}
	public void windowIconified(WindowEvent e)	{}
	public void windowDeiconified(WindowEvent e)	{}

        //	* aus ItemEvent
	public void itemStateChanged(ItemEvent ie) {
	  Checkbox chk = cbGroup.getSelectedCheckbox();
	  bStart_text = (chk==cbCod)? "Codieren" : "Decodieren";
	  quellpfad = (chk==cbCod)? "./daten/testdatei" : "./daten/testdatei_codiert";
	  tfQuelle.setText(quellpfad);
	  zielpfad = (chk==cbCod)? "./daten/testdatei_codiert" : "./daten/testdatei_decodiert";
	  tfZiel.setText(zielpfad);
	  bStart.setLabel(bStart_text);
	  repaint();
        }

	private void startClicked()
	{
	  String P, Q, Quelldatei, Zieldatei, CD, TA;
	  int i;
	  int[] p, q, c;

	  Checkbox chk = cbGroup.getSelectedCheckbox();
	  CD = (chk==cbCod)? "c" : "d";
	  //int lengthP, lengthQ; lengthP = P.length(); lengthQ = Q.length();
	  if(CD=="c") { 
	    P = tfP.getText(); Q = tfQ.getText();
	    HHsehrLongConvert hhslc = new HHsehrLongConvert();
	    p = hhslc.getStrInt(P);
	    q = hhslc.getStrInt(Q);
	    
	    Random randomGenerator = new Random();
	    c = new int[2];
	    c[0] = randomGenerator.nextInt(10000);
	    c[1] = randomGenerator.nextInt(10000);
	    Quelldatei = tfQuelle.getText();
	    Zieldatei = tfZiel.getText();
	  }
	  else {
	    P = tfP.getText(); Q = tfQ.getText();
	    HHsehrLongConvert hhslc = new HHsehrLongConvert();
	    p = hhslc.getStrInt(P);
	    q = hhslc.getStrInt(Q);
	    c = null;
	    Quelldatei = tfQuelle.getText();
	    Zieldatei = tfZiel.getText();
	  }
	  TA = (chk==cbCod)? "C" : "Dec";
	  taInfo.append(TA+"odieren von "+Quelldatei+".txt nach "+Zieldatei+".txt\n");
	  taInfo.append("mit P= "+P+" und Q= "+Q+"\n");
	  Manager mgr = new Manager(p, q, c, Quelldatei, Zieldatei, CD);
	  TA = (chk==cbCod)? "c" : "dec";
	  taInfo.append("Datei erfolgreich "+TA+"odiert.\n");

	}

	private void resetClicked()
	{
	  
	}
}

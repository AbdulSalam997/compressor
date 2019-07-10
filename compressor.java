import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.zip.*;
class compressor extends JFrame implements ActionListener
{
	JFrame frame= new JFrame("testing project-abdul");
	JPanel panel= new JPanel();
	JTextField t=new JTextField();
	JTextField t1=new JTextField("1:select operation"+"\n"+"2:select file and press open"+"\n"+"3:select destination and press save");
	
	JButton button1= new JButton("compress");
JButton button2= new JButton("decompres");
JButton button3= new JButton("add");
public compressor()
	{	panel.setLayout( new GridLayout(4,1));
	//button1.setSize(50,50);
	//button2.setSize(50,50);
	//t.setSize(500,200);
	//panel.add(button3);
	panel.add(t1);
	panel.add(button1);
	panel.add(button2);
	panel.add(t);
	frame.add(panel);
	frame.setResizable(false);
	frame.setSize(500,500);
	frame.setVisible(true);

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	}
public void actionPerformed(ActionEvent e) 
{	String sq=new String();
String sq1=new String();
	String s= new String(e.getActionCommand());
	if((s).equals("add"))
	{	
		JFileChooser fc=new JFileChooser();
		int ret=fc.showOpenDialog(null);
		if(ret==JFileChooser.APPROVE_OPTION)
		{ sq=fc.getSelectedFile().getAbsolutePath();
		
	}
	}

	if((s).equals("compress"))
	{//t.setText("compression started");
//compressor c=new compressor
	JFileChooser fc=new JFileChooser("choose source file");
		int ret=fc.showOpenDialog(null);
		if(ret==JFileChooser.APPROVE_OPTION)
		{ sq=fc.getSelectedFile().getAbsolutePath();
		//t.setText("file placed on desktop");
			JFileChooser fc1=new JFileChooser("choose destination directory");
			int ret1=fc1.showSaveDialog(null);
			if(ret1==JFileChooser.APPROVE_OPTION)
			{ sq1=fc1.getSelectedFile().getAbsolutePath();
			
		}
	}t.setText("file stored at"+sq1);
	  File source=new File(sq);
	  File destination=new File(sq1);
     // compressor cp=new compressor(source,destination);
	  try
	  {
		 compressor cp=new compressor(source,destination);
	  }
	  catch(IOException f)
	  {
		  System.out.println(f);
	  }
	}
	if((s).equals("decompres"))
		{//t.setText("decompression started");
	JFileChooser fc=new JFileChooser();
		int ret=fc.showOpenDialog(null);
		if(ret==JFileChooser.APPROVE_OPTION)
		{ sq=fc.getSelectedFile().getAbsolutePath();
		//t.setText("file placed on desktop");
		JFileChooser fc1=new JFileChooser("choose destination directory");
			int ret1=fc1.showSaveDialog(null);
			if(ret1==JFileChooser.APPROVE_OPTION)
			{ sq1=fc1.getSelectedFile().getAbsolutePath();
			
		}
	}t.setText("file stored at"+sq1);
	 File source=new File(sq);
	  File destination=new File(sq1);
	  try
	  {
		compressor dc=new  compressor(0,source,destination);
	  }
	  catch(IOException g)
	  {
		  System.out.println(g);
	  }
	}
	
   
} 


public static void main(String args[])
{
	compressor c=new compressor();

}



	 	
  public  compressor(File source,File destination) throws IOException
  {
	byte buffer[]= new byte[1024];
		FileInputStream fis=new FileInputStream(source);
		FileOutputStream fos=new FileOutputStream(destination);
		GZIPOutputStream gzos=new GZIPOutputStream(fos);
		int read;
		while((read=fis.read(buffer))!= -1)
		{
			gzos.write(buffer,0,read);
		}
		gzos.finish();
		gzos.close();
		fis.close();
		fos.close();
  }
   public compressor(int a,File source,File destination) throws IOException{
	byte buffer[]= new byte[1024];
		FileInputStream fis=new FileInputStream(source);
		
		GZIPInputStream gzos=new GZIPInputStream(fis);
		FileOutputStream fos=new FileOutputStream(destination);
		int read;
		while((read=gzos.read(buffer))!= -1)
		{
			fos.write(buffer,0,read);
		}
		
		gzos.close();
		fis.close();
		fos.close();
  }
}

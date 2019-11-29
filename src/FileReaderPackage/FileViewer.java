package FileReaderPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class FileViewer extends JFrame implements  ActionListener 
{
	static JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	static JTextField t,t1; 
	static Frame f;
	static JButton b,b1,b2;
	static JCheckBox c;
	FileViewer() 
	{ 
		
	} 
	public static void viewer() 
	{ 
		f  = new Frame("File Merger"); 
		f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent windowEvent){System.exit(0);}}); 
		//f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((dim.width/2-f.getSize().width/2)-250, (dim.height/2-f.getSize().height/2)-100);
		FileViewer te = new FileViewer(); 
		b  = new JButton("Merge");
		b.setPreferredSize(new Dimension(90,20));
		b.addActionListener(te);
		b1 = new JButton("Input Folder Path");
		b1.setPreferredSize(new Dimension(150, 20));
		b1.addActionListener(te);
		b2 = new JButton("Output File Path");
		b2.setPreferredSize(new Dimension(150, 20));
		b2.addActionListener(te);
		t  = new JTextField(28);
		t1 = new JTextField(28);
		//JPanel p = new JPanel(new GridLayout(7, 2, 20, 4));
		JPanel p = new JPanel(new FlowLayout());
		p.setBorder(BorderFactory.createTitledBorder("Hello Arcsight V1.0: "));
		p.add(t);
		p.add(b1);
		p.add(t1);
		p.add(b2);
		p.add(b); 
		f.add(p); 
		f.setSize(500,250); 
        f.show();
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		
		
		if (s.equals("Merge")) 
		{ 				
			
			if(t.getText().equals("")|t1.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(this,"Please Input","Warning",JOptionPane.WARNING_MESSAGE);    
			}
			else
			{
				try
				{
					MultipleFileProcessor.fileConcatenator(t1.getText(),t.getText());
					JOptionPane.showMessageDialog(this,"Done!!!!!!","Successful",JOptionPane.PLAIN_MESSAGE);
				} 
				catch (IOException e1) 
				{
					JOptionPane.showMessageDialog(this,"Invalid Input!!!","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		} 
		else if(s.equals("Input Folder Path"))
		{
		    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    chooser.setAcceptAllFileFilterUsed(false);
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			{
				File selectedFile =  chooser.getSelectedFile();
				t.setText(selectedFile.getPath());
			}
		}
		else
		{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);
			//int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) 
			{
				File selectedFile = jfc.getSelectedFile();
				t1.setText( selectedFile.getAbsolutePath());
			}
		}
	} 

}

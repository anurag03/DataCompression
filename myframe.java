/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Main Window of Compression (this file contain the code till getting binary of a file);
package miniproject;
import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.awt.event.*;//All the packages are present over here;
import java.io.IOException;

public class myframe extends JFrame implements ActionListener
       {          
                JButton compress;
                String file="",ext=null;              
                JTextField ta=new JTextField(20);
                JPanel panel2=new JPanel();
                JFrame frame2;
                public String s1;//object declaration               
public void window1()
    {
         JFrame frame1=new JFrame("Compresser");
         frame1.setVisible(true);  
         JMenuBar mbr1=new JMenuBar();
         JPanel panel1=new JPanel();
         JMenu menu1=new JMenu("File");
       
         JMenuItem compress1=new JMenuItem("Compress");
         JMenuItem decompress=new JMenuItem("Decompress");
         JMenuItem close=new JMenuItem("Close");
         JMenuItem quit=new JMenuItem("Quit");
         
         compress1.addActionListener(this);
         decompress.addActionListener(this);
         
         menu1.add(compress1);
         menu1.add(decompress);
         menu1.add(close);
         menu1.add(quit);
         
         mbr1.add(menu1);
         panel1.add(mbr1);
         frame1.add(panel1);
         frame1.setSize(350,250);
         frame1.setLocation(500,300);  
         frame1.setDefaultCloseOperation(3);
         
        
    }//this code is for the main window display feature;
     
                @Override
    public void actionPerformed(ActionEvent e)
    {
        String bvalue;
       
        bvalue=e.getActionCommand();   
                    switch (bvalue) {
                        case "Browse":
                            JFrame d=new JFrame ();
                            JFileChooser chooser = new JFileChooser();
                            chooser.showOpenDialog(null);
                            File file1 = chooser.getSelectedFile();
                            String filename = file1.getName();
                            ext=filename.substring(filename.lastIndexOf(".") + 1, filename.length());
                            System.out.println(""+ext);
                            System.out.println("You have selected: " + filename);
                            s1=file1.getAbsolutePath();
                            FileGet fg=new FileGet();
        try {
            fg.selectedFile(s1);
        } catch (IOException ex) {
            System.out.println("file not found"+ex);
        }
                            window2();
                            break;
                        case "Compress":
                            window2();
                            break;
                        case "Decompress":
                            break;
                        case "Close":
                            window1();
                            break;
                        case "Quit":
                            break;
                    }
    }//OPEN'S THE DIALOG BOX;

    public void window2()
    {
        frame2=new JFrame();
       
        JButton cancel=new JButton("Cancel");
        
        JButton browse=new JButton("Browse");
        browse.addActionListener(this);
        compress=new JButton(""+ext);        
        panel2.add(ta);
        panel2.add(browse);
         
        panel2.add(compress);
        panel2.add(cancel);
        if(ext == null)
        compress.setVisible(false);
        else
        {
            
            compress.setVisible(true);
        }
        frame2.add(panel2);
        frame2.setSize(350,250);
        frame2.setLocation(500,300);  
        frame2.setDefaultCloseOperation(3);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(3);
        //BUTTON
        panel2.setLayout(new GridLayout(2,2));
        
    }//this code is for the compress window;
    
        }
class Miniproject//Class that Contain the main function;
{

    public static void main(String[] args) 
    {    
    myframe f=new myframe();
    f.window1();
    }//main function;  
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miniproject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author gunner
 */
public class BitWork {
    public void byteToBit(String s2) throws FileNotFoundException, IOException
    {
         FileInputStream fileInputStream = null;  
         FileOutputStream fileOutputStream = null; 
         File file1=new File(s2);  
         fileInputStream = new FileInputStream(s2);
         fileOutputStream= new FileOutputStream("actdata2.txt");
         byte b[];
         b=new byte[(int)file1.length()];
         fileInputStream.read(b);
         byte b1=(byte)0;
         int j=0;
         for(int i=0;i<file1.length();i++)
            {       
                 j++;      
                 b1=(byte)(b1<<1);
                 if(b[i]!=0)
                     {
                        b1=(byte)(b1+1);           
                     }
                  if(j==7)
                    {
                        fileOutputStream.write(b1);
                        //System.out.print(" "+b1);
                        j=0;
                        b1=(byte)0;
                     }
             }  
          fileOutputStream.close();
          Compress c2=new Compress();
          String s3="C:\\Users\\gunner\\Documents\\NetBeansProjects\\Miniproject\\actdata2.txt";
          c2.data2comp();
    }//function which converts binary data into bit.      
    }
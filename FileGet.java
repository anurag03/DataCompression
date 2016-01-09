/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;
/**
 *
 * @author gunner
 */

public class FileGet
{
    public void selectedFile(String s1) throws IOException 
    {  
      FileInputStream fileInputStream = null;
      FileOutputStream fileOutputStream = null;  
      FileOutputStream fos = null; 
      FileOutputStream fos1 = null;

      try {  
       int data;  
       fileInputStream = new FileInputStream(s1);
       
       fileOutputStream = new FileOutputStream("current.txt");//original file .
       fos = new FileOutputStream("data1.txt");//data1 table of j-bit encoding.
       fos1 = new FileOutputStream("data2.txt");//binary table of j-bit encoding.    
       int count=0;
       while ((data = fileInputStream.read()) != -1) { 
           if (data!=0)
           {
               byte i=1;               
               fos1.write(i);
               fos.write(data);
               fileOutputStream.write(data);
               //System.out.print(" "+data);
               if(data==1)
               {
                 count++; 
               }
           }
        else
           {
               byte i=0;
               fos1.write(i);
               fileOutputStream.write(data);
           }
         
       }
       System.out.println(" " +count);
       fos1.close();
       fos.close();
       fileOutputStream.close();
       BitWork bw=new BitWork();
       String s2="C:\\Users\\gunner\\Documents\\NetBeansProjects\\Miniproject\\data2.txt";
       bw.byteToBit(s2);//function will convert the binary to bit.
      }    
            catch (FileNotFoundException e) {  
            } 
        finally {  
             if (fileInputStream != null)  
                fileInputStream.close();  
             if (fileOutputStream != null)  
                fileOutputStream.close();  
    
      }  
    }//code for writing the file in binary form.      
}
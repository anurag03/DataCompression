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
public class Compress {

public void data2comp() throws FileNotFoundException, IOException
{
    FileInputStream getdata2=null;
    FileOutputStream putdata2=null;
    File flen=new File("C:\\Users\\gunner\\Documents\\NetBeansProjects\\Miniproject\\actdata2.txt");
    getdata2=new FileInputStream("C:\\Users\\gunner\\Documents\\NetBeansProjects\\Miniproject\\actdata2.txt");
    putdata2=new FileOutputStream("C:\\Users\\gunner\\Documents\\NetBeansProjects\\Miniproject\\cmp2.txt");
    byte[] myb= new byte[(int)(flen.length()+5)];
    byte bb1=0;
    byte bb2=(byte)64;
    int count=0;
    getdata2.read(myb);
    for(int q=0;q<(int)flen.length();q++) {
        if(myb[q]==(byte)127)
        {
            while((int)myb[q]==127)
            {
              count++;
              q++;
            }
            q--;
            bb2=(byte)(count+bb2);
            count=0;
            putdata2.write(bb2);
            bb2=(byte)64;
        }
        else if(myb[q]==(byte)0)
        {
            while((int)myb[q]==0)
            {
                count++;
                q++;
            }
            q--;
            bb1=(byte)(count+bb1);
            count=0;
            putdata2.write(bb1);
            bb1=(byte)0;
        }
        else 
        {
            putdata2.write(myb[q]);
        }
    }putdata2.close();
    System.out.println("task complete");
}
}
    


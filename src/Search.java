/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wei0000
 */
import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
//import org.apache.commons.io.FileUtils;


public class Search {
    public static String userDir = System.getProperty("user.dir");
    public static String[] special = {"","\u200B","\u200C","\u200D","\u200E","\u00AD","\uFB06","\u2060","\uFEFF","\u2061",
                                      "\u115F","\uFE00","\uFE01","\uFE02","\uFE03","\uFE04","\uFE05","\uFE06","\uFE07",
                                      "\uFE08","\uFE09","\uFE0A","\uFE0B","\uFE0C","\uFE0D","\uFE0E","\uFE0F"};
    
    public static void readFile(String filename){
        
        try{
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            boolean found = false;
            int count = 0;
            int index = 0;
            int LineNum = 1;
            String strLine = "";
            while((strLine = br.readLine()) != null){
                //System.out.println(strLine);
                
                for(int i=0;i<strLine.length();i++){
                    
                    strLine.charAt(i);
                    //Integer.toHexString('' | 0x10000).substring(1)
                    String hex =  Integer.toHexString(strLine.charAt(i) | 0x10000).substring(1);
                }
                
//                int tempIndex = 0;
//                 
//                     for(int j=0; j<special.length; j++){
//                     if(strLine.contains(special[j])){
//                         found = true;
//                         int StrOcc = StringUtils.countMatches(strLine, special[j]);
//                         
//                         for(int i=0; i<StrOcc; i++){
//                             
//                         index = strLine.indexOf(special[j]);
//                         //System.out.println(index);
//                         tempIndex = index + tempIndex;
//                         log("In Line " + LineNum + " and string index of "+ tempIndex +", we find a hidden character: " + 
//                                 strLine.substring(index,index+1) + "\n");
//                         System.out.println("In Line " + LineNum + " and string index of "+ tempIndex +", we find a hidden character: " + 
//                                 strLine.substring(index,index+1));
//                         strLine = strLine.substring(tempIndex+1);
//                          
//                           }
//                         }
//                     }
//                        
//                LineNum++;
//                index = 0;
             }
            //System.out.println();
            if(!found){
                log("Luckily, we could not find any special character in the file");
               System.out.println("Luckily, we could not find any special character in the file");
            }
            else {
                log("As reported above, there are some special hidden character in the file");
                System.out.println("As reported above, there are some special hidden character in the file");
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        JOptionPane.showMessageDialog(null,"The file has been checked successsfully! Please open the log file to check the result");
    }
    
      public static synchronized void log(String msg){
          
        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(new FileOutputStream(userDir + "\\log.txt", true));
            dos.writeBytes(msg + System.getProperty("line.separator"));
            dos.close();
        } catch (FileNotFoundException ex){
         
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    
    
    public static void test() throws UnsupportedEncodingException, IOException{
        // FFC2 9A
        // FFC4 B7
        System.out.println( "\\u" + Integer.toHexString('÷' | 0x10000).substring(1) );
        String string1 = "ķ";
        String string2 = "ņa";
        int i = (int)string2.charAt(0);
        System.out.println(i);
        System.out.println("***"+Integer.parseInt(Integer.toHexString(i)));
        
        System.out.println("\\u" + Integer.toHexString('' | 0x10000).substring(1));
        System.out.println("\\u" + Integer.toHexString('ņ' | 0x10000).substring(1));
        StringReader reader = new StringReader(string1);
        int singleChar = reader.read();
        System.out.println(singleChar);
        char c = '';
        System.out.println("Code: " + (int)c + " Character: " + c);
        String str1 = "";
        //String str1 = "";
        byte[] b = str1.getBytes("UTF-8");
        System.out.println(Arrays.toString(b));
        String str2 = "你";
        byte[] b2 = str2.getBytes("UTF-8");
        System.out.println(Arrays.toString(b2));
        byte[] b1 = {(byte) -62 , (byte) -102, (byte) -60, (byte) -73};
        String s = new String(b1, "UTF-8");
        System.out.println(s);
    }
    
    
    public static void main(String args[]) throws Exception{
        //String testFile = "C:\\Users\\wei0000\\Desktop\\sample.html.erb";
        //System.out.println(userDir);
        //readFile(testFile);  
      test();
    }
    
}

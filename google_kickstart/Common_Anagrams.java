/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google_kickstart;

/**
 *
 * @author Tulupov Sergei
 */

import java.io.*;
import java.util.*;

public class Common_Anagrams{

 private static boolean find(String C,String B){
 String D;
 char [] str2=C.toCharArray();
 Arrays.sort(str2);
 C=String.valueOf(str2);
       for(int j=0;j<B.length()-C.length()+1;j++){
            D=B.substring(j,j+C.length());
      char[] str1 = D.toCharArray();
  Arrays.sort(str1);
  D=String.valueOf(str1);
         if(D.equals(C)){ //System.out.println(D+" "+C);
            return true;}
         }
   return false;}   
    
  private static int solve(String A,String B){
 // Arrays.sort(A);
 String C;
   int count=0;
 for(int i=1;i<A.length()+1;i++){
     for(int j=0;j<A.length()-i+1;j++){
     C=A.substring(j,j+i);
 if(find(C,B)){//System.out.println(C+" "+B);
 count++;};
     //System.out.println(C);
     }
  }
  return count;
  }
    
  public static void main(String[] args) throws FileNotFoundException,
            IOException{
     File file = new File("A-large.in");
               Scanner scanner = new Scanner(file);
     FileWriter writer = new FileWriter("result.out", false); 
    
int T=0;
int L=0;
if(scanner.hasNextLine()){
            T = scanner.nextInt();
            }
scanner.nextLine();
int count =0;
while(scanner.hasNextLine()){
    String A,B;
    count++;      
    L=scanner.nextInt();
    scanner.nextLine();
    if(count>T){break;}
    A=scanner.nextLine().trim();
    B=scanner.nextLine().trim();
   // System.out.println(A);
 System.out.println(solve(A,B));
 
writer.write("Case #"+count+": "+solve(A,B)+"\n");
writer.flush();
   
  
}
 scanner.close();

    }    
}

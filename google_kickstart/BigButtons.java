package google_kickstart;

/**
 *
 * @author SirGate
 */

import java.io.*;
import java.util.*;


public class BigButtons {

private static long result=0;

private static void solution(String[]forbid,int N){
long res1=0;
result=(long)Math.pow(2,N);

for(int i=0;i<forbid.length-1;i++){
   if(forbid[i]!=""){
    for(int j=i+1;j<forbid.length;j++){
     if((forbid[j]!="")&forbid[j].startsWith(forbid[i]))
           {forbid[j]="";}
                                      }
        }
                                   }
for(String str:forbid){
    if(str!=""){res1=(long)Math.pow(2,N-str.length());result-=res1;}
                       }
}
public static void main(String[] args) throws FileNotFoundException,
            IOException{
     File file = new File("A-large-practice.in");
               Scanner scanner = new Scanner(file);
     FileWriter writer = new FileWriter("result.out", false); 
int T=0;    
if(scanner.hasNextLine()){
            T = scanner.nextInt();
           }
for(int k=1;k<T+1;k++){
int N=scanner.nextInt();
int P=scanner.nextInt();
    scanner.nextLine();

String[]forbid= new String[P];
int j=0;
for(int s=1;s<P+1;s++){
String A=scanner.nextLine().trim();
forbid[j++]=A;

}
Arrays.sort(forbid);
solution(forbid,N);

System.out.println(k+" "+result);
writer.write("Case #"+k+": "+result+"\n");
writer.flush();
result=0;
}
 scanner.close();
    }            
}

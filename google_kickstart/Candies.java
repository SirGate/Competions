/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google_kickstart;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
/**
 *
 * @author SirGate
 */
public class Candies {
    static int O;
    static long D;
    static long []S;
    
static boolean b=false;
private static long calculate(long s[]){
long max=0;
int odd=0;
long res=0;
int j=0;
long prev=0;
int prev1=0;
long summ=0;
long [] sum= new long[s.length];
TreeMap<Long,Integer> sums = new TreeMap<Long,Integer>();
for(int i=0;i<s.length;i++){
   while(j<s.length){
    if((s[j]%2!=0)&(odd==O)){break;} 
    if(s[j]%2!=0){odd++;}
  summ=summ+s[j];  
    if(sums.get(summ)!=null){
            int k=sums.get(summ);k++;sums.put(summ,k);
                     }else{sums.put(summ,1);}
    
     j++;                }
 
 if(sums.floorKey(D+prev)!=null){res=sums.floorKey(D+prev);}
 //if(sums.get(summ[prev1])!=null)
 {
 //    int k=sums.get(summ[prev1]);
     //if(k>1){k--;sums.put(summ[prev1],k);}
    // else{sums.remove(summ[prev1]);}              
                   }
  prev1=i;
// prev=summ[i];
 if(max<res){max=res;}
 if(s[i]%2!=0){odd--;}
 }
return max;
}  
          public static void main(String[] args) throws FileNotFoundException,
            IOException{
     File file = new File("A-small-practice.in");
               Scanner scanner = new Scanner(file);
     FileWriter writer = new FileWriter("result.out", false); 
     
int T=0;
if(scanner.hasNextLine()){
            T = scanner.nextInt();
            }
int count =0;
while(scanner.hasNextLine()){
    count++;      
    if(count>T){break;}
    int N = scanner.nextInt();
           O = scanner.nextInt();
           D = scanner.nextLong();
long[] X=new long[N];
S=new long[N];

X[0]=scanner.nextLong();   
X[1]=scanner.nextLong();
int A=scanner.nextInt();   
int B=scanner.nextInt();
int C=scanner.nextInt();   
int M=scanner.nextInt();
int L=scanner.nextInt(); 

 long result; 

for(int i=0;i<N;i++){
  if(i>1){ X[i]=((A*X[i-1]+B*X[i-2]+C)%M);}
                    S[i]=X[i]+L;       
              
}

result=calculate(S);
System.out.println(result);
break;

}
 scanner.close();

    }
    
    
}

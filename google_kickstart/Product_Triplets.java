package google_kickstart;

/**
 *
 * @author SirGate
 */
import java.io.*;
import java.util.*;

public class Product_Triplets {
    
public static HashMap<Integer,Integer>numb;

private static long solution (int[] arr,HashMap<Integer,Integer>nmb,int zero){
    long count=0;
    int c=0;
    long nn=0;
for(int i=arr.length-2;i>0;i--){
    if(nmb.get(arr[i+1])!=null){c=nmb.get(arr[i+1]);c++;nmb.put(arr[i+1],c);}
    else{nmb.put(arr[i+1],1);}
   for(int j=i-1;j>-1;j--){
       nn=(long)arr[i]*(long)arr[j];
       if(nn<200001){
           if(nmb.get(arr[i]*arr[j])!=null){count+=(long)nmb.get(arr[i]*arr[j]);}}
                                 }
}
return count;}
public static long fact(int a,int b){
long count=1;
long count1=1;

    for(long i=a-b+1;i<a+1;i++){count*=i;}
    for(long i=1;i<b+1;i++){count1*=i;}
    count=(long)(count/count1);
return count;}
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
int[]arr=new int[N];
int count1=0;
for(int m=0;m<N;m++){arr[m-count1]=scanner.nextInt();
if(arr[m-count1]==0){count1++;}
}
int []arr1=new int[N-count1];
for(int m=0;m<arr1.length;m++){arr1[m]=arr[m];
}
Arrays.sort(arr1);
numb=new HashMap<Integer,Integer>();
long result=fact(count1,3)+fact(count1,2)*(N-count1);
result+=(long)solution(arr1,numb,count1);
 //System.out.println(k+" "+result);
writer.write("Case #"+k+": "+result+"\n");
writer.flush();

}



 scanner.close();
    }            
}

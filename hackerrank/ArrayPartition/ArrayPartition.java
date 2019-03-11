import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.StringTokenizer;

public class ArrayPartition{
static StringTokenizer st;
static int [] primes = new int[78498];
static HashMap<Integer,Integer> numbs;
static int[] parents;    
static int count=0;

static void solve(int max) {
   
int i=0;
boolean b=true;
HashMap<Integer,Integer> childs;
    
while(primes[i]<=max){
    childs= new HashMap();  
    b=true;
for(int j=1;primes[i]*j<=max;j++){
    if(numbs.get(primes[i]*j)!=null){
           if(numbs.get(primes[i]*j)==-1){
               numbs.put(primes[i]*j,i);
               if(b){parents[i]=-1;b=false;}                        
                                       }
           else if((numbs.get(primes[i]*j)>-1)&(childs.get(numbs.get(primes[i]*j))==null)){
             if(b){parents[i]=-1;b=false;}
               if(parents[numbs.get(primes[i]*j)]==-1){
                   parents[numbs.get(primes[i]*j)]=i;
                   childs.put(numbs.get(primes[i]*j),0);              
               }
               if(parents[numbs.get(primes[i]*j)]>-1){
                 int next=-2;
            
                   next=parents[numbs.get(primes[i]*j)];
                   childs.put(numbs.get(primes[i]*j),0);              
                   parents[numbs.get(primes[i]*j)]=i;
                    boolean bb=true;
                   while(bb){
                   if(next==i){break;}
                   childs.put(next,0);              
                   int next2=parents[next];
                   parents[next]=i;
                   next=next2;          
                   if(next==-1){break;}    
                                       }
               }
                                                   }
                                     }
                                  }
    i++;
if(i>78497){break;}    
}
 i=0; 
while(primes[i]<=max){
     if(parents[i]==-1){count++;}
     i++;
    if(i>78497){break;}   
 }   
     }
    
static void calculate() {
int [] numbers = new int[500000];  
    numbers[0]=2; 
       int j=1;
       for(int i=3;i<1000000;i=i+2){
           numbers[j++]=i;
            }
    
int numb = 3;
int index2 = 1;       
 int index1;      
       while(numb*numb<1000000){index1=((numb*numb-3)/2)+1;
              for(int i=index1;i<500000;i+=numb){numbers[i]=0;}
                                index2++;
                 while(numbers[index2]==0){index2++;}
                 numb=numbers[index2];              
                         }
       j=0;
     for(int i=0;i<numbers.length;i++){
           if(numbers[i]>0){
         primes[j]=numbers[i];
                 j++;}
                                      };
}

    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                
        int t = Integer.parseInt(bufferedReader.readLine().trim());
       calculate();
        for (int i=0;i<t;i++){
                int aCount = Integer.parseInt(bufferedReader.readLine().trim()); 
                st = new StringTokenizer(bufferedReader.readLine());
        int j=0;
        int numb=0; 
        int max=0;
        numbs=new HashMap();    
            while(st.hasMoreTokens()){
              numb=Integer.parseInt(st.nextToken());
     if(numb==1){count++;}else{
                       numbs.put(numb,-1);
                       max=Math.max(max,numb);
                       j++;
                               }
          }
                parents= new int[78498]; 
                Arrays.fill(parents,-2);
                          solve(max);
            BigInteger n1= new BigInteger("2");
            BigInteger n2; 
            n1=n1.pow((int)count);
            n1=n1.subtract(BigInteger.valueOf(2));
            n2=n1.divide(BigInteger.valueOf(1000000007));
            n2=n2.multiply(BigInteger.valueOf(1000000007));
            n1=n1.subtract(n2);
            count=n1.intValue();
            System.out.println(count);
                 count=0;
        }
        bufferedReader.close();
    }
}

package google_kickstart;
/**
 *
 * @author Tulupov Sergei
 */
import java.io.*;
import java.util.*;

public class Speciializing_villages {

private static int[][]ways;
private static int[][]ways1;
private static int[][]dist;

static int result1=1900000000;
static int result2=0;
static int counts=0;
static int counts2=0;


public static void calculate_Deikstra(int[][]ways,int curr,int length){
int min1=100001;                                                                 
int min2=0;
ways[0][curr]=0;
 for(int i=1;i<length+1;i++){
     if(ways[curr][i]<100001){
         if(ways[i][0]>ways[curr][0]+ways[curr][i])
         {ways[i][0]=ways[curr][0]+ways[curr][i];}
         ways[curr][i]=100001;ways[i][curr]=100001;
             }
 }
 for(int i=0;i<length+1;i++){
     if((min1>ways[i][0])&(ways[0][i]!=0)){min1=ways[i][0];min2=i;}}
 if(min2>0){calculate_Deikstra(ways,min2,length);min2=0;min1=100001;}
}
public static int calculate(int []current){
int min=100001;
int way=0;
    for(int i=1;i<current.length;i++){
    for(int j=1;j<current.length;j++){
        if((i!=j)&(current[i]!=current[j])){
        if(min>dist[i][j]){min=dist[i][j];}                                             
        }
                                     }
    if(min==100001){return -1;}else{way+=min;min=100001;}
    };


return way;}

public static void solution(int numb,int[]current){
int res1=0;
for(int i=0;i<2;i++){
      current[numb]=i;
if(numb==current.length-1){
    res1=calculate(current);
       if(res1>=0){if (res1<result1){result1=res1;result2=1;}
       else if(res1==result1){result2++;};
                 }
       res1=0;
           }else{
solution(numb+1,current);
                }
current[numb]=0;
}
}

public static void main(String[] args) throws FileNotFoundException,
            IOException{
     File file = new File("B-large-practice.in");
               Scanner scanner = new Scanner(file);
     FileWriter writer = new FileWriter("result.out", false); 
    
int T=0;
int V=0;
int E=0;
if(scanner.hasNextLine()){
            T = scanner.nextInt();
            
}
//scanner.nextLine();

int count =0;

while(scanner.hasNextLine()){
    count++;      
    V = scanner.nextInt();
    E = scanner.nextInt();
    ways= new int[V+1][V+1];
    ways1=new int[V+1][V+1];
    dist=new int[V+1][V+1];
   for(int i=0;i<V+1;i++){
   for(int j=0;j<V+1;j++){ways[i][j]=100001;}
   }
for(int i=0;i<V+1;i++){
   for(int j=0;j<V+1;j++){dist[i][j]=100001;}
   }
for(int i=1;i<E+1;i++){
    int Ai=scanner.nextInt();
    int Bi=scanner.nextInt();
    int Li=scanner.nextInt();
    ways[Ai][Bi]=Li;
    ways[Bi][Ai]=Li;
 }
for(int j=1;j<V+1;j++){
for(int i=0;i<V+1;i++){
   for(int k=0;k<V+1;k++){ways1[i][k]=ways[i][k];}
   }    
ways1[j][0]=0;
calculate_Deikstra(ways1,j,V);
for(int i=1;i<V+1;i++){dist[j][i]=ways1[i][0];//System.out.print(dist[j][i]+" ");
}
//System.out.println();
}
 int[]curr=new int[V+1];
solution(1,curr);
System.out.println(count+" "+result2);
//writer.write("Case #"+count+": "+result2+"\n");
//writer.flush();
result1=1900000000;
result2=0;
 if(count>=T){break;}
}
 scanner.close();
    }        
}

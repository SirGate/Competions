import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TimeSavingAffair{
    
private static HashMap<Integer,HashMap<Integer,Integer>>junction=
new HashMap<Integer,HashMap<Integer,Integer>>();
private static TreeMap<Long,ArrayList<Integer>>points=
new TreeMap<Long,ArrayList<Integer>>();
private static HashMap<Integer,Long>estimate=new HashMap<Integer,Long>(); 
private static long best=0; 
   
private static void leastTimeToInterview(int k,int n) {
  int it=0;   
  long ittime=0;  
  long time=0;
  int next=0;  
  long prev=0;
  boolean b=true;
  while(b){
      if(points.get(points.firstKey()).contains(n))
     {it=n;}
      else{it=points.get(points.firstKey()).get(0);}
               ittime=points.firstKey();
      if(it==n){best=ittime;break;}  
                          points.get(ittime).remove(points.get(ittime).indexOf(it));
      if(points.get(ittime).size()==0){points.remove(ittime);}
         if(junction.get(it)!=null){
		 for(Map.Entry<Integer,Integer> entry : junction.get(it).entrySet()){
                              next=entry.getKey();
                              time=entry.getValue();
                             junction.get(entry.getKey()).remove(it);
 time=time+ittime;  
  if(next!=n){if(((long)(time/k))%2!=0){if(time%k==0){time+=k;}
  else if(time%k!=0){time=((long)(time/k))*k+k;}}}
if(estimate.get(next)!=null){if(time<estimate.get(next)){prev=estimate.get(next);
                                           estimate.remove(next);
                                           estimate.put(next,time);
  if(points.get(time)!=null){points.get(prev).remove(points.get(prev).indexOf(next));
                          if(points.get(prev).size()==0){points.remove(prev);}             
                                         points.get(time).add(next);
                               }
                                else if(points.get(time)==null){
                          points.get(prev).remove(points.get(prev).indexOf(next));
                          if(points.get(prev).size()==0){points.remove(prev);}             
                          points.put(time,new ArrayList<Integer>());
                          points.get(time).add(next);
                                } 
                                                        }
                               } else if(estimate.get(next)==null){estimate.put(next,time);
                                        if(points.get(time)!=null){points.get(time).add(next);
                              }
                                       else if(points.get(time)==null){
                                       points.put(time,new ArrayList<Integer>());
                                       points.get(time).add(next);
                            
                                                                              } 
                                                                              }    
                 next=0;prev=0;time=0;}  }
              junction.remove(it);
      estimate.remove(it);
      it=0;ittime=0;        
 }  
}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
         for(int i =1;i<n+1;i++){junction.put(i,new HashMap<Integer,Integer>());}
        

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < m; i++) {
        String[] str = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int j1 = Integer.parseInt(str[0]);
            int j2 = Integer.parseInt(str[1]); 
            int j3 = Integer.parseInt(str[2]);
               if(j1!=j2){
       if(junction.get(j1).containsKey(j2)){if(junction.get(j1).get(j2)>j3){ 
                  junction.get(j1).remove(j2);
                  junction.get(j2).remove(j1);
                  junction.get(j1).put(j2,j3);
                  junction.get(j2).put(j1,j3);
       }}else{   junction.get(j1).put(j2,j3);
                  junction.get(j2).put(j1,j3);}
                          }     
                                  }
        points.put(0L,new ArrayList<Integer>());
        points.get(0L).add(1);
        estimate.put(1,0L);
        leastTimeToInterview(k,n);
        bufferedWriter.write(String.valueOf(best));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    
}
}
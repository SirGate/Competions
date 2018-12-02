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

class SavetheQueen {

    private static double resolve(Integer []guards,double sum){
        
        for(int i=0;i<guards.length;i++){
        if(i==guards.length-1){sum=sum/guards.length+(double)guards[i];
                              return sum;
                              }
        if((guards[i+1]-guards[i])*(i+1)>=sum){sum=sum/(i+1)+(double)guards[i];
                                              return sum;
                                              }
            else{sum=sum-(guards[i+1]-guards[i])*(i+1);}
                                        }
        
   return 0; }

    public static void solve(int n, List<Integer> a) {
    double sum=0;    
Integer [] warr;
Integer [] guards=new Integer[n];        
        warr=a.toArray(new Integer[a.size()]);
        Arrays.sort(warr);
        System.arraycopy(warr,warr.length-n,guards,0,n);
    for(int i=0;i<warr.length-n;i++){sum+=(double)warr[i];}
        sum=resolve(guards,sum);
        System.out.println(sum);
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.solve(n, a);

        bufferedReader.close();
    }
}

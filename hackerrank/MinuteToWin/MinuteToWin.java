import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinuteToWin{

    static int minuteToWinIt(long[] a, int k) {
        // Return the minimum amount of time in minutes.
        int j=0;
        int j1=0;
        int j2=0;
        int j3=0;
        int j4=0;
        int j5=0;
long [] b = new long[a.length];
for(int i=0;i<a.length;i++){b[i]=a[i];}
  
        if(a.length==2){if(a[1]-a[0]==k){return 0;}else{return 1;}}
    if(k==0){for(int i=1;i<b.length;i++){if(b[i]!=b[0]){j++;}}return j;}
  
            for(int i=1;i<b.length;i++){if(b[i]-b[i-1]!=k){b[i-1]=b[i]-k;j=j+1;}}
     for(int i=0;i<a.length;i++){b[i]=a[i];}
        for(int i=1;i<b.length;i++){
            if((b[b.length-i]-b[b.length-i-1]!=k)&(i==1)){b[b.length-i]=b[b.length-i-1]+k;j1=j1+1;}
      if((b[b.length-i]-b[b.length-i-1]!=k)&(i!=1)){b[b.length-i-1]=b[b.length-i]-k;j1++;}  }                             
          if(j>j1){j=j1;}    
            for(int i=0;i<a.length;i++){b[i]=a[i];}
        for(int i=1;i<b.length;i++){
            if((b[b.length-i]-b[b.length-i-1]!=k)){b[b.length-i-1]=b[b.length-i]-k;j2++;}
                             }
        if(j>j2){j=j2;}   
        for(int i=0;i<a.length;i++){b[i]=a[i];}
            for(int i=1;i<b.length;i++){if(b[i]-b[i-1]!=k){b[i]=b[i-1]+k;j3++;}}
        if(j>j3){j=j3;} 

        for(int i=0;i<a.length;i++){b[i]=a[i];}
        for(int i=1;i<b.length;i++){
            if((b[b.length-i]-b[b.length-i-1]!=k)){b[b.length-i]=b[b.length-i-1]+k;j4++;}
                       }
        if(j>j4){j=j4;} 

        for(int i=0;i<a.length;i++){b[i]=a[i];}
            for(int i=1;i<b.length;i++){if((b[i]-b[i-1]!=k)&(i==1)){b[i-1]=b[i]-k;j5++;}
                                       if((b[i]-b[i-1]!=k)&(i!=1)){b[i]=b[i-1]+k;j5++;}
                                       }
        if(j>j5){j=j5;} 

        return(j);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        long[] a = new long[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long aItem = Long.parseLong(aItems[i]);
            a[i] = aItem;
        }

        int result = minuteToWinIt(a, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
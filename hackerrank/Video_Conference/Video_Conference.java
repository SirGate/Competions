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

class  Video_Conference{

   
    public static List<String> solve(List<String> names) {
        int k=0;
        boolean b=false;
        List<String>result=new ArrayList<String>();  
        HashMap<String,Integer>result2 = new HashMap<String,Integer>();
        Map<String,Integer>names2 = new HashMap<String,Integer>();
        HashMap<String,Integer>parts = new HashMap<String,Integer>();
        for(int i=0;i<names.size();i++){
     String str = names.get(i);
      if(names2.containsKey(str))
      {k=names2.get(str)+1;
     names2.remove(str);
       names2.put(str,k);
      str=str+" "+k;
       result.add(str);
       result2.put(str,0);
      }else{b=false;
            names2.put(str,1);
          char[]str1= str.toCharArray();
String st="";          
     for(int j=0;j<str1.length;j++)
          {st=st+str1[j];
           if(!(result2.containsKey(st))&!(parts.containsKey(st))&(b==false)){
               result.add(st);
               result2.put(st,0);
               b=true;} 
           parts.put(st,0);
          }       
           if(b==false){result2.put(st,0);result.add(str);}         
           }
            
   }
    return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> res = Video_Conference.solve(names);

        bufferedWriter.write(
            res.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

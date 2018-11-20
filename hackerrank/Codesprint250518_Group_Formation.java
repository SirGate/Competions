
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
  static private TreeSet<String> grade1 =new TreeSet<String>();   
  static private TreeSet<String> grade2 =new TreeSet<String>();   
  static private TreeSet<String> grade3 =new TreeSet<String>();   
    
  static private ArrayList<ArrayList<String>> groups =new ArrayList<ArrayList<String>>();   
 
  static private ArrayList<String> requests =new ArrayList<String>();  
  static private  TreeSet<String> res = new TreeSet<String>();

    static void membersInTheLargestGroups(int n, int m, int a, int b, int f, int s, int t) {
   int where1 =0;
   int where2 =0;
    

       A: for(int i=0;i<m;i++){String[] req = requests.get(i).split(" ");
    where1 =0;
    where2 =0;
   
     if(grade1.contains(req[0])){where1=1;}                       
     if(grade2.contains(req[0])){where1=2;}                       
     if(grade3.contains(req[0])){where1=3;}                       
     if(grade1.contains(req[1])){where2=1;}                       
     if(grade2.contains(req[1])){where2=2;}                       
     if(grade3.contains(req[1])){where2=3;}                       

            if((where1>0)&(where1<4)&(where2>0)&(where2<4)){//if both in grades
               
                ArrayList<String> row = new ArrayList<String>(6);
                row.add("0");row.add("0");row.add("0");row.add("0");
                if(where1!=where2){row.set(where1,"1");
                                   row.set(where2,"1");}
                if(where1==where2){row.set(where1,"2");}
                   
                    if(where1==1){grade1.remove(req[0]);}
                    if(where1==2){grade2.remove(req[0]);}
                    if(where1==3){grade3.remove(req[0]);}
                    if(where2==1){grade1.remove(req[1]);}
                    if(where2==2){grade2.remove(req[1]);}
                    if(where2==3){grade3.remove(req[1]);}
               
                row.add(req[0]);row.add(req[1]); 
               groups.add(row);     
                }
                if((where1==0)&(where2==0)){ //both in groups                                                   
             ArrayList<String> st1 =new ArrayList<String>();   
             ArrayList<String> st2 =new ArrayList<String>();

                    for(ArrayList<String>st3:groups){
                        if(st3.contains(req[0])&(st3.contains(req[1]))){continue A;}
                        if(st3.contains(req[0])){st1=st3;}
                         if(st3.contains(req[1])){st2=st3;}} 
                  if((st1.size()+st2.size()-8<=b)){
                                              int f1 = Integer.parseInt(st1.get(1));
                                              int s1 = Integer.parseInt(st1.get(2));
                                              int t1 = Integer.parseInt(st1.get(3));
                                              int f2 = Integer.parseInt(st2.get(1));
                                              int s2 = Integer.parseInt(st2.get(2));
                                              int t2 = Integer.parseInt(st2.get(3));
                                     
              if((f1+f2<=f)&(s1+s2<=s)&(t1+t2<=t)){
                
                        groups.get(groups.indexOf(st1)).set(1,String.valueOf(f1+f2));  
                                                   groups.get(groups.indexOf(st1)).set(2,String.valueOf(s1+s2));
                                                   groups.get(groups.indexOf(st1)).set(3,String.valueOf(t1+t2));
                  st2.remove(0);st2.remove(0);st2.remove(0);st2.remove(0);
                                                   groups.get(groups.indexOf(st1)).addAll(st2);
                                               groups.remove(groups.indexOf(st2));
                                               continue A; 
                                                  }else{continue A;}                                 
                                              }else{continue A;}  
                }     
 if((where1==0)&(where2>0)&(where2<4)){//one in groups, one in grades
                                                   
                    ArrayList<String> st1 =new ArrayList<String>();     
                  for(ArrayList<String>st3:groups){if(st3.contains(req[0])){st1=st3;}}
                                         if(st1.size()-3<=b){
                                              int f1 = Integer.parseInt(st1.get(1));
                                              int s1 = Integer.parseInt(st1.get(2));
                                              int t1 = Integer.parseInt(st1.get(3));
                                             
                            if(where2==1){if(f1+1<=f){st1.set(1,String.valueOf(f1+1));}else{continue A;}}
                            if(where2==2){if(s1+1<=s){st1.set(2,String.valueOf(s1+1));}else{continue A;}}
                            if(where2==3){if(t1+1<=t){st1.set(3,String.valueOf(t1+1));}else{continue A;}}
                             groups.get(groups.indexOf(st1)).add(req[1]);
                                             if(where1==1){grade1.remove(req[0]);}
                    
                    if(where2==1){grade1.remove(req[1]);}
                    if(where2==2){grade2.remove(req[1]);}
                    if(where2==3){grade3.remove(req[1]);}
                                             continue A;
                                         }else{continue A;}                                  
                            }
if((where1>0)&(where1<4)&(where2==0)){//one in groups, one in grades
                                                
    ArrayList<String> st1 =new ArrayList<String>();     
                  for(ArrayList<String>st3:groups){if(st3.contains(req[1])){st1=st3;}}
                                         if(st1.size()-3<=b){
                                              int f1 = Integer.parseInt(st1.get(1));
                                              int s1 = Integer.parseInt(st1.get(2));
                                              int t1 = Integer.parseInt(st1.get(3));
                                             
                            if(where1==1){if(f1+1<=f){st1.set(1,String.valueOf(f1+1));}else{continue A;}}
                            if(where1==2){if(s1+1<=s){st1.set(2,String.valueOf(s1+1));}else{continue A;}}
                            if(where1==3){if(t1+1<=t){st1.set(3,String.valueOf(t1+1));}else{continue A;}}
                             groups.get(groups.indexOf(st1)).add(req[0]);
                                       
                    if(where1==1){grade1.remove(req[0]);}
                    if(where1==2){grade2.remove(req[0]);}
                    if(where1==3){grade3.remove(req[0]);} 
                                             continue A;
                                         }else{continue A;}                                  
                            }
                            }
  
     
        int sz=0;
        for(ArrayList<String>st3:groups){if(st3.size()>sz){sz=st3.size();}}
    if(sz-4>=a){  
        for(ArrayList<String>st3:groups){if(st3.size()==sz){
        st3.remove(0); st3.remove(0); st3.remove(0); st3.remove(0);
        for(String sss:st3){res.add(sss);} 
        }}
        
        for(String sss:res){System.out.println(sss);}
        }else{System.out.println("no groups");};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nmabfst = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmabfst[0]);

        int m = Integer.parseInt(nmabfst[1]);

        int a = Integer.parseInt(nmabfst[2]);

        int b = Integer.parseInt(nmabfst[3]);

        int f = Integer.parseInt(nmabfst[4]);

        int s = Integer.parseInt(nmabfst[5]);

        int t = Integer.parseInt(nmabfst[6]);

       
        for(int i=0;i<n;i++){
                    
        String []s1 = scanner.nextLine().split(" ");
        if(Integer.parseInt(s1[1])==1){grade1.add(s1[0]);};
        if(Integer.parseInt(s1[1])==2){grade2.add(s1[0]);};  
        if(Integer.parseInt(s1[1])==3){grade3.add(s1[0]);};
       }  
        for(int i=0;i<m;i++){
            
        String s1 = scanner.nextLine();
        
        requests.add(s1);
                          }  
        membersInTheLargestGroups(n, m, a, b, f, s, t);

        scanner.close();
    }
}

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ClassForRecu {
    public static void main(String[] args) {
        ArrayList<Character> arrChar = new ArrayList<Character>(Arrays.asList( 'b','c','e','f','s'));
        ArrayList<Integer> arrInt = new ArrayList<Integer>(Arrays.asList( 23,3,4,5,6));
        ArrayList<String> arrString = new ArrayList<String>(Arrays.asList("shash","test","test3","new2","new4"));

        PSG("a1b5",4);
    }


    public static void PSG(String s, int n){
        if(n == 0) {
            System.out.println(s);
            return;
        }
        else {
            if(s.charAt(n-1)>0 && s.charAt(n-1)<9){
                String letterStr = s.substring(0,n-1) + s.substring(n-1,n) + s.substring(n,s.length());
                PSG(letterStr,n-1);
            }
            else {
                String upstr = s.substring(0, n - 1) + s.substring(n - 1, n).toUpperCase() + s.substring(n, s.length());
                PSG(upstr, n - 1);
                //System.out.println(n +" " + upstr);
                String lowstr = s.substring(0, n - 1) + s.substring(n - 1, n).toLowerCase() + s.substring(n, s.length());
                PSG(lowstr, n - 1);
                //System.out.println(n +" " +lowstr);
            }
        }
    }

    public static void instPSG(String s, int n){

    }

    public static void printSubset(HashSet<Integer> set, int length){
        if(set.isEmpty()){
            System.out.println(set);
        }
        else {

        }
    }
}

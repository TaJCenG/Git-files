package org.TajCeng;

public class practise  {
    public static void main(String[] args) {
        String maiStr = "ada da ada ada daddad";
        String sub = "ada";
        System.out.println(ContainOfSubString(maiStr, sub));

    }

    private static int ContainOfSubString(String maiStr, String sub) {
        if(sub.isEmpty() || sub.length() > maiStr.length()){
            return 0;
        }
        int count = 0;
        int index = maiStr.indexOf(sub);

        while(index != -1){
            count++;
            index = maiStr.indexOf(sub,index+1);
        }


        return count;
    }
}
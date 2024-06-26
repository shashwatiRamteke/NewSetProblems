package CodeSignal;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BankingAccount {
    public static void main(String[] args) {
        String[][] logqueries = new String[8][4];
        logqueries[0] = new String[]{"CREATE_ACCOUNT", "account1"};
        logqueries[1] = new String[] {"CREATE_ACCOUNT","account2"};
        logqueries[2] = new String[] {"CREATE_ACCOUNT","account3"};
        logqueries[3] = new String[] {"CREATE_ACCOUNT","account2"};
        logqueries[4] = new String[] {"DEPOSIT","account1", "500"};
        logqueries[5] = new String[] {"DEPOSIT","account2", "1000"};
        logqueries[6] = new String[] {"DEPOSIT","account3", "2500"};
        logqueries[7] = new String[] {"TRANSFER","account2","account1", "500"};
        logqueries[8] = new String[] {"TOP_SPENDERS","3"};


        String[] arr = createLogs(logqueries);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static String[] createLogs(String[][] logs){
        HashMap<String,Integer> bankaccounts = new HashMap<>();

        PriorityQueue<AbstractMap.SimpleEntry<String,Integer>> queue = new PriorityQueue<AbstractMap.SimpleEntry<String, Integer>>(logs.length, new Comparator<AbstractMap.SimpleEntry<String, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<String, Integer> o1, AbstractMap.SimpleEntry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        String[] resultarr = new String[logs.length];
        for(int i=0;i<logs.length;i++){
            if(logs[i][0].equals("CREATE_ACCOUNT")){
                if(bankaccounts.containsKey(logs[i][1])){
                    resultarr[i] = "False";
                }else {
                    bankaccounts.put(logs[i][1],0);
                    resultarr[i] = "True";
                }
            }
            if(logs[i][0].equals("DEPOSIT")){
                if(bankaccounts.containsKey(logs[i][1])){
                    int value = bankaccounts.get(logs[i][1]);
                    value = value + Integer.parseInt(logs[i][2]);
                    bankaccounts.put(logs[i][1],value);
                    resultarr[i] = "Added";
                }else{
                    resultarr[i] = "";
                }
            }
            if(logs[i][0].equals("TRANSFER")){
                if(bankaccounts.containsKey(logs[i][1]) && bankaccounts.containsKey(logs[i][2])){
                    if(queue.contains(logs[i][1])){

                    }
                    Integer amountToTransfer = Integer.parseInt(logs[i][3]);
                    if(bankaccounts.get(logs[i][1]) > amountToTransfer){
                       Integer srcAmount = bankaccounts.get(logs[i][1]) - amountToTransfer;
                       Integer targetAmount = bankaccounts.get(logs[i][2]) + amountToTransfer;
                       bankaccounts.put(logs[i][1],srcAmount);
                       bankaccounts.put(logs[i][2],targetAmount);
                       resultarr[i] =  "TRANSFERED";
                    }
                    else
                    {
                        resultarr[i] = "INSUFFICIENT FUNDS";
                    }
                }
                else
                {
                    resultarr[i] = "ACC DOESNT EXISTS";
                }
            }
        }
        return resultarr;
    }


}

import java.util.*;
import java.io.*;

public class Main {

    public static int getSum(String str){
        int strNumSum =0;
        for(int j=0; j<str.length(); j++){
            if(Character.isDigit(str.charAt(j))){
                strNumSum += Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        return strNumSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    if (getSum(o1) == getSum(o2)) {
                        return o1.compareTo(o2);
                    } else {
                        return getSum(o1) - getSum(o2);
                    }
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }
}

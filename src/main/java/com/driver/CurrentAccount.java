package com.driver;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class CurrentAccount extends BankAccount{
    //consists of Uppercase English characters only
    String tradeLicenseId;

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000.0);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance < 5000.0) { throw  new Exception("Insufficient Balance");}

        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid ------> isValidId() bana alag se // AABBBBCCCC
        // if no two consecutive characters are same
        // If the license Id is valid, do nothing

        String ans = checkhosktahekinhi(tradeLicenseId);

        if(Objects.equals(ans,"")) throw  new Exception("Valid License can not be generated");


    }

    public String checkhosktahekinhi(String s){

        int len = s.length();

        if(len == 0 ) return "";

        int [] cnt = new int [26];

        Arrays.fill(cnt,0);

        for(char c : s.toCharArray())
            cnt[(int) c - (int) 'a']++;

        char maxCh = getMaxCharCnt(cnt);

        int maxCnt = cnt[(int)maxCh - (int)'a'];

        //result ho skta h ya nhi

        if(maxCnt > (len + 1)/2) return "";

        String ans = "";

        String res = "";
        for (int i = 0; i < len; i++) {
            res += ' ';
        }

        int fil = 0;

        // filling the most occurence character

        while(maxCnt > 0) {
            res = res.substring(0,fil) + maxCh + res.substring(fil + 1);
            fil +=2;
            maxCnt--;
        }

        cnt[(int)maxCh - (int)'a'] = 0;

        // now filling the other Chars, first filling the even positions and then the odd positions

        for(int i =0;i<26;i++)
        {
            while (cnt[i] > 0){
                fil = (fil >= len)? 1 : fil;

                res = res.substring(0, fil)
                        + (char)((int)'a' + i)
                        + res.substring(fil + 1);

                fil += 2;
                cnt[i]--;
            }
        }
        return res;
    }

    private char getMaxCharCnt(int[] cnt) {
        int max = 0;
        char ch = 0;

        for(int i =0;i<26;i++)
        {
            if(cnt[i] > max)
            {
                max = cnt[i];
                ch = (char)((int)'a' + i);
            }
        }
        return ch;
    }


}

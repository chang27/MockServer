package com.uci.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by junm5 on 5/27/17.
 */
public class HttpUtilsTest {

    @Test
    public void name() throws Exception {
        int luSlength = findLUSlength(new String[]{"aba", "cdc", "eae"});
        System.out.println(luSlength);
    }
    public int findLUSlength(String[] strs) {
        if(strs == null || strs.length == 0){
            return -1;
        }
        Map<String, Integer> map = new HashMap();
        for(String str : strs){
            Set<String> subs = getAllSubsequence(str);
            System.out.println(subs);
            for(String item :  subs){
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
        }
        int res = -1;
        for(String key : map.keySet()){
            System.out.println(key + ":" + map.get(key));
            if(map.get(key) == 1){
                res = Math.max(res, key.length());
            }
        }
        return res;
    }

    public Set<String> getAllSubsequence(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        Set<String> subRes = getAllSubsequence(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes){
            res.add(s.charAt(0) + seq);
        }
        return res;
    }
}
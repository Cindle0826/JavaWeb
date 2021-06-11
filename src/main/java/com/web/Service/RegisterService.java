package com.web.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author No Name
 */
public class RegisterService {
    private static Map<Integer,String> timesNames;
    static {
        timesNames = new LinkedHashMap<>();
        timesNames.put(1, "上午");
        timesNames.put(2, "下午");
        timesNames.put(3, "晚上");
    }
    
    public List<String> getTimeNamesById(List<Integer> time){
        if(time.size() ==0) return null;
        // {1, 3} {"上午" , "晚上"}
        return time.stream().map(t -> timesNames.get(t)).collect(toList());
    }
}

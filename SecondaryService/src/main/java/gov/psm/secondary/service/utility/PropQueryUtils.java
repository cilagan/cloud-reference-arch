package gov.psm.secondary.service.utility;

import java.util.List;
import java.util.Map;

public class PropQueryUtils {
    
    private PropQueryUtils() {
        //Private constructor
    }
    
    public static boolean isOnlySpoAor(Map<String,Boolean> spoAORMap, List<String> institutionIds) {
        if(institutionIds != null && !institutionIds.isEmpty()) {
            for(String instId : institutionIds) {
                if(spoAORMap != null && !spoAORMap.isEmpty() && spoAORMap.containsKey(instId)) {
                    return spoAORMap.get(instId);
                }
            }
        }
        return false;
    }

}

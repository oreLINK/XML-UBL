package com.company.xml.ubl.axioms;

import java.util.List;

/**
 * Class Tips
 */
public class Tips {

    /**
     * Function that will return if this String is null or not
     * @param s String to check
     * @return true if this String is null
     */
    public static boolean stringIsNull(String s) {
        if(s == null || s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return if this List is null or not
     * @param list List to check
     * @return true if this List is null
     */
    public static boolean listIsNull(List list) {
        boolean isNull = true;
        if (!list.isEmpty() && list.size() != 0 && list!=null) {
            isNull = false;
        }
        return isNull;
    }

}

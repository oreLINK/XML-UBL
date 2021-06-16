package com.company.xml.ubl.axioms;

import java.util.List;

public class Tips {

    public static boolean stringIsNull(String s) {
        if(s == null || s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean listIsNull(List list) {
        boolean isNull = true;
        if (!list.isEmpty() && list.size() != 0 && list!=null) {
            isNull = false;
        }
        return isNull;
    }

}

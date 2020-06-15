package com.applozic.parser.Parser;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;


import java.util.*;

public class TimeParser {
    private final Parser parser = new Parser();

    public void parseTextForDate(String text){
        List<DateGroup> groups = parser.parse(text);
        if(groups.isEmpty()) {
            System.out.println("Can't detect time info.");
			return;
        }
        groups.stream().forEach(group ->{
            List<Date> dates = group.getDates();
            if(!dates.isEmpty())
                System.out.println("Time Information:");
            else
                System.out.println("Can't detect time info.");
            dates.stream().forEach(date -> System.out.println(date.toString()));
        });
    }
}

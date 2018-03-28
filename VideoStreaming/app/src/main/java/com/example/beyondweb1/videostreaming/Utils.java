package com.example.beyondweb1.videostreaming;

/**
 * Created by Beyondweb1 on 1/29/2018.
 */
import java.text.DecimalFormat;

public class Utils {
    public static String durationInSecondsToString(int sec){
        int hours = sec / 3600;
        int minutes = (sec / 60) - (hours * 60);
        int seconds = sec - (hours * 3600) - (minutes * 60) ;
        String formatted = String.format("%d:%02d:%02d", hours, minutes, seconds);
        return formatted;
    }
}

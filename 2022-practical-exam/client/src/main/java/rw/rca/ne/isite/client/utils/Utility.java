package rw.rca.ne.isite.client.utils;

import org.springframework.beans.factory.annotation.Value;

public class Utility {

    private static String backendUrl = "http://localhost:5000";

    public static String formatURL(String url){
        return backendUrl + url;
    }
}

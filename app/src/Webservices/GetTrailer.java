//Created By Jordan Waddell
package Webservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetTrailer {
	private static JSONObject json = null;
	private String videoid = null;
	
	//takes a movie name and query youtube for trailer using youtube api
    public GetTrailer(String movie){
		try {
			videoid = null;
			String moviestr = movie.trim().replaceAll(" ","+");
			String jsonstring = readUrl("https://www.googleapis.com/youtube/v3/search?q="+moviestr+"+trailer&part=id&maxResults=1&key=AIzaSyCrkshe6uUM5p2Uaa8EZulNhygYW6P6CdE");
			json = (JSONObject) new JSONParser().parse(jsonstring);
			JSONArray results = (JSONArray) json.get("items");
			Iterator<JSONObject> iterator = results.iterator();
			
			while (iterator.hasNext()) {
				JSONObject factObj = (JSONObject) iterator.next();
			    videoid = (String) ((HashMap<?, ?>) factObj.get("id")).get("videoId");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    //concat video id with youtube url to create a link
	public String getVideoid() {
		return "https://www.youtube.com/watch?v=" + videoid;
	}
	
    //read data from url and return as a string
	public static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 
	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}

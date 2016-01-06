//Created By Jordan Waddell

package Webservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SearchMovie {
	
    private static ArrayList<SearchObject> searcharray = new ArrayList<SearchObject>();
	private static JSONObject json = null;
	
	//searches for a movie based on user query on rotten tomotoe api
	public SearchMovie(String searchstr){
		try {
			searchstr = searchstr.trim().replaceAll(" ","+");
			String jsonstring = readUrl("http://api.rottentomatoes.com/api/public/v1.0/movies.json?q="+searchstr+"&page_limit=6&page=1&apikey=9n59xgdbdmm8tnruaswkqm8h");
			json = (JSONObject) new JSONParser().parse(jsonstring);
			GetResultsToLists();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//get results and add  each to an array of object type searchobject
	public static void GetResultsToLists() {
		//ensure list is empty
		searcharray = new ArrayList<SearchObject>();
		JSONArray results = (JSONArray) json.get("movies");
		Iterator<JSONObject> iterator = results.iterator();

		while (iterator.hasNext()) {
			JSONObject factObj = (JSONObject) iterator.next();
			String title = (String) factObj.get("title");
			String id = (String) factObj.get("id").toString();
			String thumbnail = (String) ((HashMap<?, ?>) factObj.get("posters")).get("thumbnail");
			String synopsis = (String) factObj.get("synopsis").toString();
			String year = (String) factObj.get("year").toString();
			String runtime = (String) factObj.get("runtime").toString();
			String ratings = (String) factObj.get("mpaa_rating").toString();
			
			searcharray.add(new SearchObject(title, id, thumbnail, synopsis, year, runtime, ratings));
		}
	}
	
    //return searcharray
	public ArrayList<SearchObject> getSearcharray() {
		return searcharray;
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


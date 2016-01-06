//Created By Jordan Waddell
package Webservices;

public class SearchObject {
	private String title;
	private String id;
	private String thumbnailurl;
	private String synopsis;
	private String year;
	private String runtime;
	private String ratings;

	public SearchObject(String title, String id, String thumbnailurl, String synopsis, String year, String runtime, String ratings){
		this.title = title;
		this.id = id;
		this.thumbnailurl = thumbnailurl;
		this.synopsis = synopsis;
		this.year = year;
		this.runtime = runtime;
		this.ratings = ratings;
	}

	public String getTitle() {
		return title;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getRatings() {
		return ratings;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getId() {
		return id;
	}

	public String getThumbnailurl() {
		return thumbnailurl;
	}

	public String getYear() {
		return year;
	}
	
	private String checkifempty(String s) {
		if(s.trim().length() == 0){
			return new String("unknown");
		}
		return s;
	}
	
	//ensure string does not exceed maximum length
	private String truncateString(String s, int maxsize){
		int size = s.length();
		String filler = "...";
		if(size > maxsize){
			// dont want to split up a word, looks bad
			int index;
			for(index = maxsize - 3; index >= 0; --index){
				char c =s.charAt(index); 
				if(Character.isWhitespace(c)) break;
			}
			// index is pointing to the space but we still want it in
			++index;
			String ret = s.substring(0,  index);
			ret += filler;
			return ret;
		}
		
		return s;
	}
	
	//for search query return a youtube trailer
	private String getTrailerUrl(String searchquery){
		GetTrailer s = new GetTrailer(searchquery);
		return s.getVideoid();
		
	}
	
	//return htm,l string ocntaining data from this object
	public String ObjectToHtml() {	
		
		String title = getTitle() +" "+"(" + getYear() + ")";
		String output = "<td><div class='box3'><table class='boxtable'><tr><td>" +
						"<img src='" + getThumbnailurl() + "' />" +
						"<div class='title'><a href='"+getTrailerUrl(title)+"'>" + title + "</a></div></td></tr><tr><td>" +
						"<p>" + truncateString(getSynopsis(), 250) + "</p>" +
						"</td></tr><tr><td valign='bottom'><strong>Runtime:</strong> "+checkifempty(getRuntime())+"&nbsp;&nbsp;<strong>Rating: </strong>"+ checkifempty(getRatings())+"</td></tr></table></div>";
		
		return output;
	}
}

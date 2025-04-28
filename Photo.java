
public class Photo {
	String path;
	LinkedList<String>tags;
	
	// Constructor
	public Photo(String path, LinkedList<String> tags) {
	this.path=path;
	this.tags=new LinkedList<String>();
	}
	// Return the full file name (the path) of the photo. A photo is uniquely identified by
	//its path.
	public String getPath() {
		return path;
	}
	// Return all tags associated with the photo
	public LinkedList<String> getTags(){
		return tags;
	}
	
}
	
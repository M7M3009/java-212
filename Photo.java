package project;

public class Photo {
	private String path;
	private linkedlist<String> tags;

	public Photo(String path, linkedlist<String> tags) {
		this.path = path;
		this.tags = new linkedlist<String>();
	}

	public String getPath() {
		return path;
	}

	public linkedlist<String> getTags() {
		return tags;
	}

}

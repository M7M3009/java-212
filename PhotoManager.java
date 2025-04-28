
public class PhotoManager {
	LinkedList<Photo> list;
	// Constructor
	public PhotoManager() {
		list =new LinkedList<Photo>();
	}
	// Return all managed photos
	public LinkedList<Photo> getPhotos(){
		return list;
	}
	// Add a photo
	public void addPhoto(Photo p) {
		list.insert(p);
	}
	// Delete a photo
	
	public void deletePhoto(String path) {
		//requires non empty list + photo path exists.  
		list.findFirst();
		while(!list.last()) {
			if(list.retrieve().equals(path)) {
				list.remove();
				return;
			}
			list.findNext();
		}
		if(list.retrieve().equals(path))
			list.remove();
		
	}
	}


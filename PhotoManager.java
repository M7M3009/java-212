package project;

public class PhotoManager {
	
	private linkedlist<Photo> Mph;
	

	public PhotoManager() {
		
		this.Mph = new linkedlist<Photo>();
	}

	public linkedlist<Photo> getPhotos() {
		
	}

	public void addPhoto(Photo p) {
		Mph.insert(p);
	}

	public void deletePhoto(String path) {
		

		Mph.findFirst();
		while (Mph.retrieve() != null) {
			Photo currentPhoto = Mph.retrieve();

			if (currentPhoto != null && path.equals(currentPhoto.getPath())) {
				Mph.remove();
				return;
			}
			Mph.findNext();
		}
	}

}

package project;

public class PhotoManager {
	
	private linkedlist<Photo> Mph;
	

	public PhotoManager() {
		
		this.Mph = new linkedlist<Photo>();
	}

	public LinkedList<photo> getPho() {

		LinkedList<photo> t = manager.getPhoto();
		t.findFirst();

		while (!t.empty() && t.retrieve() != null) {
			String arr[] = splitcond(condition);//maybe here
			photo g = t.retrieve();
			LinkedList<String> tags = g.getTags();
			tags.findFirst();
			while (!tags.empty() && tags.retrieve() != null) {
				for (int i = 0; i < arr.length; i++) {
					compare++;
					if (!tags.retrieve().equals(arr[i])) {
						tags.findNext();
						if (tags.retrieve()==null)
							break;
						continue;
					} else if (tags.retrieve().equals(arr[i])) {
						arr[i] = null;
						tags.findNext();
						if (tags.retrieve()==null)
							break;
						continue;
					}
					
				
				}
				boolean allMatched = true;
				for (String s : arr) {
					if (s != null) {
						allMatched = false;
						break;
					}
				}
				if (allMatched) {
					pho.insert(g);
					//tags.findNext();//
					
					
				}

			}
			t.findNext();
			if (t.retrieve()==null) {
				break;
				
			}
		}
		
		return pho;
	}

	public void addPhoto(Photo p) {
		Mph.insert(p);
	}

	public void deletePhoto(String path) {
		if (Mph.empty())
			return;

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

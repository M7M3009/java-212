package project;

public class InvIndexPhotoManager {
	private BST<LinkedList<photo>> bstInverted;
	LinkedList<photo> photo;
	LinkedList <String> tagss=new LinkedList <String>();
	public InvIndexPhotoManager() {
		bstInverted=new BST<LinkedList<photo>>();
		
		
	}
public void addphoto(photo p) {
	if (bstInverted.empty())
		tagss= p.getTags();
		bstInverted.insert(null, null);//we will be back!
		photo.insert(p);
}
public void deletePhoto(String path) {
	if (photo.empty())
		return;

	photo.findFirst();
	while (photo.retrieve() != null) {
		photo currentPhoto = photo.retrieve();

		if (currentPhoto != null && path.equals(currentPhoto.getPath())) {
			photo.remove();
			return;
		}
		photo.findNext();

	}
}
public BST<LinkedList<photo>> getpho(int t, int String, int LinkedList){
	{
		
		photo.findFirst();
		while (!photo.last()) {
			LinkedList <String> p=photo.retrieve().getTags();
			while(!p.last()) {
				String j=p.retrieve();
				tagss.insert(j);
				p.findNext();
			}
			tagss.insert(p.retrieve());
			photo.findNext();
		}
		tagss.insert(photo.retrieve().getTags().retrieve());
	BST <String> tagsbst=new BST<String>();
	tagss.findFirst();
	while (!tagss.last()) {
		tagsbst.insert(tagss.retrieve(),tagss.retrieve() );
	}
	tagsbst.insert(tagss.retrieve(), tagss.retrieve());
		
	}

return	bstInverted;
	

	
	
}
public LinkedList<photo> findphoto(){
	tagss.findFirst();
	String j=tagss.retrieve();
	photo.findFirst();
	LinkedList <String> g=photo.retrieve().getTags();
	while(!tagss.last()) {
		while(!photo.last()) {
			while(!g.last()) {
				if(tagss.retrieve().equals(g)) {
					LinkedList <photo> d=new LinkedList <photo>();
					d.insert(photo.retrieve());
				}
			}
			
			
		}
	}
	return photo;
	
	
}
}

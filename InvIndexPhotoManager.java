package project;

public class InvIndexPhotoManager {

	private BST<linkedlist<Photo>> bstInverted;

	public InvIndexPhotoManager() {

		this.bstInverted = new BST<linkedlist<Photo>>();
	}

	public BST<linkedlist<Photo>> getPhoto() {
		return bstInverted;
	}

	public void addPhoto(Photo p) {
		if (bstInverted.empty()) {
			int nodeNumber = 0;
			linkedlist<String> tagsP = p.getTags();
			tagsP.findFirst();
			while (!tagsP.empty()) {
				nodeNumber++;
				tagsP.findNext();
			}
			nodeNumber++;
			tagsP.findNext();
			if (nodeNumber % 2 == 1) {
				for (int i = 0; i < nodeNumber + 1; i++) {
					tagsP.findNext();
				}
				bstInverted.insert(tagsP.retrieve(), new linkedlist<Photo>());
				bstInverted.root.data.insert(p);
			} else {
				for (int i = 0; i < nodeNumber; i++) {
					tagsP.findNext();
				}
				bstInverted.insert(tagsP.retrieve(), new linkedlist<Photo>());
				bstInverted.root.data.insert(p);
			}
			if (tagsP.empty())
				return;
			tagsP.findFirst();
			while (true) {
				if (bstInverted.findkey(tagsP.retrieve())) {
					bstInverted.current.data.insert(p);
				} else {
					bstInverted.insert(tagsP.retrieve(), new linkedlist<Photo>());
					bstInverted.current.data.insert(p);
				}
				if (tagsP.last())
					break;
				tagsP.findNext();
			}
		} else {
			linkedlist<String> tags = new linkedlist<String>();

			while (!tags.last()) {
				if (bstInverted.findkey(tags.retrieve())) {
					bstInverted.current.data.insert(p);
				} else {
					bstInverted.insert(tags.retrieve(), new linkedlist<Photo>());
					bstInverted.current.data.insert(p);
				}
				tags.findNext();
			}
			if (bstInverted.findkey(tags.retrieve())) {
				bstInverted.current.data.insert(p);
			} else {
				bstInverted.insert(tags.retrieve(), new linkedlist<Photo>());
				bstInverted.current.data.insert(p);
			}

		}
	}

	public void deletePhoto(String path) {

		deletePhotoCheck(path, bstInverted.root);
	}

	private void deletePhotoCheck(String p, BSTNode<linkedlist<Photo>> n) {
		if (n == null)
			return;
		deletePhotoCheck(p, n.left);
		deletePhotoCheck(p, n.right);
		linkedlist<Photo> tmpPhotos = n.data;
		tmpPhotos.findFirst();
		while (!tmpPhotos.last()) {
			if (p.equalsIgnoreCase(tmpPhotos.retrieve().getPath())) {
				tmpPhotos.remove();
			} else {
				tmpPhotos.findNext();
			}
		}
		if (p.equalsIgnoreCase(tmpPhotos.retrieve().getPath()))
			tmpPhotos.remove();
		if (tmpPhotos.empty())
			bstInverted.remove_key(n.key);

	}
}

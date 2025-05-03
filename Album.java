package project;

public class Album {
	private String name;
	private String condition;// bear AND GRASS
	private PhotoManager manager;
	private int CompNum;

	// Constructor
	public Album(String name, String condition, PhotoManager manager) {
		this.name = name;
		this.condition = condition;
		this.manager = manager;
	}

	// Return the name of the album
	public String getName() {
		return name;
	}

	// Return the condition associated with the album
	public String getCondition() {
		return condition;
	}

	// Return the manager
	public PhotoManager getManager() {
		return manager;
	}

	private String[] SplitCond() {
		String[] arr = condition.split("\\s*AND\\s*");
		return arr;
	}

	private boolean SatisfyCond(linkedlist<String> taglist) {
		// arr for Condition set
		String arr[] = SplitCond();
		int k = arr.length;
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			taglist.findFirst();
			while (!taglist.last()) {
				CompNum++;
				if (taglist.retrieve().equals(arr[i])) {
					counter++;
					break;

				}
				taglist.findNext();
			}
			if (taglist.last() && taglist.retrieve().equals(arr[i])) {
				counter++;
				CompNum++;
			}
		}
		if (counter == k)
			return true;
		return false;
	}

	// Return all photos that satisfy the album condition
	public linkedlist<Photo> getPhotos() {
		// Manager List
		linkedlist<Photo> Mlist = manager.getPhotos();
		// temp List (returned in the end)
		linkedlist<Photo> tlist = new linkedlist<Photo>();
		Mlist.findFirst();
		linkedlist<String> taglist = Mlist.retrieve().getTags();
		taglist.findFirst();
		if (condition.isEmpty()) {
			return Mlist;
		} else {
			while (!Mlist.last()) {
				// tagList for each photo
				taglist = Mlist.retrieve().getTags();
				if (SatisfyCond(taglist)) {
					tlist.insert(Mlist.retrieve());
				}
				Mlist.findNext();
			}
			taglist = Mlist.retrieve().getTags();
			if (SatisfyCond(taglist)) {
				tlist.insert(Mlist.retrieve());
			}

			return tlist;
		}
	}

	// Return the number of tag comparisons used to find all photos of the album
	public int getNbComps() {
		return CompNum;
	}

}

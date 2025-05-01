package project;

public class Album {
	private String name;
	private String condition; 
	private PhotoManager manager;
	private int counterCondition;

	public Album(String name, String condition, PhotoManager manager) {

		this.name = name;
		this.condition = condition;
		this.manager = manager;
		this.counterCondition = 0;
	}

	public String getName() {
		return name;
	}

	public String getCondition() {
		return condition;
	}

	private linkedlist<String> splitCondition() {
		linkedlist<String> tmpS = new linkedlist<String>();
		String S[] = condition.split("\\s*AND\\s*");
		for (int i = 0; i < S.length; i++) {
			tmpS.insert(S[i]);
		}
		return tmpS;
	}

	public PhotoManager getManager() {
		return manager;
	}
	


	public linkedlist<Photo> getPhotos() {
		linkedlist<Photo> tmp = new linkedlist<Photo>();
		linkedlist<Photo> photos = manager.getPhotos();
		linkedlist<String> conditionSplited = splitCondition();

		if (photos.empty())
			return tmp;
		if(conditionSplited.empty())
			return photos;
		photos.findFirst();
		while (!photos.last()) {
			
			linkedlist<String> Ptags = photos.retrieve().getTags();
			conditionSplited.findFirst();
			boolean dup = false;// checks for duplication
			
				while (!conditionSplited.last()) {

					Ptags.findFirst();
					while (!Ptags.last()) {

						if (conditionSplited.retrieve().equalsIgnoreCase(Ptags.retrieve())) {
							counterCondition++;
							if (!dup) {
								tmp.insert(photos.retrieve());
								dup = true;
							}
						}
						Ptags.findNext();
					}
					// check last tag
					if (conditionSplited.retrieve().equalsIgnoreCase(Ptags.retrieve())) {
						counterCondition++;
						if (!dup) {
							tmp.insert(photos.retrieve());
							dup = true;
						}
					}
					conditionSplited.findNext();
				}
				// check last condition
				Ptags.findFirst();
				while (!Ptags.last()) {
					if (conditionSplited.retrieve().equalsIgnoreCase(Ptags.retrieve())) {
						counterCondition++;
						if (!dup) {// check duplication
							tmp.insert(photos.retrieve());
							dup = true;
						}
					
					}
					Ptags.findNext();
				}
				if (conditionSplited.retrieve().equalsIgnoreCase(Ptags.retrieve())) {
					counterCondition++;
					if (!dup) {
						tmp.insert(photos.retrieve());
						dup = true;
					}
				}
			
			photos.findNext();
		}
		// check last photo
		

			linkedlist<String> Ptags2 = photos.retrieve().getTags();
			conditionSplited.findFirst();
			boolean dup2 = false;// checks for duplication
			
				while (!conditionSplited.last()) {

					Ptags2.findFirst();
					while (!Ptags2.last()) {

						if (conditionSplited.retrieve().equalsIgnoreCase(Ptags2.retrieve())) {
							counterCondition++;
							if (!dup2) {
								tmp.insert(photos.retrieve());
								dup2 = true;
							}
						}
						Ptags2.findNext();
					}
					// check last tag
					if (conditionSplited.retrieve().equalsIgnoreCase(Ptags2.retrieve())) {
						counterCondition++;
						if (!dup2) {
							tmp.insert(photos.retrieve());
							dup2 = true;
						}
					}
					conditionSplited.findNext();
				}
				// check last condition
				Ptags2.findFirst();
				while (!Ptags2.last()) {
					if (conditionSplited.retrieve().equalsIgnoreCase(Ptags2.retrieve())) {
						counterCondition++;
						if (!dup2) {// check duplication
							tmp.insert(photos.retrieve());
							dup2 = true;
						}
						
					}
					Ptags2.findNext();
				}
				if (conditionSplited.retrieve().equalsIgnoreCase(Ptags2.retrieve())) {
					counterCondition++;
					if (!dup2) {
						tmp.insert(photos.retrieve());
						dup2 = true;
					}
				  }
				
			
			
		return tmp;
	}
	
	
	
	

	public int getNbComps() {
		return counterCondition;
	}

}

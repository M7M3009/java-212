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

	private linkedlist<String> splitCondition() {// split the codition
		linkedlist<String> tmpS = new linkedlist<String>();
		String S[] = condition.split("AND");
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
		counterCondition=0;
		
		if (manager.getPhotos().empty())
			return tmp;
		
		photos.findFirst();
		while (!photos.last()) {
			
			linkedlist<String> Ptags = photos.retrieve().getTags();
			conditionSplited.findFirst();
			boolean dup=false;//checks for duplication
			
			while(!conditionSplited.last()) {
				
				Ptags.findFirst();
				while(!Ptags.last()) {
					
					if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
						if(!dup) {
							counterCondition++;
							tmp.insert(photos.retrieve());
							dup=true;
						}
					}
					Ptags.findNext();
				}
				//check last tag
				if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
					if(!dup) {
						counterCondition++;
						tmp.insert(photos.retrieve());
						dup=true;
					}
				}
				conditionSplited.findNext();
			}
			//check last condition 
			Ptags.findFirst();
			while(!Ptags.last()) {
				if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
					if(!dup) {//check duplication
						counterCondition++;
						tmp.insert(photos.retrieve());
						dup=true;
					}
					
				}
				
			}
			if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
				if(!dup) {
					counterCondition++;
					tmp.insert(photos.retrieve());
					dup=true;
				}
			}
			photos.findNext();
		}
		//check last photo
		linkedlist<String> Ptags = photos.retrieve().getTags();
		conditionSplited.findFirst();
		boolean dup=false;//checks for duplication
		
		while(!conditionSplited.last()) {
			
			Ptags.findFirst();
			while(!Ptags.last()) {
				
				if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
					if(!dup) {
						counterCondition++;
						tmp.insert(photos.retrieve());
						dup=true;
					}
				}
				Ptags.findNext();
			}
			if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
				if(!dup) {
					counterCondition++;
					tmp.insert(photos.retrieve());
					dup=true;
				}
			}
			conditionSplited.findNext();
		}
		Ptags.findFirst();
		while(!Ptags.last()) {
			if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
				if(!dup) {
					counterCondition++;
					tmp.insert(photos.retrieve());
					dup=true;
				}
				
			}
			
		}
		if(conditionSplited.retrieve().equals(Ptags.retrieve())) {
			if(!dup) {
				counterCondition++;
				tmp.insert(photos.retrieve());
				dup=true;
			}
		}
			
		return tmp;
	}

	public int getNbComps() {
		return counterCondition;
	}
	
	

}

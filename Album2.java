package project;


public class Album2 {
	private String name;
	private String condition; // ask about linkedlist
	private InvIndexPhotoManager manager;
	private int counterCondition;

	public Album2(String name, String condition, InvIndexPhotoManager manager) {

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

	public InvIndexPhotoManager getManager() {
		return manager;
	}
	

	public linkedlist<Photo> getPhotos() {
		BST<linkedlist<Photo>> CBst = manager.getPhoto();
		linkedlist<String> conditionSplited = splitCondition();
		linkedlist<Photo> tmp = new linkedlist<Photo>();
		counterCondition=0;
		conditionSplited.findFirst();
		while(!conditionSplited.last()) {
			if(CBst.findkey(conditionSplited.retrieve())) {
				CBst.current.data.findFirst();
				while(!CBst.current.data.last()){
					
					counterCondition++;
					tmp.insert(CBst.current.data.retrieve());
					
					CBst.current.data.findNext();
				}
			}
			conditionSplited.findNext();
		}
		if(CBst.findkey(conditionSplited.retrieve())) {
			CBst.current.data.findFirst();
			while(!CBst.current.data.last()){
				
					counterCondition++;
					tmp.insert(CBst.current.data.retrieve());
				
				CBst.current.data.findNext();
			}
		}
		
		return delDup(tmp);
	}
	
	

	public int getNbComps() {
		return counterCondition;
	}
	
	private linkedlist<Photo> delDup(linkedlist<Photo> copy) {
		linkedlist<Photo> uniqeList = new linkedlist<Photo>();
		
		while(!copy.empty()) {
			copy.findFirst();
			String Path = copy.retrieve().getPath();
			uniqeList.insert(copy.retrieve());
			
			copy.findFirst();
			while(!copy.last()) {
				if(copy.retrieve().getPath().equalsIgnoreCase(Path))
					copy.remove();
				else
					copy.findNext();
			}
			if(copy.retrieve().getPath().equalsIgnoreCase(Path))
				copy.remove();
			
			if (copy.empty()) break;
		}
		return uniqeList;
	}
	
	
	

}

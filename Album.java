package project;

public class Album {
	String name;
	String condition;
	photomanager manager;
	LinkedList<photo> pho;
	int compare = 0;

	public Album(String na, String con, photomanager m) {
		name = na;
		condition = con;
		manager = m;
		 pho=new LinkedList<photo>();
	}

	public String getName() {
		return name;
	}

	public String getCondition() {
		return condition;
	}

	public photomanager getManager() {
		return manager;
	}

	public String[] splitcond(String condition) {
		String arr[] = condition.split("\\s*AND\\s*");
		return arr;

	}

	// Return all photos that satisfy the album condition
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

	public int getnumbercompare() {
		return compare;
	}
}


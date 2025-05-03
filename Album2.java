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
		if (condition == null)
			return tmpS;

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
		if (conditionSplited.empty() || condition.isBlank()) {
			allBSTnodes(CBst.root, tmp);

			return delDup(tmp);
		}

		counterCondition = 0;
		conditionSplited.findFirst();
		while (!conditionSplited.last()) {
			if (CBst.findkey(conditionSplited.retrieve())){
				counterCondition++;
				CBst.current.data.findFirst();
				while (!CBst.current.data.last()) {

					tmp.insert(CBst.current.data.retrieve());

					CBst.current.data.findNext();
				}
				tmp.insert(CBst.current.data.retrieve());
			}
			conditionSplited.findNext();
		}
		if (CBst.findkey(conditionSplited.retrieve())) {
			counterCondition++;
			CBst.current.data.findFirst();
			while (!CBst.current.data.last()) {

				tmp.insert(CBst.current.data.retrieve());

				CBst.current.data.findNext();
			}
			tmp.insert(CBst.current.data.retrieve());
		}

		return delDup(tmp);
	}

	public int getNbComps() {
		return counterCondition;
	}

	private linkedlist<Photo> delDup(linkedlist<Photo> copy) {
		linkedlist<Photo> uniqeList = new linkedlist<Photo>();

		while (!copy.empty()) {
			copy.findFirst();
			String Path = copy.retrieve().getPath();
			uniqeList.insert(copy.retrieve());

			while (!copy.last()) {
				if (copy.retrieve().getPath().equalsIgnoreCase(Path))
					copy.remove();
				else
					copy.findNext();
			}
			if (copy.retrieve().getPath().equalsIgnoreCase(Path))
				copy.remove();

			if (copy.empty())
				break;
		}
		return uniqeList;
	}

	private void allBSTnodes(BSTNode<linkedlist<Photo>> n, linkedlist<Photo> tmp) {
		if (n == null)
			return;
		allBSTnodes(n.left, tmp);
		allBSTnodes(n.right, tmp);
		n.data.findFirst();
		while (!n.data.last()) {
			tmp.insert(n.data.retrieve());
			n.data.findNext();
		}
		tmp.insert(n.data.retrieve());
	}

}

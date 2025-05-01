package project;

public class test2 {

	public static void main(String[] args) {
		InvIndexPhotoManager manager = new InvIndexPhotoManager();
		Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple,grass, green"));
		manager.addPhoto(photo1);
		Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass,wind"));
		manager.addPhoto(photo2);
		Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect,butterfly, flower, color"));
		manager.addPhoto(photo3);
		Album2 album1 = new Album2("Album1", "bear", manager);
		Album2 album2 = new Album2("Album2", "animal AND grass", manager);
		
		// class Photo
		System.out.println("Get photo1 path and tags:");
		System.out.println("photo1 path: " + photo1.getPath());
		System.out.print("photo1 tags:  ");
		printAllTags(photo1.getTags());
		// You can get the list of tags of photo1 by calling photo1.getTags().
		// You can write a method that prints the list of tags of photo1.
		
		//class invIndexphotoManager
		System.out.print("");
		printAllBST(manager.getPhoto());
		Photo photo4 = new Photo("raccoon.jpg", toTagsLinkedList("animal, raccoon, log,snow"));
		manager.addPhoto(photo4);
		System.out.println("after the new Photo added: ");
		printAllBST(manager.getPhoto());
		manager.deletePhoto("raccoon.jpg");
		System.out.println("after the deletion: ");
		printAllBST(manager.getPhoto());
		
		//album
		System.out.println("Get album2 name, condition, and photos:");
		System.out.println("album2 name: " + album2.getName());
		System.out.println("album2 condition: " + album2.getCondition());
		System.out.print("album2 photos: ");
		printPhotoBSTnode(album2.getPhotos());
		System.out.print("Delete the photo ’bear.jpg’: ");
		album2.getManager().deletePhoto("bear.jpg");
		printPhotoBSTnode(album2.getPhotos());
		System.out.println("the number of comparision: " + album2.getNbComps());
		
		
	}

	private static linkedlist<String> toTagsLinkedList(String tags) {
		linkedlist<String> result = new linkedlist<String>();
		String[] tagsArray = tags.split("\\s*,\\s*");
		for (int i = 0; i < tagsArray.length; i++) {
			result.insert(tagsArray[i]);
		}
		return result;
	}
	
	private static void printAllTags(linkedlist<String> list) {
		list.findFirst();
		while(!list.last()) {
			System.out.print(list.retrieve()+" , ");
			list.findNext();
		}
		System.out.println(list.retrieve()+"");
		
	}
	
	private  static void printPhotoBSTnode(linkedlist<Photo> list ) {
		if(list.empty()) {
			System.out.print("list is empty");
			System.out.println("");
			return;
		}
		list.findFirst();
		while(!list.last()) {
			System.out.print(list.retrieve().getPath()+" , ");
			list.findNext();
		}
		System.out.println(list.retrieve().getPath()+"");
		
	}
		private static void printPhotoManagere(linkedlist<Photo> list) {
		    if (list.empty()) {
		        System.out.println("list is empty");
		        return;
		    }
		    int counter = 1 ;
		    list.findFirst();
		    System.out.print("Photos in a node: ");
		    while (!list.last()) {
		        System.out.print(""+counter+"-"+list.retrieve().getPath() + ", ");
		        counter++;
		        list.findNext();
		    }
		    System.out.println(""+counter+"-"+list.retrieve().getPath());
		}


	
	private static void printAllBST(BST<linkedlist<Photo>> tmp) {
		printAllBSTrec(tmp.root);
	}
	
	private static void printAllBSTrec(BSTNode<linkedlist<Photo>> n) {
		if(n == null) return;
		printAllBSTrec(n.left);
		
		printAllBSTrec(n.right);
		
		printPhotoManagere(n.data);
		
	}
	
	

			
	

}

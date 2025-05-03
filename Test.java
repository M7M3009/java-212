package project;

public class testproject {
	private static LinkedList<String> toTagsLinkedList(String tags) {
		LinkedList<String> result = new LinkedList<String>();
		String[] tagsArray = tags.split("\\s*,\\s*");
		for (int i = 0; i < tagsArray.length; i++) {
		result.insert(tagsArray[i]);
		}
		return result;
		}
	private  static void printPhotoManagere(LinkedList<photo> list ) {
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

	public static void main(String[] args) {
		photomanager manager = new photomanager();
		photo photo1 = new photo("hedgehog.jpg",toTagsLinkedList("animal,hedge,apple,grass,green"));
		manager.addPhoto(photo1);
		photo photo2 = new photo("bear.jpg",toTagsLinkedList(("animal, bear, cab, grass,")));
		manager.addPhoto(photo2);
		photo photo3 = new photo("orange-butterfly.jpg",toTagsLinkedList("insect,butter,color,flower"));
		manager.addPhoto(photo3);
		Album album1 = new Album("Album1", "bear", manager);
		Album album2 = new Album("Album2", "animal", manager);
		System.out.println("Get photo1 path and tags:");
		System.out.println("photo1 path: " + photo1.getPath());
		//You can get the list of tags of photo1 by calling photo1.getTags().
		//You can write a method that prints the list of tags of photo1.
		System.out.println("Get album2 name, condition, and photos:");
		System.out.println("album2 name: " + album2.getName());
		System.out.println("album2 condition: " + album2.getCondition());
		//You can get the list of photos in album2 by calling album2.getPhotos().
		//You can write a method that prints the list of photos in album2.
		System.out.println("Delete the photo ’bear.jpg’:");
		manager.deletePhoto("bear.jpg");
		printPhotoManagere(album2.getPho());
		
		
		}

}

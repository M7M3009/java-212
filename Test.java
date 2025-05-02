
public class Test {
	public static void main(String[] args) {
		PhotoManager manager = new PhotoManager();
		Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple,	grass, green"));
		manager.addPhoto(photo1);
		Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass,wind"));
		manager.addPhoto(photo2);
		Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect,butterfly, flower, color"));
		manager.addPhoto(photo3);
		Album album1 = new Album("Album1", "apple", manager);
		Album album2 = new Album("Album2", "apple", manager);
		System.out.println("Get photo1 path and tags:");
		System.out.println("photo1 path: " + photo1.getPath());
		// You can get the list of tags of photo1 by calling photo1.getTags().
		System.out.println("Photo 1 Tags : ");
		printAllTags(photo1.getTags());
		// You can write a method that prints the list of tags of photo1.
		System.out.println("Get album2 name, condition, and photos:");
		System.out.println("album2 name: " + album2.getName());
		System.out.println("album2 condition: " + album2.getCondition());
		// You can get the list of photos in album2 by calling album2.getPhotos().
	System.out.println("Album Photos :");
		printPhotoManager(album2.getPhotos());
		// You can write a method that prints the list of photos in album2.
	System.out.println("Get number of comparisons: ");
	System.out.println(album2.getNbComps());
		manager.deletePhoto("bear.jpg");
		printPhotoManager(album2.getPhotos());
	
	}

	private static void printPhotoManager(LinkedList<Photo> list) {
		if (list.empty())
			return;
		list.findFirst();
		while (!list.last()) {
			System.out.print(list.retrieve().getPath() + " , ");
			list.findNext();
		}
		System.out.println(list.retrieve().getPath() + "");

	}

	private static void printAllTags(LinkedList<String> list) {
		list.findFirst();
		while (!list.last()) {
			System.out.print(list.retrieve() + " , ");
			list.findNext();
		}
		System.out.println(list.retrieve() + "");

	}

	private static LinkedList<String> toTagsLinkedList(String tags) {
		LinkedList<String> result = new LinkedList<String>();
		String[] tagsArray = tags.split("\\s*,\\s*");
		for (int i = 0; i < tagsArray.length; i++) {
			result.insert(tagsArray[i]);
		}
		return result;
	}

}
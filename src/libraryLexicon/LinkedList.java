package libraryLexicon;


/**
 * LinkedList represents a linked implementation of a list.
 * 
 * @author ktsiouni
 * @author kkontog
 * 
 */
import java.util.*;

public class LinkedList implements Iterable<FileNode> {
	private FileNode head, tail;

	/**
	 * This constructor creates an empty list.
	 */
	public LinkedList() {
		head = tail = null;
	}

	/**
	 * Returns the head of the linked list
	 * @return first node of thelinked list
	 */
	public FileNode getHead() {
		return head;
	}
	
	/**
	 * Returns the tail of the linked list
	 * @return last node of the linked list
	 */
	public FileNode getTail() {
		return tail;
	}
	
	/**
	 * Returns an iterator for the elements currently in this list.
	 *
	 * @return an iterator over the elements of this list
	 */
	public Iterator<FileNode> iterator() {
		return new LinkedIterator(head);
	}

	/**
	 * Inserts a new file node in the list
	 * 
	 * @param node	The file node to be added
	 */
	private void insertFileNode(FileNode node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head = node;
		}
	}
	
	/**
	 * Insert a new position of the specific word.
	 * 
	 * @param filename	The name of the file in which the word was found
	 * @param position	The word's position in the file
	 */
	public void insertWord(String filename, int position) {
		Iterator<FileNode> iterator = iterator();
		
		while (iterator.hasNext()) {
			FileNode current = iterator.next();
			if (filename.equals(current.getFilename())) {
				// If a file node for this file is found,
				// add the new position there.
				current.addPosition(position);
				return;
			}
		}
		
		// Create new node for the file.
		FileNode node = new FileNode(filename);
		// Add the new position.
		node.addPosition(position);
		// Insert the node in the list.
		insertFileNode(node);
		
	}

}


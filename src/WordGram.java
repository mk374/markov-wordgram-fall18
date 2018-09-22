/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Min Soo Kim
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = 0; i < myWords.length; i++) {
			myWords[i] = source[start + i];
		}
		myToString = null;
		myHash = 0;
		// TODO: initialize myWords and ...
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram og = (WordGram) o;
		String[] ogArray = og.myWords;
		for (int i = 0; i < myWords.length; i++) {
			if(!this.myWords[i] .equals (og.wordAt(i))) {
				return false;
			}
		}
	    // TODO: complete this method
		return true;
	}

	@Override
	public int hashCode(){
		
		if(myHash == 0 ) {
			String str1 = this.toString();
			myHash = str1.hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for (int i = 1; i < myWords.length; i++) {
			wg.myWords[i-1] = myWords[i];
		}
		wg.myWords[myWords.length - 1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method	
		myToString = String.join(" ", myWords);
		return myToString;
	}
}

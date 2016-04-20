package DataStructure;
/**
 * 
 * @author Mingkai_Ma
 *
 */
public class Dictionary {

	private LinkedList data;
	public int n;
	
	public Dictionary(){
	    data = new LinkedList();
	}
	/**
	 * Add a dictionary pair to dictionary
	 * @param key
	 * @param value
	 */
	public void add(Object key,Object value){
		DictionaryPair a = new DictionaryPair(key,value);
		data.addLast(a);
	}
	/**
	 * Get the size of dictionary
	 * @return
	 */
	public int getSize(){
		return data.size();
	}
	/**
	 * According the the key, get the position of the value
	 * @param key
	 * @return
	 */
	public int findPosition(Object key){
		for(int i=0;i<data.size();i++){
			if(((DictionaryPair) data.get(i)).getKey().equals(key)){
				return i;
			}
			else{
				continue;
			}
		}
		return -1;
	}
	/**
	 * According to the key,get the value
	 * @param key
	 * @return
	 */
	public Object find(Object key){
		for(int i=0;i<data.size();i++){
			if(((DictionaryPair) data.get(i)).getKey().equals(key)){
				return ((DictionaryPair) data.get(i)).getValue();
			}
			else{
				continue;
			}
		}
		return null;
	}
	/**
	 * According to the position,get the key
	 * @param n
	 * @return
	 */
	public Object getKey(int n){
		for(int i=0;i<data.size();i++){
			if(i == n){
				return ((DictionaryPair) data.get(i)).getKey();
			}
			else{
				continue;
			}
		}
		return null;
	}
	/**
	 * According to the position,get the value
	 * @param n
	 * @return
	 */
	public Object getValue(int n){
		for(int i=0;i<data.size();i++){
			if(i == n){
				return ((DictionaryPair) data.get(i)).getValue();
			}
			else{
				continue;
			}
		}
		return null;	
	}
	
}


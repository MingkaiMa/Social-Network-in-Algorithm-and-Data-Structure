package DataStructure;

public class DictionaryPair implements Comparable{

	private Object key;
	private Object value;
	
	public DictionaryPair(Object key,Object value){
		this.key=key;
		this.value=value;
	}
	
	public Object getKey(){
		return key;
	}
	
	public Object getValue(){
		return value;
	}
	
	public void setKey(Object newKey){
		key = newKey;
	}
	
	public void setValue(Object newValue){
		value = newValue;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

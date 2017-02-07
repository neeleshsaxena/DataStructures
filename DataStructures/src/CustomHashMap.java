
public class CustomHashMap<K,V> {
	
	private Entry<K,V>[] table;
	private int capacity =4;
	
	
	static class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K key,V value,Entry<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
	}
	
	public CustomHashMap(){
		table = new Entry[capacity];
	}
	
	public int hash(K key){
		int hash  = Math.abs(key.hashCode())%capacity;
		int a = Integer.bitCount(3);
		return hash;
	}
	
	public void put(K key, V value){
		if(key == null){
			System.out.println("Null values, returned");
			return;
			
		}
		
		int hash = hash(key);
		Entry<K,V> newEntry = new Entry<>(key,value,null);
		
		Entry<K,V> current = table[hash];
		if(current==null){
			table[hash] = newEntry;
			return;
		}
		else{
			Entry<K,V> head = current;
			while(current.next!=null){
				
				if(current.key.equals(newEntry.key) ){
					current.value = newEntry.value;
					return;
				}
				current = current.next;
				
				
			}
			
			current.next = newEntry;
			
			
		}
		
		
		
		
		
	}
	
	public V get(K key){
		
		int hash = hash(key);
		if(table[hash]==null){
			return null;
		}
		
		Entry<K,V> current = table[hash];
		
		while(current!=null){
			if(current.key.equals(key)){
				return current.value;
			}
			current = current.next;
			
		}
		
		return null;
	}
	
	
	public boolean remove(K key){
		
		int hash = hash(key);
		
		if(table[hash]==null){
			return false;
		}
		
		Entry<K,V> head = table[hash];
		Entry<K,V> current = head;
		Entry<K,V> previous = null;
		
		while(current!=null){
			if(current.key.equals(key)){
				
				//if the first linkedlist is to be deleted
				if(previous ==null){
					current = current.next;
					table[hash] = current;
					return true;
				}
				
				//if the node is placed somewhere else in the list
				previous.next = current.next;
				current = null;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	 public void display(){
	       
	       for(int i=0;i<capacity;i++){
	           if(table[i]!=null){
	                  Entry<K, V> entry=table[i];
	                  while(entry!=null){
	                        System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
	                        entry=entry.next;
	                  }
	           }
	       }             
	    
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<Integer, Integer>();
		
		hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);
        
        
        System.out.println("value corresponding to key 21="
                + hashMapCustom.get(21));
   System.out.println("value corresponding to key 51="
                + hashMapCustom.get(51));
   
   
   System.out.print("Displaying : ");
   hashMapCustom.display();
   
   hashMapCustom.remove(25);
   hashMapCustom.display();
   
   
	}

}

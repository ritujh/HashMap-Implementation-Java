public class Map<k,v>{
    ArrayList<MapNode<k,v>> buckets;
    int size;
    int numBuckets;
    public Map(){
        numBuckets = 20;
        buckets = new ArrayList<>();
        for(int i=0;i<numBuckets;i++){
            buckets.add(null);
        }
    }
    public void put(k key, v value){
        int bucketIndex = hashFunction(key);
        MapNode<k,v> head = buckets.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }else{
                head = head.next;
            }
        }
        size++;
        head = buckets.get(bucketIndex);
        MapNode<k,v> newNode = new MapNode(key,value);
        newNode.next = head;
        buckets.set(bucketIndex,newNode);
    }
    public int hashFunction(k key){
        int hashCode = key.hashCode();
        return hashCode%numBuckets;
    }

    public int size(){
        return size;
    }
    public v getValue(k key){
        int bucketIndex = hashFunction(key);
        MapNode<k,v> head = buckets.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }else{
                head = head.next;
            }
        }
        return null;
    }
    public v remove(k key){
        int bucketIndex = hashFunction(key);
        MapNode<k,v> head = buckets.get(bucketIndex);
        MapNode<k,v> prev = null;
        while(head!=null){
            if(head.key.equals(key)){
                if(prev==null){
                    buckets.set(bucketIndex,head.next);
                }
                prev.next = head.next;
                size--;
                return head.value;
            }else{
                prev = head;
                head = head.next;
            }
        }
        return null;
    }
}
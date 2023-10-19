public class HeapArray {
    public class Node {
        public Integer priority;
        public Node left, right;
    
        public Node(Integer priority) {
            this.priority = priority;
            left = right = null;
        }
    }

    Node[] heaps;
    int k;

    public HeapArray(int n){
        heaps = new Node[n];
        k = 0;
    }

    public void add(Integer priority){
        if(k >= heaps.length){
            return;
        }

        int i = k;
        heaps[i] = new Node(priority);
        k++;

        while(i != 0 && heaps[i].priority < heaps[(i - 1)/2].priority){
            Node temp = heaps[i];
            heaps[i] = heaps[(i - 1)/2];
            heaps[(i - 1)/2] = temp;
            i = (i - 1)/2;
        }
    }

    public Integer remove(){
        Node temp = heaps[0];
        heaps[0] = heaps[--k];
        heaps[k] = null;
        
        int i = 0;
        int depth = 1;
        while(true){
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < k && heaps[left].priority < heaps[smallest].priority){
                smallest = left;
            }
            if(right < k && heaps[right].priority < heaps[smallest].priority){
                smallest = right;
            }
            if(smallest != i){
                Node swap = heaps[i];
                heaps[i] = heaps[smallest];
                heaps[smallest] = swap;
                i = smallest;
                continue;
            }
            break;
        }
        return temp.priority;
    }

    public void push(Integer incr){
        heaps[0].priority += incr;

        int i = 0;
        while(true){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = k - 1;
            if(left < k && heaps[left].priority < heaps[smallest].priority){
                smallest = left;
            }
            if(right < k && heaps[right].priority < heaps[smallest].priority){
                smallest = right;
            }
            if(smallest != i){
                Node swap = heaps[i];
                heaps[i] = heaps[smallest];
                heaps[smallest] = swap;
                i = smallest;
                continue;
            }
            break;
        }
    }
}
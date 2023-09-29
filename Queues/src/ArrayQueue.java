public class ArrayQueue {
    int[] array;
    int index,k;
    int size;

    public ArrayQueue(int size) {
        array = new int[size];
        k = 0;
        index = 0;
        this.size = size;
    }

    public void add(int item) {
        array[k++] = item;

        if(k == size){
            k = 0;
        }

        if(k == index){
            int[] temp = new int[size * 2];
    
            for (int i = index; i < size - 1; i++) {
                temp[i - index] = array[i];
            }
    
            for (int i = 0; i < k - 1; i++) {
                temp[i + size - 1] = array[i]; 
            }
    
            k = size;
            size *= 2;
            index = 0;
            array = temp;
        }
    }

    public Integer remove() {
        if(index == k){
            index = 0;
            k = 0;
            return null;
        }

        int temp = array[index];
        array[index] = 0;
        index++;

        if(index == size){
            index = 0;
        }
        
        return temp;
    }
}

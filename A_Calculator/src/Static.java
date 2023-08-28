public class Static extends Stack{
    private int[] stack;
    private int pointer;

    public Static(int size){
        stack = new int[size];
        pointer = 0;
    }

    public int pop(){
        int value = stack[--pointer];
        stack[pointer] = 0; 
        return value;
    }

    public void push(int value){
        stack[pointer++] = value;
    }
}

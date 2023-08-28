public class Dynamic extends Stack {
    private int[] stack;
    private int pointer;

    public Dynamic(int size){
        stack = new int[size];
        pointer = 0;
    }

    public int pop(){
        if(pointer == stack.length/2){
            int[] newStack = new int[stack.length/2];
            for (int i = 0; i < stack.length/2; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        int value = stack[--pointer];
        stack[pointer] = 0; 
        return value;
    }

    public void push(int value){
        if(pointer == stack.length - 1){
            int[] newStack = new int[stack.length*2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[pointer++] = value;
    }
}

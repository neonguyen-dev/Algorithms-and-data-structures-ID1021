public class Dynamic extends Stack {
    private int[] stack;
    private int pointer;

    public Dynamic(int size){
        stack = new int[size];
        pointer = 0;
    }

    public int pop() throws Exception{
        pointer--;
        if(pointer < 0){
            throw new Exception("Stack Underflow");
        }

        if(pointer == (stack.length/4)){
            int[] tempStack = new int[stack.length/2];
            for (int i = 0; i < stack.length/2; i++) {
                tempStack[i] = stack[i];
            }
            stack = tempStack;
        }
        
        int value = stack[pointer];
        stack[pointer] = 0; 
        return value;
    }

    public void push(int value){
        if(pointer == stack.length){
            int[] tempStack = new int[stack.length*2];
            for (int i = 0; i < stack.length; i++) {
                tempStack[i] = stack[i];
            }
            stack = tempStack;
        }
        stack[pointer++] = value;
    }
}

public class Static extends Stack{
    private int[] stack;
    private int pointer;

    public Static(int size){
        stack = new int[size];
        pointer = 0;
    }

    public int pop() throws Exception{
        pointer--;
        if(pointer < 0){
            throw new Exception("Stack Underflow");
        }
        int value = stack[pointer];
        stack[pointer] = 0; 
        return value;
    }

    public void push(int value) throws Exception{
        if(pointer >= stack.length){
            throw new Exception("Stack Overflow");
        }
        stack[pointer++] = value;
    }
}

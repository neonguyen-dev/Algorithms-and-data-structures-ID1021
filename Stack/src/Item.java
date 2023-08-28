public class Item {
    private ItemType type;
    private int value = 0;

    private Item(int value){
        type = ItemType.VALUE;
        this.value = value;
    }

    private Item(ItemType type){
        this.type = type;
    }

    public ItemType type(){
        return type;
    }

    public int getValue(){
        return value;
    }

    public static Item Value(int value){
        return new Item(value);
    }

    public static Item Add(){
        return new Item(ItemType.ADD);
    }
    
    public static Item Sub(){
        return new Item(ItemType.MUL);
    }

    public static Item Mul(){
        return new Item(ItemType.MUL);
    }

    public static Item Div(){
        return new Item(ItemType.DIV);
    }
}

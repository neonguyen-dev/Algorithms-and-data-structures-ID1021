public class Heap {
    public class Node {
        Integer priority;
        Node left, right;
        int size;

        public Node(Integer priority) {
            this.priority = priority;
            left = right = null;
            size = 1;
        }
    }

    Node root;

    public Heap() {
        root = null;
    }

    public int add(Integer priority) {
        if (root == null) {
            root = new Node(priority);
            return 0;
        } else {
            Node currentNode = root;
            int depth = 1;

            while (true) {
                currentNode.size++;
                if (priority < currentNode.priority) {
                    int temp = currentNode.priority;
                    currentNode.priority = priority;
                    priority = temp;
                }

                if (currentNode.left == null) {
                    currentNode.left = new Node(priority);
                    return depth;
                } else if (currentNode.right == null) {
                    currentNode.right = new Node(priority);
                    return depth;
                } else {
                    if (currentNode.left.size <= currentNode.right.size) {
                        currentNode = currentNode.left;
                        depth++;
                        continue;
                    } else {
                        currentNode = currentNode.right;
                        depth++;
                        continue;
                    }
                }
            }
        }
    }

    public Integer remove() {
        if (root == null) {
            return null;
        }

        Integer value = root.priority;

        if (root.size == 1) {
            root = null;
            return value;
        } else {
            Node currentNode = root;

            while (true) {
                currentNode.size--;
                if (currentNode.left == null) {
                    currentNode.priority = currentNode.right.priority;
                    if (currentNode.right.left == null && currentNode.right.right == null) {
                        currentNode.right = null;
                        return value;
                    }
                    currentNode = currentNode.right;
                    continue;
                } else if (currentNode.right == null) {
                    currentNode.priority = currentNode.left.priority;
                    if (currentNode.left.left == null && currentNode.left.right == null) {
                        currentNode.left = null;
                        return value;
                    }
                    currentNode = currentNode.left;
                    continue;
                } else if (currentNode.right.priority < currentNode.left.priority) {
                    currentNode.priority = currentNode.right.priority;
                    if (currentNode.right.left == null && currentNode.right.right == null) {
                        currentNode.right = null;
                        return value;
                    }
                    currentNode = currentNode.right;
                    continue;
                } else {
                    currentNode.priority = currentNode.left.priority;
                    if (currentNode.left.left == null && currentNode.left.right == null) {
                        currentNode.left = null;
                        return value;
                    }
                    currentNode = currentNode.left;
                    continue;
                }
            }
        }
    }

    public void pushRemoveAndAdd(Integer incr) {
        int temp = root.priority += incr;
        this.remove();
        this.add(temp);
    }

    public int push(int incr) {
        root.priority += incr;
        int depth = 0;
        
        Node currentNode = root;
        while (true) {
            if(currentNode.priority < currentNode.right.priority && currentNode.priority < currentNode.left.priority)
                return depth;

            if (currentNode.left == null) {
                int temp = currentNode.priority;
                currentNode.priority = currentNode.right.priority;
                currentNode.right.priority = temp;
                if (currentNode.right.left == null && currentNode.right.right == null) {
                    return depth;
                }
                currentNode = currentNode.right;
                depth++;
                continue;
            } else if (currentNode.right == null) {
                int temp = currentNode.priority;
                currentNode.priority = currentNode.left.priority;
                currentNode.left.priority = temp;
                if (currentNode.left.left == null && currentNode.left.right == null) {
                    return depth;
                }
                currentNode = currentNode.left;
                depth++;
                continue;
            } else if (currentNode.right.priority < currentNode.left.priority) {
                int temp = currentNode.priority;
                currentNode.priority = currentNode.right.priority;
                currentNode.right.priority = temp;
                if (currentNode.right.left == null && currentNode.right.right == null) {
                    return depth;
                }
                currentNode = currentNode.right;
                depth++;
                continue;
            } else {
                int temp = currentNode.priority;
                currentNode.priority = currentNode.left.priority;
                currentNode.left.priority = temp;
                if (currentNode.left.left == null && currentNode.left.right == null) {
                    return depth;
                }
                currentNode = currentNode.left;
                depth++;
                continue;
            }
        }
    }
}

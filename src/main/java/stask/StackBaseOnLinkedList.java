package stask;

/**
 * @author: changjiale
 * @create: 2019/12/08 16:30
 * @description: 基于linkedList实现stack
 */
public class StackBaseOnLinkedList {
    private static class Node<T> {
        private Object data;
        private Node next;

        public Node(Object data) {
            this(data, null);
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData(){
            return data;
        }

        public Object setData(){
            return this.data;
        }
        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }

    private Node top = null;
    private int size;

    public void push(Object value) {
        Node newNode = new Node(value, null);
        //stack is empty
        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public Object pop() {
        if(top == null) {
            return -1;
        }
        Object value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        int cnt  = 0;
        Node p = top;
        while (p != null) {
            cnt ++;
            p = p.next;
        }
        return cnt;
    }


    public static void main(String[] args) {
        StackBaseOnLinkedList stackBaseOnLinkedList = new StackBaseOnLinkedList();
        stackBaseOnLinkedList.push(1);
        stackBaseOnLinkedList.push("%");
        stackBaseOnLinkedList.printAll();
        stackBaseOnLinkedList.clear();
        stackBaseOnLinkedList.printAll();

    }
}

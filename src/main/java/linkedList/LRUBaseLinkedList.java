package linkedList;

import java.util.Scanner;

/**
 * @author: changjiale
 * @create: 2019/11/26 22:41
 * @description:
 */
public class LRUBaseLinkedList<T> {

    private final static Integer DEFAUT_CAPACITY = 10;

    private SNode<T> headNode;

    private Integer length;

    private Integer capacity;


    public LRUBaseLinkedList() {
        this.headNode = new SNode<T>();
        this.capacity = DEFAUT_CAPACITY;
        this.length = 0;
    }


    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

    }


    private void add(T element) {
        //查找元素是否存在， 存在记录上一个节点位置
        SNode preNode = null;
       SNode node = headNode;
       while (node.getNext() != null) {
           if (element.equals(node.getNext().getElement())) {
                preNode = node;
                break;
           }
           node = node.getNext();
       }

       if (preNode != null) {
           deleteElemOptim(preNode);
           intsertElemAtBegin(element);

       } else {
           if (length >= this.capacity) {
               deleteElemAtEnd();
           }
           intsertElemAtBegin(element);
       }
    }

    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        if (ptr.getNext() == null) {
            return;
        }
        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;

    }

    private void intsertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }

    }
}

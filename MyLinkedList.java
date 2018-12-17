public class MyLinkedList<T> {
    Node first;
    Node last;
    int size;

    private class Node {
        T value;
        Node next;
    }

    void add(T item) {
        if (first == null) {
            Node newNode = new Node();
            newNode.value = item;
            this.first = newNode;
            this.last = newNode;
            this.size++;

        } else {
            Node newNode = new Node();
            newNode.value = item;
            this.last.next = newNode;
            this.last = newNode;
            this.size++;
        }
    }

    void printLinkedList(){
        if(first != null) {
            Node aux = first;
            System.out.println(aux.value);
            while (aux.next != null){
                System.out.println(aux.next.value);
                aux = aux.next;
            }
        }
    }
    

    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.printLinkedList();
    }

}

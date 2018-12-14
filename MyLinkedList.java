public class MyLinkedList<T> {
Node current;
int size;
public void add(T item) {
Node last = current;
if (last != null) {
last.next = item;
}
current = item;
item.previous = last;




Node temp = new Node();
temp.value = item;
Node aux;
if(this.head == null) {
this.head = item;
this.size = 1;
} else {
aux = this.head;
while(aux.next != null) {
aux = aux.next;
}
aux.next = item;
this.size++;
}
}
public T get(int index) {
T result;
if(index < this.size-1){
Node aux = this.head;
int i = 0;
if (i == index){
result = this.head;
} else {
while(i != index){
aux = aux.next;
i++;
}
result = aux;
}
} 
return result;
}
}
private class Node {
Node previous;
Node next;
T value;
}

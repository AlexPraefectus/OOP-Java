package list;

import java.io.Serializable;

class Node<E> implements Serializable {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}

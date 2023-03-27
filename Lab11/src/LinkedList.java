import java.util.Iterator;

public class LinkedList <T> implements Iterable<T> {
    private LinkedList<T> prev;
    private LinkedList<T> next;
    private LinkedList<T> first;
    private LinkedList<T> last;
    private T data;
    private static int size = 0;
    LinkedList(){
        first = this;
    }
    LinkedList(T data){
        this.data = data;
        first = this;
        size++;
    }
    public void add(T data){
        if(first.data == null){
            first.data = data;
            return;
        }
        LinkedList<T> t = new LinkedList<>(data);
        if(first == null){
            first = t;
        }
        LinkedList<T> node = first;
        while (node.next != null){
            node.last = t;
            node = node.next;
        }
        node.last = t;
        t.prev = node;
        t.first = node.first;
        t.last = t;
        node.next = t;
        size++;
    }
    public LinkedList<T> find(T data){
        LinkedList<T> node = first;
        while (node != null){
            if(node.data == data){
                break;
            }
            node = node.next;
        }
        return node;
    }
    public LinkedList<Person> findBySurname(String el){
        LinkedList<T> node = first;
        while (node != null){
            if(((Person)(node.data)).getSurname().equals(el)){
                return (LinkedList<Person>) node;
            }
            node = node.next;
        }
        return null;
    }
    public LinkedList<Person> findAllBySurname(String el){
        LinkedList<T> node = this;
        LinkedList<Person> res = new LinkedList<>();
        while (node != null){
            if(((Person)(node.data)).getSurname().equals(el)){
                assert node.data instanceof Person;
                res.add((Person) node.data);
            }
            node = node.next;
        }
        return res;
    }
    public LinkedList<T> findByName(String el){
        LinkedList<T> node = first;
        LinkedList<T> res = new LinkedList<>();
        while (node != null){
            if(((Person)(node.data)).getName().equals(el)){
                res.add(node.data);
            }
            node = node.next;
        }
        return res;
    }
    public void delete(LinkedList<Person> data){
        LinkedList<Person> node = data;
        if(node == null){
            throw new NullPointerException("Нет такого элемента");
        }
        if(node == node.first){
            if(node.next != null) {
                node.next.prev = null;
                node.next.first = node.next;
                this.first = (LinkedList<T>) node.next;
                node = node.next;
            }
            else {
                node.data = null;
                node.last = node;
            }
            while(node.next != null){
                node.next.first = node.first;
                node = node.next;
            }
        }
        else if(node == node.last){
            node.prev.next = null;
            while(node.prev != null){
                if(node.prev.next == null){
                    node.prev.last = node.prev;
                }else{
                    node.prev.last = node.prev.next.last;
                }
                node = node.prev;
            }
        }else {
            if(node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }else{
                node.data = null;
            }
        }
        size--;
    }
    public LinkedList<T> getPrev() {
        return prev;
    }
    public LinkedList<T> getNext() {
        return next;
    }
    public LinkedList<T> getFirst() {
        return first;
    }
    public LinkedList<T> getLast() {
        return last;
    }
    public T getData() {
        return data;
    }
    public LinkedList<T> get(T el){
        LinkedList<T> node = this;
        while(node != null){
            if (node.data != el){
                node = node.next;
            }else {
                break;
            }
        }
        if(node == null){
            throw new NullPointerException("Элемент " + el + " не найден");
        }
        return node;
    }
    public String toString(boolean reverse){
        String str = "";
        if(!reverse) {
            LinkedList<T> node = first;
            while (node != null) {
                str += node.data;
                node = node.next;
            }
            return str;
        }else{
            LinkedList<T> node = last;
            while (node != null){
                str += node.data;
                node = node.prev;
            }
        }
        return str;
    }

    public String toString(){
        return (String) getData();
    }
    public boolean isEmpty(){
        return this.data == null;
    }
    public static int getSize() {
        return size;
    }
    @Override
    public Iterator iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<T> {
        private LinkedList<T> cursor = first;
        @Override
        public T next() {
            T item = cursor.data;
            cursor = cursor.next;
            return item;
        }
        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        @Override
        public void remove(){}
    }
}

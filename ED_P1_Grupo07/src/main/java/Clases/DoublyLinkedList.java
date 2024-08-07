/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author José Marin
 */
public class DoublyLinkedList<E> implements List<E> {
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    
    public DoublyLinkedList(){
        this.header = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return header == null && last == null;
    }
    
    public int size() {
        int size = 0;
        DoublyNodeList<E> n; 
        for (n = header ; n!= null ; n = n.getNext( )) {
            size++;
        }
        return size;
    }
    
    public DoublyNodeList<E> getHeader() {
        return header;
    }

    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }

    public DoublyNodeList<E> getLast() {
        return last;
    }

    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
   
    private void recorrerHaciaAtras(){
        DoublyNodeList<E> n;
        for (n = last ; n != header; n = n.getPrevious()){
        }
    }
    
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addLast(E e) {
        if (e != null){
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            if(last==header){
                if(last==null){
                    newNode.setNext(null);
                    newNode.setPrevious(null);
                    this.header = newNode;
                    this.last = newNode;
                }else{
                    newNode.setPrevious(last);
                    last.setNext(newNode);
                    this.setLast(newNode);
                }
            }else{
                newNode.setPrevious(last);
                last.setNext(newNode);
                this.setLast(newNode);
            }
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if(header==null){
            return null;
        }
        E doublyNodeList = header.getContent();
        if(header==last){
            header = null;
            last = null;
        }else{
            DoublyNodeList<E> nodo = header.getNext();
            nodo.setPrevious(null);
            header = nodo;
        }
        return doublyNodeList;
    }

    @Override
    public E removeLast() {
        if(header==null){
            return null;
        }
        E doublyNodeList = header.getContent();
        if(header==null){
            header = null;
            last = null;
        }else{
            DoublyNodeList<E> nodo = last.getPrevious();
            nodo.setNext(null);
            last = nodo;
        }
        return doublyNodeList;
    }
    
    public void setAll(List<E> listita){
        for (E element : listita) {
            addLast(element);
        }
    }
    
    @Override
    public String toString(){
        String s="";
        for(DoublyNodeList<E> n=header;n!=null;n=n.getNext()){
            s+=n.getContent()+",";
        }
        return s;
    }

    @Override
    public void clear() {
        header = null;
        last = null;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        DoublyNodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getContent();
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DoublyNodeList<E> current = header;
            private DoublyNodeList<E> lastReturned = null;
        @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = current;
                E element = current.getContent();
                current = current.getNext();
                return element;
            }

            @Override
            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException();
                }
                DoublyNodeList<E> nextNode = lastReturned.getNext();
                DoublyNodeList<E> prevNode = lastReturned.getPrevious();

                if (prevNode == null) { // Removing the header
                    header = nextNode;
                } else {
                    prevNode.setNext(nextNode);
                }

                if (nextNode == null) { // Removing the last
                    last = prevNode;
                } else {
                    nextNode.setPrevious(prevNode);
                }

                lastReturned = null; // reset lastReturned
            }
        };
    }


    @Override
    public E find(Comparator<E> comp, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> findAll(Comparator<E> comp, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

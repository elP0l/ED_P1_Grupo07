/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author José Marin
 */
public class DoublyCircularLinkedList<E> implements List<E> {
    
    private DoublyCircularNodeList<E> last;

    public DoublyCircularNodeList<E> getLast() {
        return last;
    }
    
    public E get(int index){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean addLast(E e) {
        if(e!=null){
            DoublyCircularNodeList<E> newNode = new DoublyCircularNodeList<>(e);
            if(last!=null){
                newNode.setNext(last.getNext());
                last.getNext().setPrevious(newNode);
                newNode.setPrevious(last);
                last.setNext(newNode);
                last = newNode;
            }else{
                newNode.setNext(newNode);
                newNode.setPrevious(newNode);
                last = newNode;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     @Override
     public Iterator<E> iterator() {
         return new Iterator<E>() {
            private DoublyCircularNodeList<E> current = last != null ? last.getNext() : null;
            private DoublyCircularNodeList<E> lastReturned = null;
            private boolean firstIteration = true;

            @Override
            public boolean hasNext() {
                return current != null && (firstIteration || current != last.getNext());
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list");
                }
                E element = current.getContent();
                lastReturned = current;
                current = current.getNext();
                firstIteration = false;
                return element;
            }

            @Override
            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException("remove() can only be called once after next()");
                }

                DoublyCircularNodeList<E> previous = lastReturned.getPrevious();
                DoublyCircularNodeList<E> next = lastReturned.getNext();

                previous.setNext(next);
                next.setPrevious(previous);

                if (lastReturned == last) {
                    last = previous;
                }

                lastReturned.setNext(null);
                lastReturned.setPrevious(null);
                lastReturned = null;
            }
        };
    }
     public void setLast(DoublyCircularNodeList<E> last) {
        this.last = last;
    }
     
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            DoublyCircularNodeList<E> current = last.getNext();
            while (current != last) {
                DoublyCircularNodeList<E> nextNode = current.getNext();
                current.setNext(null);
                current.setPrevious(null);
                current = nextNode;
            }
            last.setNext(null);
            last.setPrevious(null);
            last = null;
        }
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> findAll(Comparator<E> comp, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void readAllPngFiles(Path dirPath,String ext) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath, "*.png")) {
            for (Path entry : stream) {
                addLast((E) (ext+"/"+entry.getFileName().toString()));
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyCircularNodeList<E> current = last.getNext();
        sb.append(current.getContent()).append(",");
        while (current != last) {
            sb.append(current.getNext().getContent()).append(",");
            current = current.getNext();
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
    
    


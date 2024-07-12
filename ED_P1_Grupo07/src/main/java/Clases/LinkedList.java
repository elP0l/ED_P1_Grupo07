/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Iterator;
import javafx.scene.image.ImageView;

/**
 *
 * @author José Marin
 */
public class LinkedList<E> implements List<E> {
     private NodeList<E> header;
    private NodeList<E> last;
    //private int size = 0;
    
    public LinkedList(){
        this.header=null;
        this.last=null;
    }
    public NodeList<E> getHeader() {
        return header;
    }

    public void setHeader(NodeList<E> header) {
        this.header = header;
    }
    public E get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        NodeList<E> currentNode = header;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getContent();
    }
    public NodeList<E> getLast() {
        return last;
    }

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        //size++;
        if(e!=null) {
            NodeList<E> newNode=new NodeList<>(e); 
            newNode.setNext(header); 
            this.setHeader(newNode); 
            return true;
        } else {
            return false;
        }
    }
    @Override
    public E find(Comparator<E> comp, E element){
        NodeList<E> he = header;
        while (he != null) {
            if (comp.compare(he.getContent(), element) == 0) {
                return he.getContent(); 
            }
            he = he.getNext();
        }
        return null; 
    }
     @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    
    private NodeList<E> getPrevious(NodeList<E> node){
        NodeList<E> previous = null;
        NodeList<E> n;
        
        for(n = header; n!=node; n= n.getNext()){
            previous = n;
        }
        return previous;
    }
    
    private void recorrerHaciAtras(){
        NodeList<E> n;
        
        for (n = last; n != header; n = this.getPrevious(n)){
            System.out.println(n);
        }
    }

    @Override
    public boolean addLast(E e) {
        //size++;
        if(e!=null){
            NodeList<E> newNode = new NodeList<>(e);
            if(last !=null){
                last.setNext(newNode);
            }
            last=newNode;
            
            if(header == null){
                header = newNode;
            }
            return true;
        } else {
            return false;
        }  
    }
    @Override
    public E removeFirst() {
        if (header == null){
            return null;
        }
        if (header == last){
            E nodeList = header.getContent();
            header = null;
            last = null;
            return nodeList;
        }        
        NodeList<E> nodo = header.getNext();
        header = nodo;
        E nodeList = header.getContent();
        return nodeList;
    }

    @Override
    public E removeLast() {
        if (header == null){
            return null;
        }
        if (header == last){
            E nodeList = header.getContent();
            header = null;
            last = null;
            return nodeList;
        }
        NodeList<E> nodo = header;
        for (NodeList<E> n=header ; n.getNext()!=last ; n= n.getNext()){
            nodo = n;
        }
        E nodeList = last.getContent();
        nodo.setNext(null);
        return nodeList;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodeList<E> current = header;
        while (current != null) {
            sb.append(current.getContent()).append(",");
            current = current.getNext();
        }
        // Eliminar la última coma si hay elementos en la lista
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    @Override
    public int size() {
        int size = 0;
        NodeList<E> n; 
        for (n = header ; n!= null ; n = n.getNext( )) {
            size++;
        }
        return size;
    }
    @Override
    public boolean isEmpty() {
        return header==null;
    }
    @Override
    public void clear() {
        header = null;
        last = null;
    }
    
    public void add1(ImageView imageView) {
        NodeList newNode = new NodeList(imageView);
        if (header == null) {
            header = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size();
    }
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            NodeList<E> newNode = new NodeList<>(element);
            NodeList<E> current = header;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }
    @Override
   public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        E removedElement;
        if (index == 0) {
            removedElement = removeFirst();
        } else if (index == size() - 1) {
            removedElement = removeLast();
        } else {
            NodeList<E> current = header;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedElement = current.getNext().getContent();
            current.setNext(current.getNext().getNext());
        } 
        return removedElement;
    }
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        NodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        E oldElement = current.getContent();
        current.setContent(element);
        return oldElement;
    }
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it=new Iterator<E>() {
                NodeList<E> cursor = header;   
            @Override
            public boolean hasNext() {
                return cursor != null;
            }
            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                return e;
            }
        };
        return it;
    }
    @Override
    public List<E> findAll(Comparator<E> comp, E element) {
        LinkedList<E> re = new LinkedList<>();
        NodeList<E> he = header;
        while (he != null) {
            if (comp.compare(he.getContent(), element) == 0) {
                re.addLast(he.getContent());
            }
            he = he.getNext();
        }
        return re;
     }
    
    public void setAll(LinkedList<E> newCollection) {
        header = null; // Vaciar la lista actual
        // Añadir todos los elementos de la nueva colección
        NodeList<E> nodo;
        for (nodo = newCollection.getHeader();nodo!=null;nodo=nodo.getNext()) {
            addLast(nodo.getContent());
        }
    }
    
    public void readAllLines(Path path) throws IOException {
        Files.lines(path).forEach(line -> addLast((E) line));
    }
    
}
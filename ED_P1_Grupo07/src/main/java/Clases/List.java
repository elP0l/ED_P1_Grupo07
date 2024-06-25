/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author José Marin
 */
public interface List<E> {
    public E removeLast();
    public E removeFirst();
    public boolean addFirst(E e); 
    public E find(Comparator<E> comp, E element);
    public int compare(Integer o1, Integer o2);  
    public boolean addLast(E e);
    public int size();
    public Iterator<E> iterator();
    public boolean isEmpty();
    public void clear();
    public void add(int index, E element);
    public E set(int index, E element);
    //public List<E> findIntersection(List<E> another, Comparator<E> cmp);
    public List<E> findAll(Comparator<E> comp, E element);
    public E remove(int index);
}

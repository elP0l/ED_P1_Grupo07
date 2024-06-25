/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author José Marin
 */
public class DoublyCircularNodeList<E> {
    
    private E content;
    private DoublyCircularNodeList<E> next;
    private DoublyCircularNodeList<E> previous;

    public DoublyCircularNodeList(E content) {
        this.content = content;
        this.next = this;
        this.previous = this;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public DoublyCircularNodeList<E> getNext() {
        return next;
    }

    public void setNext(DoublyCircularNodeList<E> next) {
        this.next = next;
    }

    public DoublyCircularNodeList<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyCircularNodeList<E> previous) {
        this.previous = previous;
    }
    
    
    
    
    
}

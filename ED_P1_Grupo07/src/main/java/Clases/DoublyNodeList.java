/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author José Marin
 */
public class DoublyNodeList<E> {
    
    private E content;
    private DoublyNodeList<E> next;
    private DoublyNodeList<E> previous;
    
    public DoublyNodeList(E content){
        this.content = content;
        this.next = null;
        this.previous = null;
    }
    
    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public DoublyNodeList<E> getNext() {
        return next;
    }

    public void setNext(DoublyNodeList<E> next) {
        this.next = next;
    }

    public DoublyNodeList<E> getPrevious(){
        return previous;
    }

    public void setPrevious(DoublyNodeList<E> previous) {
        this.previous = previous;
    }
    
}

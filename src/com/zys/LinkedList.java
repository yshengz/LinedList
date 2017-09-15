package com.zys;

/**
 * Created by zys on 2017/9/14.
 * 链表基本操作
 */
public class LinkedList {
    Node head = null;//链表头

    /**
     * 增加数据
     * @param data 插入的数据
     */
    public void addNode(int data){
        Node  newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * 删除数据
     * @param index 删除第index个数据
     * @return true 成功 false 失败
     */
    public boolean deleteNode(int index){
        if(index<1||index>length()){
            return false;
        }
        if(index==1){
            head = head.next;
            return true;
        }else{
            int i = 2;
            Node perNode = head;
            Node curNode = perNode.next;
            while(curNode.next!=null){
                if(i==index){
                    perNode.next = curNode.next;
                    return true;
                }
                perNode = curNode;
                curNode = perNode.next;
                i++;
            }
            return true;
        }
    }

    /**
     * 链表长度
     * @return 链表的长度
     */
    public int length(){
        int length = 0;
        Node temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 链表排序
     * @return 返回头结点
     * 从小到大，插入排序
     */
    public Node orderList(){
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while(curNode.next!=null){
            nextNode= curNode.next;
            while(nextNode!=null){
                if(curNode.data>nextNode.data){
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 输出链表数据
     */
    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     *主函数测试
     */
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(9);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(3);
        linkedList.addNode(2);
        linkedList.addNode(3);
        System.out.println("length:"+ linkedList.length());
        linkedList.printList();
        linkedList.deleteNode(1);
        System.out.println("length:"+ linkedList.length());
        linkedList.printList();
        System.out.println("before:");
        linkedList.printList();
        linkedList.orderList();
        System.out.println("after");
        linkedList.printList();
    }
}
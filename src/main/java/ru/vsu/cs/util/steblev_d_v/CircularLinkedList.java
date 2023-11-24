package ru.vsu.cs.util.steblev_d_v;

public class CircularLinkedList {

    class Node {

        private int numberOfCard;
        Purpose purpose;
        Node nextNode;


        public Node(int numberOfCard, Purpose purpose) {
            this.numberOfCard = numberOfCard;
            this.purpose = purpose;
        }

        @Override
        public String toString() {
            return "NumberOfCard" + numberOfCard +  "Purpose" + purpose;
        }
    }

    private Node head = null;
    private Node tail = null;


    public void addNode(Purpose purpose, int numberOfCard) {
        Node newNode = new Node(numberOfCard, purpose);
        if (head == null){
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
        tail.nextNode = head;
    }

    public int size() {
        int size = 0;
        Node currentNode = head;
        if (head != null) {
            size++;
            while (currentNode.nextNode != tail.nextNode) {
                size++;
                currentNode = currentNode.nextNode;
            }
        }
        return size;
    }

    public String get(int index) {
        if(index > this.size() - 1) {
            throw new IndexOutOfBoundsException("Индекс превышает размер списка!");
        }

        int curInd = 0;
        Node curNode = head;
        while (curNode != tail.nextNode){
            if(curInd == index) {
                System.out.println("Элемент списка под индесом " + "'" + index + "'"+ " следующий: " + curNode.toString());
                return curNode.toString();
            }
            curNode = curNode.nextNode;
            curInd++;
        }
        return curNode.toString();
    }

    @Override
    public String toString() {
        return "CircularLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

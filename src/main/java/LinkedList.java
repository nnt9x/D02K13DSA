public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int x) {
        // Tạo node mới ->có data = x
        Node tmp = new Node(x);
        // Trỏ node mới -> head hiện tại
        tmp.setNext(head);
        // Gán node hiện tại bằng tmp
        head = tmp;
        // Tăng size lên 1 đơn vị
        size++;
    }

    public void addLast(int x) {
        // Tạo node mới ->có data = x
        Node tmp = new Node(x);
        // Tìm ra node cuối ?? -> cần tìm ra node cuối hiện tại
        // Node-> next = null
        Node lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        // Đã có node cuối
        lastNode.setNext(tmp);
        size++;
    }

    public void add(int x, int position) {
        if (position == 0) {
            addFirst(x);
        } else if (position == size) {
            addLast(x);
        } else if (position > size) {
            throw new RuntimeException("Không thể thêm!");
        } else {
            // Phần chính ở đây
            Node tmp = new Node(x);
            // Tìm position -1
            Node previousPositionNode = null;
            for (int i = 0; i <= position - 1; i++) {
                if (previousPositionNode == null) {
                    previousPositionNode = head;
                } else {
                    previousPositionNode = previousPositionNode.getNext();
                }
            }
            Node positionNode = previousPositionNode.getNext();
            previousPositionNode.setNext(tmp);
            tmp.setNext(positionNode);
            size++;
        }
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    // Xoá
    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Linked list is empty");
        }
        // Lấy head hiện tại
        Node tmp = head.getNext();
        head.setNext(null);
        head = tmp;
        // Giam size
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Linked list is empty");
        }
        // Lấy ra vị trí gần cuối
        // Node.getNext().getNext() == null
        Node nearLastNode = head;
        while (nearLastNode.getNext().getNext() != null) {
            nearLastNode = nearLastNode.getNext();
        }
        nearLastNode.setNext(null);
        size--;
    }

    public void remove(int position) {
        if (isEmpty()) {
            throw new RuntimeException("Linked list is empty");
        }

        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeLast();
        } else {
            Node previousNode = null;
            for (int j = 0; j <= position - 1; j++) {
                if (previousNode == null) {
                    previousNode = head;
                } else {
                    previousNode = previousNode.getNext();
                }
            }
            Node currentNode = previousNode.getNext();
            Node nextNode = currentNode.getNext();

            previousNode.setNext(nextNode);
            currentNode.setNext(null);
            size--;
        }
    }

    public void display() {
        Node tmp = null;
        System.out.print("LinkedList:  ");
        for (int i = 0; i < size; i++) {
            if (tmp == null) {
                tmp = head;
            }
            System.out.print(tmp + "-->");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

}

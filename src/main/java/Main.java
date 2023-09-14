public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(8);
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.display();
        // Thêm 30 vào position 1??
        // 10->8->20
        // 10->30->8->20
        linkedList.add(30,1);
        linkedList.display();
        // Xoa vi tri dau tien: 30->8->20
        linkedList.removeFirst();
        linkedList.display();
        linkedList.removeLast(); // 30->8
        linkedList.display();
        // Them du lieu
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.display();
        // 30-->8-->40-->50-->
        // xoa position 2
        linkedList.remove(2); // 30->8->50
        linkedList.display();

    }
}

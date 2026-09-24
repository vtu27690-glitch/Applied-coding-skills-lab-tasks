import java.util.*;

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Remove cycle
    static void removeCycle(Node head) {
        Node slow = head, fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        Node temp = slow;
        while (temp.next != slow)
            temp = temp.next;

        temp.next = null;
    }

    // Reverse in groups of K
    static Node reverse(Node head, int k) {
        Node prev = null, cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head.next = cur;
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Node head = null, tail = null;
        Node[] a = new Node[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Node(sc.nextInt());

            if (head == null)
                head = a[i];
            else
                tail.next = a[i];

            tail = a[i];
        }

        int pos = sc.nextInt();

        if (pos != -1)
            tail.next = a[pos];

        removeCycle(head);

        head = reverse(head, k);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

input 
  8 3
  10 20 30 40 50 60 70 80 
  2
output
  30 20 10 60 50 40 80 70

i

package cn.melon.study.linklist;

import java.util.Stack;

/**
 * 链表反转
 *
 * @author imelonkid
 * @date 2021/09/15 10:57
 **/
public class LinkedReverseDemo {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        LinkedReverseDemo demo = new LinkedReverseDemo();
        Node newLink = demo.reveseNodeList3(node1);
        System.out.println("");
    }


    /**
     * 思想：定义三个指针，分别指向前序节点，当前节点，和后继节点
     * 更新当前节点指针为前序节点，并后移当前节点到后继节点
     *
     * @param sourceNode
     * @return
     */
    public Node reveseNodeList(Node sourceNode) {
        // 定义三个指针
        Node pre = null;
        Node curr = sourceNode;
        Node next = null;

        // 遍历链表
        while (curr != null) {
            next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }

        return pre;
    }

    /**
     * 思想：借助栈
     *
     * @param sourceNode
     * @return
     */
    public Node reveseNodeList2(Node sourceNode) {
        // 定义三个指针
        Stack<Node> stack = new Stack<>();

        // 遍历链表
        while (sourceNode != null) {
            stack.push(sourceNode);
            sourceNode = sourceNode.next;
        }

        Node finalNode = null;
        Node cursor = null;
        while (!stack.isEmpty()) {
            if (finalNode == null) {
                finalNode = stack.pop();
                cursor = finalNode;
                continue;
            }
            cursor.next = stack.pop();
            cursor = cursor.next;
        }
        return finalNode;
    }

    /**
     * 思想：借助额外队列实现反转
     *
     * @param sourceNode
     * @return
     */
    public Node reveseNodeList3(Node sourceNode) {
        Node finalNode = null;
        while (sourceNode != null) {
            Node tmp = sourceNode.next;
            sourceNode.next = finalNode;

            finalNode = sourceNode;
            sourceNode = tmp;
        }

        return finalNode;
    }
}


class Node {

    public int val;
    public Node next;


    public Node(int val) {
        this.val = val;
    }
}

public class BST<T> {

    class Node {
        Comparable data;
        Node left;
        Node right;
        Node(Comparable data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    BST(){
        this.root = null;
    }

    boolean find(Comparable target, Node node){
        if(node == null){
            return false;
        }
        if(target.equals(node.data)){
            return true;
        }
        if(target.compareTo(node.data) > 0){
            return find(target, node.left);
        } else {
            return find(target, node.right);
        }
    }

    boolean find(Comparable target){
        return find(target, root);
    }

    Node insert(Comparable item, Node node){
        if(node == null){
            return new Node(item);
        }
        if(item.compareTo(node.data) == 0){
            return node;
        }
        if(item.compareTo(node.data) == -1){
            node.left = insert(item, node.left);
        }
        return node.right = insert(item, node.right);
    }
    void insert(Comparable item){
        root = insert(item, root);
    }

    Node delete(Node node, Comparable item){
        if(node == null){
            return null;
        }
        if(node.data == item){
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            if(node.right.left == null){
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            } else {
                node.data = removeSmallest(node.right);
                return node;
            }
        }
        if(node.data.compareTo(item) == -1){
            node.right = delete(node.right, item);
            return node;
        } else {
            node.left = delete(node.left, item);
            return node;
        }
    }

    void delete(Comparable item){
        root = delete(root, item);
    }

    Comparable removeSmallest(Node node){
        if(node.left.left == null){
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return removeSmallest(node.left);
        }
    }

    public void print(Node node){
        if(node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    public void print(){
        print(root);
    }
}

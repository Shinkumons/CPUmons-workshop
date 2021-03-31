
public class ChainList {

    public Node head = new Node(null, null);
    
    public static void main (String [] args) {
    }

    public ChainList() {
    }


    public Object get(int user_index){
        /*1 positional argument : index of the element
            return the element at the position *index* */
        
        int index = user_index;
        if (index < 0) {
            index = this.length() + index;
        }

        
        Node currentNode = this.head;
        for (int i=0; i<index; i++) {
            if(currentNode != null) {
                currentNode = currentNode.next;
            } else {
                throw new java.lang.ArrayIndexOutOfBoundsException();
            }
        }

        return currentNode.item;
    }

    


    public void add(Object item) {
        /*1 positional argument : Object
          Don't return just add the Object at the end of the list*/
        
        Node currentNode = head;

        if (head.item == null) {
            head.item = item;
            return;
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(null, item);
    }

    

    public void add(Object item, int user_index) {
        /*2 positional argument : Object, index
          Don't return anything, just add Object at the position index*/
        
        int index = user_index;
        if (index < 0) {
            index = this.length() + index;
        }


        
        Node currentNode = head;

        if (index == 0) {
            Node newHead = new Node(head, item);
            head = newHead;
            return;
        }

        for (int i=0; i<index - 1; i++) {
            if (currentNode != null){
                currentNode = currentNode.next;
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        Node nextNode = new Node(currentNode.next, item);
        currentNode.next = nextNode;
    }

    

    public String toString(){
        String res = "[";
        Node currentNode = head;
        while (currentNode.item != null) {
            res += currentNode.item.toString();
            if (currentNode.next == null || currentNode.next.item == null) {
                break;
            }
            res += ", ";
            currentNode = currentNode.next;
        }

        res += "]";
        return res;
    }



    
    public void remove(int user_index) {
        /*1 positional argument : index
          Remove the element of the list at the position *index* */

        int index = user_index;
        if (index < 0) {
            index = this.length() - index;
        }

        
        Node currentNode = head;

        if (index == 0) {
            if (head.next == null) {
                head.item = null;
                return;
            }
            head = head.next;
            return;
        }

        for (int i=0; i<index-1; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null){
            currentNode.next = currentNode.next.next;
        } else { throw new java.lang.ArrayIndexOutOfBoundsException();}
    }

    

    public int length(){
        /*No positional argument
          return an int value : the length of the list*/

        Node currentNode = head;
        int count = 0;

        if(head.item == null) {
            return 0;
        }

        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }

        return count;
    }



    public boolean contains(Object item) {
        /*1 positional argument : Object
          return true if Object is in the list, false in the other case*/

        
        Node currentNode = head;

        while(currentNode != null) {
            if(currentNode.item == item) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }


    public int index(Object item) {
        /*1 positional argument : Object
          return the position(int) of the Object in the list*/
        
        Node currentNode = head;
        int count = 0;

        while(currentNode != null) {
            if (currentNode.item == item) {
                return count;
            }

            currentNode = currentNode.next;
            count++;
        }

        return -1;
    }

    public Object pop(int user_index){
        int index = user_index;
        if (user_index < 0) {
            index = this.length() + user_index - 1;
        }


        Node currentNode = head;

        if (index == 0) {
            if (head.next == null) {
                head.item = null;
                return null;
            }
            Object value = head.item;
            head = head.next;
            return value;
        }

        for (int i=0; i<index-1; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null){
            Object value = currentNode.next.item;
            currentNode.next = currentNode.next.next;
            return value;
        } else { throw new java.lang.ArrayIndexOutOfBoundsException();}
        
    }


    public void set(Object item, int user_index) {
        int index = user_index;
        Node currentNode = head;

        if (user_index < 0) {
            index = this.length() + user_index - 1;
        }

        if (index == 0) {
            head.item = item;
            return;
        }

        for (int i=0; i<index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.item = item;

        return;
    }

    public void removeRange(int user_indexFrom, int user_indexTo) {
        int range;

        int indexTo = user_indexTo;
        int indexFrom = user_indexFrom;

        if (user_indexTo < 0) {
            indexTo = this.length() + user_indexTo;
        }

        if (user_indexFrom < 0) {
            indexFrom = this.length() + user_indexFrom;
        }

        range = indexTo - indexFrom;

        for (int i=0; i < range; i++) {
            this.remove(user_indexFrom);
        }
    }

    public boolean isEmpty() {
        if (this.head.item == null && this.head.next == null) {
            return true;
        }

        return false;
    }


    public void clear(){
        head = new Node(null, null);
    }


    public int indexOf(Object item) {
        Node currentNode = head;
        int count = 0;

        while (currentNode.next != null) {
            
            
            if (currentNode.item == item) {
                return count;
            }
            currentNode = currentNode.next;
            count++;           
        }

        return -1;
    }


    public ChainList add(ChainList l2) {
        Node currentNode = this.head;

        ChainList result = new ChainList();
        
        while(currentNode != null) {
            result.add(currentNode.item);
            currentNode = currentNode.next;
        }

        currentNode = l2.head;

        while(currentNode != null) {
            result.add(currentNode.item);
            currentNode = currentNode.next;
        }

        return result;
    }

    /*
      

      It doesn't work because non specified type in the list. 

      #TODO in next version : specify type of chained list at initalising.


    public void sort(){
        Node currentNode_1 = head;
        Node currentNode_2 = head;

        Object max;


        for (int i=0; i<this.length() - 1; i++) {
            for (int j=i; j<this.length() - 1; j++) {
                if (currentNode_2.item < currentNode_2.next.item) {
                    max = currentNode_2.next.item;
                } else if (currentNode_2.item > currentNode_2.next.item){
                    max = currentNode_2.item;
                }

                currentNode_2 = currentNode_2.next;
            }

            int index = this.indexOf(max);
            this.set(this.get(i), index);
            this.set(max, i);


            currentNode_1 = currentNode_1.next;
            currentNode_2 = currentNode_1;
        }
    }*/
}

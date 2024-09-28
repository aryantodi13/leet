class MyCircularDeque {
    int[] q;
    int start;
    int end;
    int counter;
    int len;
    public MyCircularDeque(int k) {
        q = new int[k];
        start = 0;
        end = 0;
        counter = 0;
        len = k;
    }
    
    public boolean insertFront(int value) {
        if(counter == len) return false;
        if(start == 0){
            q[len - 1] = value;
            start = len - 1;
            counter++;
            return true;
        }
        else{
            q[--start] = value;
            counter++;
            return true;
        }
    }
    
    public boolean insertLast(int value) {
        if(counter == len) return false;
        if(end == len - 1){
            q[end] = value;
            end = 0;
            counter++;
        }
        else{
            q[end++] = value;
            counter++;
        }
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(start == len - 1) start = 0;
        else start++;
        counter--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(end == 0) end = len - 1;
        else end--;
        counter--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return q[start];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        if(end == 0) return q[len - 1];
        return q[end - 1];
    }
    
    public boolean isEmpty() {
        return counter == 0;
    }
    
    public boolean isFull() {
        return counter == len;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
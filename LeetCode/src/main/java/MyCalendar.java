class MyCalendar {

    Node root = null;
    
        
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        
        if(root==null){
            root = new Node(start,end);
            return true;
        }
        
        Node curr = new Node(start,end);
        Node p = root;
        while(p!=null){
            if(p.start>=end){
                if(p.left == null){
                    p.left = curr;
                    return true;
                }
                p = p.left;
            }
            else if(p.end<=start){
                if(p.right==null){
                    p.right = curr;
                    return true;
                }
                p = p.right;
            }
            else
                return false;
        }
        return false;
    }
}
class
    Node{
        int start,end;
        Node right, left;
        Node(int s , int e){
            start = s ; end = e;
            right = null; left = null;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
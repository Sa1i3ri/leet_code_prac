import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int n = queue.size();
        for(int i =0;i<n-1;i++){
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int n = queue.size();
        for(int i =0;i<n-1;i++){
            queue.add(queue.poll());
        }
        int res = queue.peek();
        queue.add(queue.poll());
        return res;
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
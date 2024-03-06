import java.util.Stack;

class MyQueue {
    private Stack<Integer>[] stack;
    private int num;
    private boolean isLegal;

    public MyQueue() {
        this.stack = new Stack[2];
        for(int i =0;i<stack.length;i++){
            stack[i] = new Stack<>();
        }
        this.num=0;
        this.isLegal = false;
    }

    public void push(int x) {
        Stack<Integer> curStack = getCurStack();
        if(!isLegal){
            curStack.push(x);
        }else{
            Stack<Integer> otherStack = getOtherStack();
            while (!curStack.isEmpty()){
                otherStack.push(curStack.pop());
            }
            otherStack.push(x);

            update();
        }
    }

    public int pop() {
        Stack<Integer> curStack = getCurStack();
        if(isLegal){
            return curStack.pop();
        }else{
            Stack<Integer> otherStack = getOtherStack();
            while (!curStack.isEmpty()){
                otherStack.push(curStack.pop());
            }
            update();
            return otherStack.pop();
        }
    }

    public int peek() {
        Stack<Integer> curStack = getCurStack();
        if(isLegal){
            return curStack.peek();
        }else{
            Stack<Integer> otherStack = getOtherStack();
            while (!curStack.isEmpty()){
                otherStack.push(curStack.pop());
            }
            update();
            return otherStack.peek();
        }
    }

    public boolean empty() {
        return getCurStack().isEmpty();
    }

    private Stack<Integer> getCurStack(){
        return this.stack[num];
    }
    private Stack<Integer> getOtherStack(){
        return this.stack[(num+1)&1];
    }

    private void update(){
        num = (num+1)&1;
        isLegal = !isLegal;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }


}


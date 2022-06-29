import java.util.Scanner;

public class Kalkulator {
 
 private static boolean pogoj;
 private static String[] cmds;
 private static int n;
 
 public static void main(String[] args) {

  pogoj = false;
  n = 0;
  
  @SuppressWarnings("unchecked")
  Stack<String>[] stacks = new ArrayDeque[42];
  for(int i=0; i<42; i++) {
   stacks[i] = new ArrayDeque<String>();
  }
  
  Scanner sc;
  Scanner scnr = new Scanner(System.in);
  String userString = getUserString(scnr);  
  System.out.println("\nCurrent Text: " + userString);
  
  
  while(true) {
	  sc = new Scanner(System.in);
	  System.out.println();
	  String vnos = sc.nextLine();
  cmds = vnos.split(" ");
  for(int i=0; i<cmds.length; i++) {
	  System.out.println(cmds[i]);
  }
  sc.close();
  }
  //program(stacks, cmds);
  
 }
 public static String getUserString(Scanner keyboard) { 
	    System.out.println("Enter Initial Text: ");
	    String input = "";
	    String line;
	    while (keyboard.hasNextLine()) {
	        line = keyboard.nextLine();
	        if (line.isEmpty()) {
	            break;
	        }
	        input += line + "\n";
	    }
	    return input;
	}

 private static void program(Stack<String>[] s, String[] cmds) {
	 
	 String a;
  for(int i = 0; i<cmds.length; i++ ) {
   n = i;
   if(cmds[i].startsWith("?") && pogoj == false){
   }
   else {
    if(cmds[i].startsWith("?")){
     cmds[i] = cmds[i].substring(1);
    }
    try {
     switch(cmds[i]) {
      case "echo": echo(s); break;
      case "pop": pop(s); break;
      case "dup": dup(s); break;
      case "dup2": dup2(s); break;
      case "swap": swap(s); break;
      case "char": chaR(s); break;
      case "even": even(s); break;
      case "odd": odd(s); break;
      case "!": fact(s); break;
      case "len": len(s); break;
      case "<>": compare(s); break;
      case "<": smaller(s); break;
      case "<=": smlOReq(s); break;
      case "==": equal(s); break;
      case ">": bigger(s); break;
      case ">=": bigOReq(s); break;
      case "+": add(s); break;
      case "-": unadd(s); break;
      case "*": multiply(s); break;
      case "/": devide(s); break;
      case "%": remaining(s); break;
      case ".": glue(s); break;
      case "rnd": random(s); break;
      case "then": then(s); break;
      case "else": elsE(); break;
      case "print": print(s); break;
      case "clear": clear(s); break;
      case "run": run(s); break;
      case "loop": loop(s); break;
      case "fun": fun(s); i=n; break;
      case "move": move(s); break;
      case "reverse": reverse(s); break;
      case "": break;
      default: s[0].push(cmds[n]); break;
      }
     } catch (CollectionException e) {
      e.printStackTrace();
      }
    }
   
  }
 }
 
 private static void print(Stack<String>[] s) {
  try {
   Stack<String> tmp = new ArrayDeque<String>();
   int x = Integer.parseInt(s[0].pop());
   
   for(int i=0; i<s[x].count();) {
    tmp.push(s[x].pop());
   }
   for(int i=0; i<tmp.count();) {
	   String a = tmp.pop();
	   s[x].push(a);
    System.out.print(a + " ");
   }
   System.out.println();
  }catch (CollectionException e) {
   System.out.println();
  }
 }

 private static void clear(Stack<String>[] s) {
  try {
   String x = s[0].top();
   for(int i=0; i<s[Integer.parseInt(x)].count();) {
    s[Integer.parseInt(x)].pop();
   }
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void run(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   String[] cmds = new String[s[x].count()];
   Stack<String> tmp = s[x];
   Stack<String> tmp2 = new ArrayDeque<String>();
   
   for(int i=0; i<tmp.count();) {
     tmp2.push(tmp.pop());
   }
   for(int i=0; 0<tmp2.count(); i++) {
	     cmds[i] = tmp2.pop();
	   }
   for(int i=cmds.length-1; i>=0; i--) {
	     s[x].push(cmds[i]);
	     
	   }
   program(s, cmds);
    
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void loop(Stack<String>[] s) {
	 try {
		   int x = Integer.parseInt(s[0].pop());
		   int y = Integer.parseInt(s[0].pop());
		   String[] cmds = new String[s[x].count()];
		   Stack<String> tmp = s[x];
		   
		   for(int i=0; 0<tmp.count(); i++) {
			     cmds[i] = tmp.pop();
			   }
		   for(int i=cmds.length-1; i>=0; i--) {
			     s[x].push(cmds[i]);
			   }
		   for(int i=0; i<y; i++) {
			   program(s, cmds);
			  
		   }
		  }catch (CollectionException e) {
		   e.printStackTrace();
		  }
 }

 private static void fun(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   int y = Integer.parseInt(s[0].pop());
   
   for(int i=0; i<y; i++) {
    n++;
    s[Integer.parseInt(x)].push(cmds[n]);
   }
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void move(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   String y = s[0].pop();
   for(int i=0; i<Integer.parseInt(y); i++) {
    s[Integer.parseInt(x)].push(s[0].pop());
   }
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void reverse(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   Stack<String> tmp = s[Integer.parseInt(x)];
   s[Integer.parseInt(x)] = new ArrayDeque<String>();
   
   for(int i=0; i<tmp.count();) {
    s[Integer.parseInt(x)].push(tmp.pop());
   }
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void random(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   int r = (int)(Math.random() * y) + x;
   s[0].push(Integer.toString(r));
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void glue(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   String y = s[0].pop();
   String r =  x + y;
   s[0].push(r);
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void remaining(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   int r = y % x;
   s[0].push(Integer.toString(r));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void devide(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   int d = y / x;
   s[0].push(Integer.toString(d));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void bigOReq(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   if(x >= y)
    s[0].push(Integer.toString(1));
   else
    s[0].push(Integer.toString(0));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void equal(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   String y = s[0].pop();
   if(x.equals(y))
    s[0].push(Integer.toString(1));
   else
    s[0].push(Integer.toString(0));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void bigger(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   if(x > y)
    s[0].push(Integer.toString(1));
   else
    s[0].push(Integer.toString(0));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void smlOReq(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   if(x <= y)
    s[0].push(Integer.toString(1));
   else
    s[0].push(Integer.toString(0));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void smaller(Stack<String>[] s) {
  try {
   int x = Integer.parseInt(s[0].pop());
   int y = Integer.parseInt(s[0].pop());
   if(x < y)
    s[0].push(Integer.toString(1));
   else
    s[0].push(Integer.toString(0));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void compare(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   String y = s[0].pop();
   if(x.equals(y))
    s[0].push(Integer.toString(0));
   else
    s[0].push(Integer.toString(1));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void len(Stack<String>[] s) {
  try {
   s[0].push(Integer.toString(s[0].pop().length()));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void fact(Stack<String>[] s) {
  try {
   int a = 1;
   for(int n=Integer.parseInt(s[0].pop()); n>0; n--) {
    a *= n;
   }
   s[0].push(Integer.toString(a));
  }catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void odd(Stack<String>[] s) {
  try {
   int a = Integer.parseInt(s[0].pop());
   if(a % 2 == 1)
    s[0].push("1");
   else
    s[0].push("0");
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void even(Stack<String>[] s) {
  try {
   int a = Integer.parseInt(s[0].pop());
   if(a % 2 == 0)
    s[0].push("1");
   else
    s[0].push("0");
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 private static void chaR(Stack<String>[] s) {
  try {
   char a = (char)Integer.parseInt(s[0].pop());
   s[0].push(String.valueOf(a));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 static void add(Stack<String>[] s) {
  try {
   int a = Integer.parseInt(s[0].pop());
   int b = Integer.parseInt(s[0].pop());
   s[0].push(Integer.toString(a+b));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
      
 }

 static void unadd(Stack<String>[] s) {
  try {
   int a = Integer.parseInt(s[0].pop());
   int b = Integer.parseInt(s[0].pop());
   s[0].push(Integer.toString(b-a));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
      
 }

 static void multiply(Stack<String>[] s) {
  try {
   int a = Integer.parseInt(s[0].pop());
   int b = Integer.parseInt(s[0].pop());
   s[0].push(Integer.toString(a*b));
  } catch (CollectionException e) {
   e.printStackTrace();
  }
      
 }
 
 static void echo(Stack<String>[] s) {
  try {
   System.out.println(s[0].top());
  } catch (CollectionException e) {
   System.out.println();
  }
 }
 
 static void pop(Stack<String>[] s) {
  try {
   s[0].pop();
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }
 
 static void dup(Stack<String>[] s) {
  try {
   String x = s[0].top();
   s[0].push(x);
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }
 
 static void dup2(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   String y = s[0].top();
   s[0].push(x);
   s[0].push(y);
   s[0].push(x);
  } catch (CollectionException e) {
   e.printStackTrace();
  }
  
 }

 static void swap(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   String y = s[0].pop();
   s[0].push(x);
   s[0].push(y);
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }
 
 static void then(Stack<String>[] s) {
  try {
   String x = s[0].pop();
   if(x.equals("0"))
    pogoj = false;
   else
    pogoj = true;
  } catch (CollectionException e) {
   e.printStackTrace();
  }
 }

 static void elsE() {
  if(pogoj)
   pogoj = false;
  else
   pogoj = true;
 }
 
}

 interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}

 interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}

 interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}

 interface Collection {
 
 static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();
    boolean isFull();
    int count();
    String toString();

}

 class CollectionException extends Exception{
 
 private static final long serialVersionUID = 1L;

 public CollectionException(String msg) {
  super(msg);
 }

}


 class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;
    private T[] tabela;
    private int front, back, size;

 @SuppressWarnings("unchecked")
 public ArrayDeque() {
     tabela = (T[])new Object[DEFAULT_CAPACITY];
     front = 0; back = 0; size = 0;
    }
    
    private int next(int i) {
     return (i+1)%DEFAULT_CAPACITY;
    }
    
    private int prev(int i) {
     return (i>0 ? i-1 : DEFAULT_CAPACITY-1);
    }
    
    @SuppressWarnings("unused")
 private int index(int i) throws CollectionException {
     if(i<0 || i>=size) {
      throw new CollectionException("ERR_MSG_INDEX");
     }
     return (front+i)%DEFAULT_CAPACITY;
    }

 @Override
 public boolean isEmpty() {
  return (size == 0);
 }

 @Override
 public boolean isFull() {
  return (size == DEFAULT_CAPACITY);
 }

 @Override
 public int count() {
  return size;
 }

 @Override
 public T get(int i) throws CollectionException {
  if(!this.isEmpty()) {
   return tabela[i];
  }
  else 
   throw new CollectionException("ERR_MSG_INDEX");
 }

 @Override
 public void add(T x) throws CollectionException {
  push(x);
 }

 @Override
 public T top() throws CollectionException {
  if(isEmpty())
   throw new CollectionException("ERR_MSG_EMPTY");
  return tabela[prev(back)]; 
 }

 @Override
 public void push(T x) throws CollectionException {
  if(isFull())
   throw new CollectionException("ERR_MSG_FULL");
  tabela[back] = x;
  back = next(back);
  size++;
 }

 @Override
 public T pop() throws CollectionException {
  if(isEmpty())
   throw new CollectionException("ERR_MSG_EMPTY");
  back = prev(back);
  T x = tabela[back];
  tabela[back] = null;
  size--;
  return x;
 }

 @Override
 public T front() throws CollectionException {
  if(tabela[front] == null) {
   throw new CollectionException("ERR_MSG_EMPTY");
  }
  T x = tabela[front];
  tabela[front] = null;
  front = next(front);
  size--;
  return x;
 }

 @Override
 public T back() throws CollectionException {
  return top();
 }

 @Override
 public void enqueue(T x) throws CollectionException {
  push(x);
 }

 @Override
 public void enqueueFront(T x) throws CollectionException {
  if(tabela[front] == tabela[back]) {
   throw new CollectionException("ERR_MSG_FULL");
  }
  front = prev(front);
  tabela[front] = x;
  System.out.println(front);
  size++;
 }

 @Override
 public T dequeue() throws CollectionException {
  if(tabela[front] == null) {
   throw new CollectionException("ERR_MSG_EMPTY");
  }
  T x = tabela[front];
  System.out.println(front);
  tabela[front]  = null;
  front = next(front);
  size--;
  return x;
 }

 @Override
 public T dequeueBack() throws CollectionException {
  return pop();
 }

}

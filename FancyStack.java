// Name: Tom Rosen
// Email: trrosen @wisc.edu 

import java.util.EmptyStackException;

/**
 * A FancyStack is a linked list based stack of strings. It includes a dummy node at the top of the
 * stack. This stack may contain duplicate strings, except for the string at the top of the stack
 * (at the dummy node) which must be a unique.
 */
public class FancyStack {
  private LinkedNode<String> top; // top of this stack


  /**
   * Initializes the newly created stack to contain the single String: "TOP".
   */
  public FancyStack() {
    top = new LinkedNode<String>("TOP");
  }

  /**
   * Checks whether this fancy stack is empty.
   * 
   * @return true when this stack is empty, and false otherwise.
   */
  public boolean isEmpty() {
	  if(top.getNext() == null)
	  {
		  return true;
	  }
    return false; // default return statement added to let this code to compile
  }

  /**
   * Adds a new value (to the top-side of this linked stack), meaning at index 1 of the stack.
   * Recall that the dummy node "TOP" must be already at index 0.
   * 
   * @param value that is being added to the stack.
   * @throws IllegalArgumentException if the value to be added is null or equals "TOP"
   */
  public void push(String value) {
	  if(value == null || value.equals("TOP"))
	  {
		  throw new IllegalArgumentException("Value is jank");
	  }
	  if(isEmpty())
	  {
		  top.setNext(new LinkedNode<String>(value));
	  }
	  else
	  {
		  LinkedNode<String> curr = top.getNext();
		  top.setNext(new LinkedNode<String>(value));
		  top.getNext().setNext(curr);		  
	  }
  }

  /**
   * Returns the first element at the top of this stack (skipping the dummy node)
   * 
   * @return the element at the top of this stack
   * @throws EmptyStackException without error message if this method is called on an empty fancy
   *                             stack
   */
  public String peek() {
	  if(isEmpty())
	  {
		  throw new EmptyStackException();
	  }
	  LinkedNode<String> node = top.getNext();
    return node.getData(); // default return statement added to let this code to compile
  }

  /**
   * Removes and returns the next value from the top-side of this linked stack
   * 
   * @return the next value on this stack
   * @throws EmptyStackException without error message if this fancy stack is empty
   */
  public String pop() {
    // Note that the dummy node at index 0 should never be popped. This method removes and returns
    // the element at index 1 of the linked list.
    // TODO complete the implementation of this method
	 LinkedNode<String> topNext = top.getNext();
	 top.setNext(topNext.getNext());
	 
    return topNext.getData(); // default statement added to let this code to compile
  }

  /**
   * Returns a string representation of the contents of this fancy stack
   * 
   * @return string representation of this fancy stack
   */
  @Override
  public String toString() {
    String s = "";
    LinkedNode<String> current = top;
    while (current != null) {
      s = s + current.toString();
      current = current.getNext();
    }
    return s;
  }

  /**
   * This test method checks the correctness of the constructor, isEmpty(), push(), and peek()
   * methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean test() {

    // TODO create an empty FancyStack and check that it creates a fancy stack which is empty and
    // whose string representation equals "TOP -> END"
    FancyStack fs = new FancyStack();
    if(!fs.isEmpty())
    {
    	System.out.println("E1");
    	return false;
    }
    String fsStr = fs.toString();
    String expected = "TOP -> END";
    if(!fsStr.equals(expected))
    {
    	System.out.println("E2");
    	return false;
    }
    try
    {
        fs.peek();
    }
    catch(EmptyStackException e)
    {
    	System.out.println("Error caught right.");
    }
    catch(Exception e)
    {
    	System.out.println("Uh oh.");
    	return false;
    }

    fs.push("Banana");
    if(fs.isEmpty())
    {
    	System.out.println("E3");
    	return false;
    }
    if(!fs.peek().equals("Banana"))
    {
    	System.out.println("E4");
    	return false;
    }
    if(!fs.toString().equals("TOP -> Banana -> END"))
    {
    	System.out.println("E5");
    	return false;
    }
    fs.push("Bologna");
    if(fs.isEmpty())
    {
    	System.out.println("E6");
    	return false;
    }
    if(!fs.peek().equals("Bologna"))
    {
    	System.out.println("E7");
    	return false;
    }
    if(!fs.toString().equals("TOP -> Bologna -> Banana -> END"))
    {
    	System.out.println("E8");
    	return false;
    }
    fs.push("Burger");
    if(fs.isEmpty())
    {
    	System.out.println("E9");
    	return false;
    }
    if(!fs.peek().equals("Burger"))
    {
    	System.out.println("E10");
    	return false;
    }
    if(!fs.toString().equals("TOP -> Burger -> Bologna -> Banana -> END"))
    {
    	System.out.println("E11");
    	return false;
    }

    return true; 
  }


  /**
   * A simple demo() of this program
   */
  public static void demo() {
    System.out.println("DEMO: ");
    FancyStack stack = new FancyStack();
    System.out.println("Fancy Stack: " + stack.toString()); // Fancy Stack: TOP -> END
    System.out.println("isEmpty(): " + stack.isEmpty()); // isEmpty(): true
    stack.push("A"); // A pushed
    stack.push("B"); // B pushed
    System.out.println("Fancy Stack: " + stack.toString());
    // Fancy Stack: TOP -> B -> A -> END
    System.out.println("isEmpty(): " + stack.isEmpty()); // isEmpty(): false
    System.out.println("peek(): " + stack.peek()); // peek(): B
    System.out.println("pop(): " + stack.pop()); // pop(): B
    System.out.println("Fancy Stack: " + stack.toString());
    // Fancy Stack: TOP -> A -> END
    System.out.println("peek(): " + stack.peek()); // peek(): A
    System.out.println("pop(): " + stack.pop()); // pop(): A
    System.out.println("Fancy Stack: " + stack.toString()); // Fancy Stack: TOP -> END
    System.out.println("isEmpty(): " + stack.isEmpty()); // isEmpty(): true
  }

  /**
   * Driver for the test method above.
   * 
   * @param args is unused
   */
  public static void main(String[] args) {
    System.out.println("test(): " + test());
    System.out.println(); // new line
    demo();
  }

}

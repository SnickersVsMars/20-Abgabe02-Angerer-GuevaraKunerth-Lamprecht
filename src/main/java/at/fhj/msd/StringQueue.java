package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

public class StringQueue implements IQueue<String> {

  private List<String> elements = new ArrayList<String>();
  private int maxSize = 5;

  public int getMaxSize() {
    return maxSize;
  }

  //bug found: in constructor body both variables had the same name. changed second maxSize to maxsize
  public StringQueue(int maxsize) {
    maxSize = maxsize;
  }


 //bug found: instead of != maxSize changed to < maxSize as our list has to be smaller in order to be able to add something.
 //technically not a bug, but makes more sense logic wise
  @Override
  public boolean offer(String obj) {
    if (elements.size() < maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

//bug found: changed the if statement. size has to be bigger than 0 to be able to delete something
  @Override
  public String poll() {
    String element = peek();

    if (elements.size() != 0) {
      elements.remove(0);
    }

    return element;
  }

  //bug found: removed "element = "";" otherwise if statement always false
  @Override
  public String remove() {
    String element = poll();

    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}
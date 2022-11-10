import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class TestListExamples {
  // Write your grading tests here!
  @Test
    public void testFilter(){
        List<String> Lst = new ArrayList<>();
        StringChecker sc = new Checker();
        Lst.add("abc");
        Lst.add("xyz");
        Lst.add("ijk");
        Lst.add("zab");
        Lst.add("def");
        assertArrayEquals(new String[]{"xyz","zab"}, ListExamples.filter(Lst, sc).toArray());
    }

    @Test
    public void testMerge(){
        List<String> Lis1 = new ArrayList<>();
        List<String> Lis2 = new ArrayList<>();
        Lis1.add("a");
        Lis1.add("c");
        Lis1.add("e");
        Lis2.add("b");
        Lis2.add("d");
        Lis2.add("f");
        assertArrayEquals(new String[]{"a","b","c","d","e","f"}, ListExamples.merge(Lis1, Lis2).toArray());
    }
}

class Checker implements StringChecker{
  public boolean checkString(String s){
      if(s.contains("z")){
          return true;
      }
      return false;
  }
}
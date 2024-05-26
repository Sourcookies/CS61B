package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L1 = new BuggyAList<>();
        L.addLast(4);
        L1.addLast(4);
        L.addLast(5);
        L1.addLast(5);
        L.addLast(6);
        L1.addLast(6);
        assertEquals(L.size(), L1.size());
        assertEquals(L.removeLast(), L1.removeLast());
        assertEquals(L.removeLast(), L1.removeLast());
        assertEquals(L.removeLast(), L1.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L1 = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L1.addLast(randVal);
                assertEquals(L.size(), L1.size());
                System.out.println("addLast(" + randVal + ")");
            } else if(operationNumber == 1 && L.size() > 0) {
                int res = L.getLast();
                int res1 = L1.getLast();
                assertEquals(res,res1);
                System.out.println("getLast(" + L.getLast() + ")");
            } else if (operationNumber == 2 && L.size() > 0) {
                assertEquals(L.size(), L1.size());
                assertEquals(L.removeLast(), L1.removeLast());
            }
        }
    }
}

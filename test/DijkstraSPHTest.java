import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraSPHTest {

    @Test
    public void testShortPath() {
        DijkstraSPH dsph = new DijkstraSPH("C:\\JavaProject\\CourseraHW\\dijkstraData.txt");

        dsph.search();
        dsph.output(7,37,59,82,99,115,133,165,188,197);

    }

}
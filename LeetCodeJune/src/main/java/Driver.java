import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Domain class that represents zip code range from start to end.
 */
class ZipCodeRange{

    private int start;
    private int end;

    public ZipCodeRange(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ZipCodeRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}


/**
 * Class that merges zip code ranges.
 */
class ZipCodeRangeMerger {

    /**
     * Method that merges overlapping ranges.
     *
     * @param ranges
     * @return
     */
    public List<ZipCodeRange> merge(List<ZipCodeRange> ranges) {

        if (ranges == null || ranges.size() == 0) {
            throw new IllegalArgumentException("Input ranges not valid");
        }

        //making copy of input ranges
        List<ZipCodeRange> list = new ArrayList<>();
        for (ZipCodeRange range : ranges) {
            if (range == null) {
                throw new IllegalArgumentException("Range not valid");
            }
            list.add(new ZipCodeRange(range.getStart(), range.getEnd()));
        }

        //sorts the list by start in ascending order
        list.sort((r1, r2) -> r1.getStart() - r2.getStart());


        List<ZipCodeRange> resultList = new ArrayList<>();
        resultList.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {

            ZipCodeRange prev = resultList.get(resultList.size() - 1);
            ZipCodeRange curr = list.get(i);

            if (prev.getEnd() >= curr.getStart()) {
                //merging the range
                prev.setEnd(Math.max(prev.getEnd(), curr.getEnd()));

            } else {
                resultList.add(curr);
            }
        }

        return resultList;

    }
}


/**
 * Driver class to test ZipCodeRangeMerger.
 */
public class Driver {

    private ZipCodeRangeMerger merger;

    public Driver(ZipCodeRangeMerger merger){
        this.merger = merger;
    }


    /**
     * Test case to test distince ranges.
     */
    void test_DistinctRanges(){

        List<ZipCodeRange> ranges = Arrays.asList(new ZipCodeRange[]{
                new ZipCodeRange(94133, 94133),
                new ZipCodeRange(94200, 94299),
                new ZipCodeRange(94600, 94699)
        });

        List<ZipCodeRange> resultList = merger.merge(ranges);

        assert resultList.size()==3;
        System.out.println(resultList.size());

    }


    /**
     * Test case to test overlapping ranges.
     */
    void test_OverlappingRanges(){

        List<ZipCodeRange> ranges = Arrays.asList(new ZipCodeRange[] {
                new ZipCodeRange(94133, 94133),
                new ZipCodeRange(94200, 94299),
                new ZipCodeRange(94226, 94399)
        });

        List<ZipCodeRange> resultList = merger.merge(ranges);

        assert resultList.size()==2;
        System.out.println(resultList.size());

    }

    /**
     * Tests when first end is equal to second start;
     */
    void test_RangesWithFirstEndEqualToSecondStart(){
        //test case 3
        List<ZipCodeRange> rangeList3 = Arrays.asList(new ZipCodeRange[] {
                new ZipCodeRange(94133, 94135),
                new ZipCodeRange(94135, 94140)
        });

        List<ZipCodeRange> resultList = merger.merge(rangeList3);
        assert resultList.size()==1;
    }


    /**
     * Tests when first end is greater than second end;
     */
    void test_RangesWithFirstEndGreaterThanSecondEnd(){
        //test case 3
        List<ZipCodeRange> rangeList3 = Arrays.asList(new ZipCodeRange[] {
                new ZipCodeRange(94133, 94190),
                new ZipCodeRange(94135, 94140)
        });

        List<ZipCodeRange> resultList = merger.merge(rangeList3);
        assert resultList.size()==1;
        assert resultList.get(0).getStart()==94133;
        assert resultList.get(0).getEnd()==94190;
    }


    public static void main(String[] args) {

        ZipCodeRangeMerger merger = new ZipCodeRangeMerger();

        Driver driver = new Driver(merger);
        driver.test_DistinctRanges();
        driver.test_OverlappingRanges();
        driver.test_RangesWithFirstEndEqualToSecondStart();
        driver.test_RangesWithFirstEndGreaterThanSecondEnd();

    }

}




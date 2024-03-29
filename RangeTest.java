package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range postiveToNegativeRange;
    private Range evenNumElemRange;
    private Range oddNumElemRange;
    private Range negativeRange;
    private Range PosNumRange;
    private Range smallRange;
    private Range largeRange;
    private Range doubleRange;
    private Range posToNegRange;
    private Range invalidRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        postiveToNegativeRange = new Range(-1, 1);
        evenNumElemRange = new Range(1, 6);
        oddNumElemRange = new Range(1, 5);
        negativeRange = new Range(-100, -1);
        PosNumRange = new Range(1, 100);
        smallRange = new Range(0, 0);
        largeRange = new Range(-Integer.MIN_VALUE, Integer.MAX_VALUE);
        doubleRange = new Range(1.1, 6.6);
        doubleRange = new Range(1.1, 6.6);
        posToNegRange = new Range(-1, 1);
        invalidRange = new Range(-1, 1);
    }

    // -------- Tests for getLowerBound() method -----------

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range of values negative to positive
    // type: ECP
    @Test
    public void postiveToNegativeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range from positive to negative values
        assertEquals("Lower bound should be -1",
                -1.0, postiveToNegativeRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range of negative values
    // type: ECP
    @Test
    public void negativeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of negative values
        assertEquals("Lower bound should be -100",
                -100, negativeRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range of positive values
    // type: ECP
    @Test
    public void PosNumRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of positive values
        assertEquals("Lower bound should be 1",
                1, PosNumRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // small range of only 1 value
    // type: BVT
    @Test
    public void smallRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a small range
        assertEquals("Lower bound should be 0",
                0, smallRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // large range max value integers
    // type: BVT
    @Test
    public void largeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a large range
        assertEquals("Lower bound should be -2^32",
                Integer.MIN_VALUE, largeRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range using double values
    // type: ECP
    @Test
    public void doubleRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of double values
        assertEquals("Lower bound should be 1.1",
                1.1, doubleRange.getLowerBound(), .000000001d);
    }

    // ------- tests for getCentralValue() method --------

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range with an odd number of elements
     * type: ECP
     */
    @Test
    public void testgetCentralValueWithOddNumberofElements() {
        assertEquals("Incorrect central value for odd number of elements in range. Expected 3", 3,
                oddNumElemRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range with an even number of elements
     * type: ECP
     */
    @Test
    public void testgetCentralValueWithEvenNumberofElements() {
        assertEquals("Incorrect central value for even number of elements in range. Expected 3.5", 3.5,
                evenNumElemRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range with negative values
     * type: ECP
     */
    @Test
    public void testgetCentralValueNegativeRange() {
        assertEquals("Incorrect central value for range of negative values. Expected -50.5", -50.5, negativeRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range of only 1 element (smallest range possible)
     * type: BVT
     */
    @Test
    public void testgetCentralWithSmallRange() {
        assertEquals("Incorrect central value for small range of 1 element. Expected 0", 0, smallRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for
     * the largest range possible
     * type: BVT
     */
    @Test
    public void testgetCentralWithLargeRange() {
        assertEquals("Incorrect central value for largest range possible. Expected -0.5", -0.5, largeRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for
     * a range of double values
     * type: ECP
     */
    @Test
    public void testgetCentralWithDoubleValues() {
        assertEquals("Incorrect central value for range of double data type. Expected 3.85", 3.85, doubleRange.getCentralValue(),
                0.00000001d);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for
     * a range of negative to positive values
     * type: ECP
     */
    @Test
    public void testgetCentralWithPositiveToNegativeRange() {
        assertEquals("Incorrect central value for range from positive to negative. Expected 0", 0, posToNegRange.getCentralValue(),
                0);
    }

    /**
     * Tests the getCentralValue method on an invalid range
     * type: ECP
     */
//    @Test
//    public void testgetCentralWithInvalidRange() {
//        try {
//            invalidRange = new Range(6, 2);
//            invalidRange.getCentralValue();
//            fail("Expected an exception to be thrown");
//        } catch (Exception e) {
//            assertEquals("Invalid range: end value must be greater than or equal to start value", e.getMessage());
//        }
//    }

    // ------------ Testing constrain() Function ----------------

    // Test case to ensure the constrain method returns a positive value within the
    // specified range.
    // type: ECP
    @Test
    public void constrainShouldEqualAPositiveValue() {
        assertEquals("The constrain value of 30.3 in range 1 to 100 should be 30.3",
                30.3, PosNumRange.constrain(30.3), .000000001d);
    }

    // Test case to ensure the constrain method returns a negative value within the
    // specified range.
    // type: ECP
    @Test
    public void constrainShouldEqualANegativeValue() {
        assertEquals("The constrain value of -30.3 in range -100 to -1 should be -30.3",
                -30.3, negativeRange.constrain(-30.3), .000000001d);
    }

    // Test case to ensure the constrain method returns zero within the specified
    // range.
    // type: ECP
    @Test
    public void constrainShouldEqualZero() {
        assertEquals("The constrain value of 0 in range -1 to 1 should be 0",
                0, posToNegRange.constrain(0), .000000001d);
    }

    // Test case to ensure the constrain method returns the upper boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainShouldBeHigherThanUpperBoundaryValue() {
        assertEquals("The constrain value of 10000 in range 1 to 100 should be 100",
                100, PosNumRange.constrain(10000), .000000001d);
    }

    // Test case to ensure the constrain method returns the lower boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainShouldBeLowerThanLowerBoundaryValue() {
        assertEquals("The constrain value of -10000 in range -100 to 1 should be -100",
                -100, negativeRange.constrain(-10000), .000000001d);
    }

    // Test case to ensure the constrain method returns the lower boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainEqualsLowerBoundaryValue() {
        assertEquals("The constrain value of -100 in range -100 to 1 should be -100",
                -100, negativeRange.constrain(-100), .000000001d);
    }

    // Test case to ensure the constrain method returns the upper boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainEqualsUpperBoundaryValue() {
        assertEquals("The constrain value of 100 in range 1 to 100 should be 100",
                100, PosNumRange.constrain(100), .000000001d);
    }

    // Test case to ensure a constrain close to upper boundary value returns the
    // constrain.
    // type: BVT
    @Test
    public void constrainCloseToUpperBoundaryValue() {
        assertEquals("The constrain value of 99.9 in range 1 to 100 should be 99.9",
                99.9, PosNumRange.constrain(99.9), .000000001d);
    }

    // Test case to ensure a constrain close to lower boundary value returns the
    // constrain.
    // type: BVT
    @Test
    public void constrainCloseToLowerBoundaryValue() {
        assertEquals("The constrain value of 1.99 in range 1 to 100 should be 1.99",
                1.99, PosNumRange.constrain(1.99), .000000001d);
    }

    // ----------- Testing intersects Function ---------------

    // Test two ranges where one completely overlaps the other
    // type: ECP
    @Test
    public void testCompletelyOverlappingRanges() {

        assertTrue("When one range completely overlaps the other, intersects() should return true.",
                evenNumElemRange.intersects(2, 3));
    }

    // Test two ranges where they partially overlap
    // type: ECP
    @Test
    public void testPartiallyOverlappingRanges() {
        assertTrue("When one range partially overlaps the other, intersects() should return true.",
        		PosNumRange.intersects(-10.3, 10.4));

    }

    // Tests the intersects() method of Range class with two different ranges that
    // share an upper endpoint.
    // type: BVT
    @Test
    public void testRangesWithSharedUpperBoundary() {
        assertTrue(
                "When two different ranges share an upper endpoint with one another, intersects() should return true.",
                PosNumRange.intersects(-5, 100));
    }

    // Test two ranges with the same range
    // type: BVT
    @Test
    public void testRangesWithSameBoundaries() {
        assertTrue(
                "When two different ranges share an both endpoints with one another, intersects() should return true.",
                posToNegRange.intersects(-1, 1));
    }

    // Test two ranges where one range is completely before the other
    // type: ECP
    @Test
    public void testRangesCompletelyBefore() {

        assertFalse("When one range is completey before the other Range, intersects() should return False.",
        		posToNegRange.intersects(-10.5, -5.6));
    }

    // Test two ranges where one range is completely after the other
    // type: ECP
    @Test
    public void testRangesCompletelyAfter() {

        assertFalse("When one range is completey after the other Range, intersects() should return False.",
        		posToNegRange.intersects(10.4, 30.6));
    }

    // ----------- Testing combine Function ---------------

    // Objective: Test if one valid range and a null range can be combined.
    // Type: ECP
    @Test
    public void combineValidrangeAndNullRange() {
        Range rangeA = new Range(0, 1);

        try {
            Range res = Range.combine(rangeA, null);
            assertEquals(
                    "If first argument is null, and the second is a valid range, the second range should be returned.",
                    rangeA, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if one null range and a valid range can be combined.
    // Type: ECP
    @Test
    public void combineNullrangeAndValidRange() {
        Range rangeB = new Range(0, 1);

        try {
            Range res = Range.combine(null, rangeB);
            assertEquals(
                    "If first argument is a valid range, and the second is null, the second range should be returned.",
                    rangeB, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if two null ranges can be combined.
    // Type: ECP
    @Test
    public void combineNullRanges() {

        try {
            Range res = Range.combine(null, null);
            assertEquals("Combining two null ranges returns null.", null, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }

    }

    // Objective: Test if an empty range and valid range can be combined.
    // Type: BVT
    @Test
    public void combineEmptyRangeAndValidRange() {
        Range rangeA = new Range(0, 0);
        Range rangeB = new Range(0, 1);

        assertEquals("New range must subsume empty and valid ranges.", rangeB, Range.combine(rangeA, rangeB));
    }

    // Objective: Test if a valid range and empty range can be combined.
    // Type: BVT
    @Test
    public void combineValidRangeAndEmptyRange() {
        Range rangeA = new Range(0, 1);
        Range rangeB = new Range(0, 0);

        assertEquals("New range must subsume valid and empty ranges.", rangeA, Range.combine(rangeA, rangeB));
    }

    // Objective: Test if two empty ranges can be combined.
    // Type: BVT
    @Test
    public void combineEmptyRanges() {
        Range rangeA = new Range(0, 0);
        Range rangeB = new Range(0, 0);

        Range emptyRange = new Range(0, 0);

        assertEquals("New range must return empty range.", emptyRange, Range.combine(rangeA, rangeB));
    }

    // Objective: Test if two non-identical ranges (both empty) can be combined.
    // Type: BVT
//    @Test
//    public void combineNonIdenticalEmptyRanges() {
//        Range rangeA = new Range(10, 10);
//        Range rangeB = new Range(5, 5);
//
//        Range emptyRange = new Range(0, 0);
//
//        assertEquals("New range must return arange that subsumes both empty ranges.", emptyRange,
//                Range.combine(rangeA, rangeB));
//    }

    // Objective: Test if superset and subset ranges can be combined.
    // Type: ECP
    @Test
    public void combineValidRangeAndSubsetRange() {
        Range rangeA = new Range(0, 5);
        Range rangeB = new Range(-10, 10);
        Range expected = new Range(-10, 10);
        assertEquals("Combining two valid ranges where one is a subset should return the superset.", expected,
                Range.combine(rangeA, rangeB));
    }

    // Objective: Test if superset and subset ranges can be combined.
    // Type: ECP
    @Test
    public void combineSubsetRangeAndValidRange() {
        Range rangeA = new Range(-10, 10);
        Range rangeB = new Range(0, 5);
        Range expected = new Range(-10, 10);

        try {
            Range res = Range.combine(rangeA, rangeB);
            assertEquals("Combining two valid ranges where one is a subset should return the superset.", expected, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }

    }

    // Objective: Test if touching ranges can be combined.
    // Type: ECP
    @Test
    public void combineTouchingValidRanges() {
        Range rangeA = new Range(0, 5);
        Range rangeB = new Range(5, 15);
        Range expected = new Range(0, 15);

        try {
            Range res = Range.combine(rangeA, rangeB);
            assertEquals("Combining two touching valid ranges should result in an expected superset range", expected,
                    res);

        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if overlapping ranges can be combined.
    // Type: ECP
    @Test
    public void combineOverlappingValidRanges() {
        Range rangeA = new Range(0, 5);
        Range rangeB = new Range(1, 15);
        Range expected = new Range(0, 15);

        try {
            Range res = Range.combine(rangeA, rangeB);
            assertEquals("Combining two overlapping valid ranges should result in an expected superset range", expected,
                    res);

        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if identical ranges can be combined.
    // Type: BVT
    @Test
    public void combineIdenticalValidRanges() {
        Range rangeA = new Range(1, 5);
        Range rangeB = new Range(1, 5);
        Range expected = new Range(1, 5);
        assertEquals("Combining two identical valid ranges should result in a third identical range", expected,
                Range.combine(rangeA, rangeB));
    }
    
    
   // --------------- Assignment 3 tests --------------- //
    
    // ---- Tests for intersects(Range range) ------ //
    
    
    // Test to check if a range with both positive and negative values intersects with a positive only range
    @Test
    public void testIntersectsWithRangeArgument() {
    	boolean expected = false;
    	boolean result = postiveToNegativeRange.intersects(PosNumRange);
    	assertEquals("Intersect did not return the correct boolean value", expected, result);
    }
    
    // ----- tests for scale(Range base, double factor) ----- //
    
    //Test to see if range can be scaled with a negative factor
    @Test(expected= IllegalArgumentException.class)
    public void testScaleWithNegativeFactor() {
    	Range.scale(PosNumRange, -3);
    }
    
    //Test to see if range can be scaled with a positive factor
    @Test
    public void testScaleWithPositiveFactor() {
    	Range result = Range.scale(PosNumRange, 6);
    	Range expected = new Range(6, 600);
    	assertEquals("Range should scale correctly", expected, result);
    }
    
    // ------ tests for expand(Range range, double lowerMargin, double upperMargin) ------- //
    

    
 // Tests the behavior of expanding a range where the lower bound is greater than the upper bound
//    @Test
//    public void testExpandWithLowerGreaterThanUpper() {
//        Range range = new Range(5, 10);
//        Range expanded = Range.expand(range, 0.7, 0.7);
//        assertTrue("Lower bound is not greater than upper bound after expanding", expanded.getLowerBound() > expanded.getUpperBound());
//    }
    
 // Tests the behavior of expanding a range where the lower bound is less than or equal to the upper bound
    @Test
    public void testExpandWithLowerLessOrEqualToUpper() {
        Range range = new Range(5, 6);
        Range expanded = Range.expand(range, 0.0001, -3);
        assertTrue("Lower bound is not less than or equal to upper bound after expanding", expanded.getLowerBound() <= expanded.getUpperBound());
    }
    
    
  //--- tests for shift(Range base, double delta) ---------- //
    
 // Tests the correctness of shifting a range with zero crossing
    @Test
    public void correctShiftWithZeroCrossingTest() {
        Range shiftedRange = new Range(-100, -1);
        Range newRange = Range.shift(PosNumRange, -101, true);
        assertTrue("Range should be shifted allowing zero crossing", newRange.getLowerBound() == shiftedRange.getLowerBound() && newRange.getUpperBound() == shiftedRange.getUpperBound());
    }
    
  
 // Tests shifting a positive range without allowing zero crossing
    @Test
    public void ShiftWithoutZeroCrossingPositiveRangeTest() {
        Range shiftedRange = new Range(5, 104);
        Range newRange = Range.shift(PosNumRange, 4, false);
        assertTrue("Range should be shifted without allowing zero crossing", newRange.getLowerBound() == shiftedRange.getLowerBound() && newRange.getUpperBound() == shiftedRange.getUpperBound());
    }
    
    // Tests shifting a negative range without allowing zero crossing
    @Test
    public void ShiftWithoutZeroCrossingNegativeRangeTest() {
        Range shiftedRange = new Range(-104, -5);
        Range newRange = Range.shift(negativeRange, -4, false);
        assertTrue("Range should be shifted without allowing zero crossing", newRange.getLowerBound() == shiftedRange.getLowerBound() && newRange.getUpperBound() == shiftedRange.getUpperBound());
    }
    
    
 // Tests the length of a positive range
    @Test
    public void positiveRangeLengthTest() {
        int expectedLength = 100 - 1;
        assertEquals("Length of positive range is incorrect", expectedLength, PosNumRange.getLength(), 0.000000001d);
    }
    
    
  //-----------NaNRange() Test for coverage---------//
    

 // Tests if a double.NaN value is correctly handled by the isNaNRange function
    @Test
    public void TrueNaNisNaNRangeTest() {
        Range naNRange = new Range(Double.NaN, Double.NaN);
        assertTrue("Range containing NaN should be recognized as NaN range",
                naNRange.isNaNRange());
    }
    
    
 // Tests if the upper bound is correct for a range from positive to negative values
    @Test
    public void postiveToNegativeRangeUpperBoundReturnsCorrectValue() {
        // Ensure upper bound is correct for a range from positive to negative values
        assertEquals("Upper bound was incorrect", 1.0, postiveToNegativeRange.getUpperBound(), 0.000000001d);
    }
    
    // ^^^^ 60% Coverage HERE ^^^^^^^
    
    //-------- test expandToInclude() coverage---------------//
    
 // Tests expanding a range to include a value within the range
    @Test
    public void testExpandToIncludeWithValueWithinRange() {
        Range expected = new Range(6.2, 8.4);
        Range expanded = Range.expandToInclude(expected, 7.3); 
        assertEquals("Expanded range does not match the expected range", expected, expanded);
    }
    
 // Tests expanding a range to include a value greater than the range
    @Test
    public void testExpandToIncludeWithGreaterRange() {
        Range range = new Range(6.2, 8.4);
        Range expanded = Range.expandToInclude(range, 9.6); 
        Range expected = new Range(6.2, 9.6);
        assertEquals("Expanded range does not match the expected range", expected, expanded);
    }

    
 // Tests expanding a range to include a value less than the range
    @Test
    public void testExpandToIncludeWithLessRange() {
        Range range = new Range(6.2, 8.4);
        Range expanded = Range.expandToInclude(range, 3.5); 
        Range expected = new Range(3.5, 8.4);
        assertEquals("Expanded range does not match the expected range", expected, expanded);
    }
    
 // Tests expanding a null range to include a value
    @Test
    public void testExpandToIncludeWithNullRange() {
        Range expanded = Range.expandToInclude(null, 3.5); 
        Range expected = new Range(3.5, 3.5);
        assertEquals("Expanded range does not match the expected range", expected, expanded);
    }

    // ----- test hashCode() coverage -------- //
    
 // Tests the hash code equality of two equal ranges
    @Test
    public void testHashCodeWithEqualRanges() {
        Range range1 = new Range(6, 12);
        Range range2 = new Range(6, 12);
        assertEquals("Hash codes of equal ranges should be equal", range1.hashCode(), range2.hashCode());
    }
    
 // Tests the hash code inequality of two different ranges
//    @Test
//    public void testHashCodeDifferentRanges() {
//        Range range1 = new Range(0, 10);
//        Range range2 = new Range(1, 15);
//        assertNotEquals("Hash codes of different ranges should not be equal", range1.hashCode(), range2.hashCode());
//    }
//    
//    
    
 // Tests shifting a range without allowing zero crossing when the range contains zero
    @Test
    public void ShiftWithoutZeroCrossingContainingZeroinRangeTest() {
        Range shiftedRange = new Range(2, 2);
        Range newRange = Range.shift(smallRange, 2, false);
        assertTrue("Range should be shifted not allowing zero crossing", newRange.getLowerBound() == shiftedRange.getLowerBound() && newRange.getUpperBound() == shiftedRange.getUpperBound());
    }


 // Tests combining two NaN ranges while ignoring NaN values
    @Test
    public void combineIgnoringNaNWithBothBeingNaNRangesTest() {
        Range rangeNaN = new Range(Double.NaN, Double.NaN);
        Range rangeNaN2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(rangeNaN, rangeNaN2);
        assertNull("Method should not be able to combine NaN ranges", result);
    }
    
    /**
     * Tests combining two valid ranges.
     */
    @Test
    public void combineIgnoringNaNWithValidRanges() {
        Range rangeA = new Range(2.0, 6.0);
        Range rangeB = new Range(7.0, 11.0);
        Range resultingRange = Range.combineIgnoringNaN(rangeA, rangeB);
        assertTrue("Range should be combined",resultingRange.getLowerBound() == 2.0 && resultingRange.getUpperBound() == 11.0);
    }
    
    /**
     * Tests combining a null range A with a range.
     */
    @Test
    public void combineIgnoringNaNWithNullRangeA() {
        Range rangeB = new Range(10.0, 15.0);
        Range resultingRange = Range.combineIgnoringNaN(null, rangeB);
        assertTrue("Range should be the same as rangeB",resultingRange.getLowerBound() == 10.0 && resultingRange.getUpperBound() == 15.0);
    }
    
    /**
     * Tests combining a range with a null range B.
     */
    @Test
    public void combineIgnoringNaNWithNullRangeB() {
        Range rangeA = new Range(10.0, 15.0);
        Range resultingRange = Range.combineIgnoringNaN(rangeA, null);
        assertTrue("Range should be the same as rangeA",resultingRange.getLowerBound() == 10.0 && resultingRange.getUpperBound() == 15.0);
    }
    
    /**
     * Tests combining two ranges where both bounds of range B are NaN.
     */
    @Test
    public void combineIgnoringWithMaxd2NaNMin() {
        Range rangeA = new Range(10.0, 10.0);
        Range rangeB = new Range(Double.NaN, Double.NaN);
        Range resultingRange = Range.combineIgnoringNaN(rangeA, rangeB);
        Range expected = new Range(10.0, 10.0);
        assertEquals("Range should be the same as rangeA", expected, resultingRange);
    }
    
    /**
     * Tests combining two ranges where the maximum of range B is NaN.
     */
    @Test
    public void combineIgnoringWithMaxd2NaNMax() {
        Range rangeA = new Range(9.0, 10.0);
        Range rangeB = new Range(10.0, Double.NaN);
        Range resultingRange = Range.combineIgnoringNaN(rangeA, rangeB);
        Range expected = new Range(9.0, 10.0);
        assertEquals("Range should be the same as rangeA", expected, resultingRange);
    }
    
    
    /**
     * Tests the equality check with different upper bounds.
     */
    @Test
    public void testEqualsDifferentUppers() {
        Range RangeA = new Range(0, 2);
        Range RangeB = new Range(0, 6);
        assertFalse("Ranges with different upper bounds should not be considered equal", RangeA.equals(RangeB));
    }

    /**
     * Tests the equality check with a non-Range object.
     */
    @Test
    public void testEqualsNonRangeObject() {
        assertFalse("Different ranges should not be considered equal", PosNumRange.equals(new Object()));
    }
    
    // ------ tests for combineIgnoringNaN() coverage ---- //
    
    /**
     * Tests the combination of a NaN Range B and a null Range A.
     */
    @Test
    public void combineIgnoringNaNWithNullRangeBandNaNRangeA() {
        Range rangeA = new Range(Double.NaN, Double.NaN);
        Range resultingRange = Range.combineIgnoringNaN(rangeA, null);
        assertNull("Range should be null when combining NaN Range B with null Range A",resultingRange);
    }
    
    /**
     * Tests the combination of a null Range A and a NaN Range B.
     */
    @Test
    public void combineIgnoringNaNWithNullRangeAandNaNRangeB() {
        Range rangeB = new Range(Double.NaN, Double.NaN);
        Range resultingRange = Range.combineIgnoringNaN(null, rangeB);
        assertNull("Range should be null when combining null Range A with NaN Range B",resultingRange);
    }
    
    // ---- tests for shift() ------ //

    /**
     * Tests the shifting of a valid range.
     */
    @Test
    public void shiftValidRange() {
        Range shiftedRange = new Range(2,2);
        Range newRange = Range.shift(smallRange,2);
        assertTrue("Valid Range should be shifted correctly",newRange.getLowerBound() == shiftedRange.getLowerBound() &&newRange.getUpperBound() == shiftedRange.getUpperBound());
    }
    
    /**
     * Tests the correct shifting behavior when one bound of the range is NaN.
     */
    @Test
    public void correctShiftWithLowerBoundBeingANaNTest() {
        Range shiftedRange = new Range(-100,-91);
        Range rangeA = new Range(Double.NaN,10);
        Range newRange = Range.shift(rangeA,-101,true);
        assertTrue("Range should be shifted allowing zero crossing" + Double.isNaN(newRange.getLowerBound())+ newRange.getUpperBound(),Double.isNaN(newRange.getLowerBound()) && newRange.getUpperBound() == shiftedRange.getUpperBound());
     }
    
    /**
     * Tests the correct shifting behavior when both lower and upper bounds of the range are NaN.
     */
    @Test
    public void correctShiftWithBothRangeValNaNTest() {
        Range shiftedRange = new Range(Double.NaN,Double.NaN);
        Range rangeA = new Range(Double.NaN,Double.NaN);
        Range newRange = Range.shift(rangeA,-101,true);
        assertTrue("Range should be an NaN", Double.isNaN(newRange.getLowerBound()) && Double.isNaN(newRange.getUpperBound()));
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
//    ------- -------- New Mutant test cases: ------- --------  ------- -------- 
    
    
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidRange() {
        // Arrange
        double lower = 10.0;  // Arbitrary value
        double upper = 5.0;   // Lower than lower bound

        // Act
        Range range = new Range(lower, upper);  // This should throw IllegalArgumentException
    }

    @Test
    public void testConstructor_VariableManipulation() {
        // Arrange
        double lower = 5.0;
        double upper = 10.0;

        // Act
        Range range = new Range(lower, upper);

        // Assert
        // Check if the constructed range object is within the expected bounds
        assertTrue(range.getLowerBound() <= range.getUpperBound());
    }


    @Test
    public void testGetLengthWithBasicRange() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.getLength(), 0.001);
    }

    @Test
    public void testGetLengthWithRangeWithNegativeBounds() {
        Range range = new Range(-5, 5);
        assertEquals(10.0, range.getLength(), 0.001);
    }

    @Test
    public void testGetLengthWithRangeWithZeroBounds() {
        Range range = new Range(0, 0);
        assertEquals(0.0, range.getLength(), 0.001);
    }

    @Test
    public void testGetLengthWithRangeWithSameBounds() {
        Range range = new Range(2, 2);
        assertEquals(0.0, range.getLength(), 0.001);
    }

    @Test
    public void testGetLengthWithRangeWithUpperBoundGreaterThanLowerBound() {
        Range range = new Range(5, 15);
        assertEquals(10.0, range.getLength(), 0.001);
    }

    @Test
    public void testGetLengthWithMutatedLowerBound() {
        Range range = new Range(0, 10);
        range.getLowerBound(); // Assuming setLower() method is available
        assertEquals(10, range.getLength(), 0.001);
    }

    @Test
    public void testGetLengthWithMutatedUpperBound() {
        Range range = new Range(0, 10);
        range.getLowerBound();
        assertEquals(10, range.getLength(), 0.001);
    }
    
    @Test
    public void testContainsWithMutatedLowerBound() {
        Range range = new Range(0, 10);
        assertFalse(range.contains(-1)); // Mutated: Negated double field lower
        assertTrue(range.contains(0));   // Original behavior
        assertTrue(range.contains(5));   // Original behavior
        assertTrue(range.contains(10));  // Original behavior
        assertFalse(range.contains(11)); // Original behavior
    }

//    contains() 
    @Test
    public void testContainsWithMutatedUpperBound() {
        Range range = new Range(0, 10);
        assertTrue(range.contains(10));  // Mutated: Negated double field upper
        assertTrue(range.contains(0));   // Original behavior
        assertTrue(range.contains(5));   // Original behavior
        assertFalse(range.contains(-1)); // Original behavior
        assertFalse(range.contains(11)); // Original behavior
    }
    @Test
    public void testContainsWithMutatedFieldsAndValues() {
        // Test negating double field lower
        Range range1 = new Range(0, 10);
        assertFalse(range1.contains(-5));  // Mutated: Negated double field lower
        assertTrue(range1.contains(5));    // Original behavior

        // Test substituting 1 with -1
        Range range2 = new Range(0, 10);
        assertFalse(range2.contains(-1));  // Mutated: Substituted 1 with -1
        assertTrue(range2.contains(1));    // Original behavior
    }
    
//    intersects()
    @Test
    public void testIntersectsMutatedLine1() {
        Range range = new Range(0, 10);
        assertTrue(range.intersects(4, 5));  // Mutated: b0 is less than lower
        assertTrue(range.intersects(0, 5));    // Original behavior
        assertTrue(range.intersects(5, 10));   // Original behavior
    }
    
    @Test
    public void testIntersectsMutatedLine2() {
        Range range = new Range(0, 10);
        assertTrue(range.intersects(0, 15));   // Mutated: b1 is greater than lower
        assertTrue(range.intersects(5, 10));  // Original behavior
    }
    
    @Test
    public void testIntersectsMutatedLine3() {
        Range range = new Range(0, 10);
        assertFalse(range.intersects(5, 4));   // Mutated: b0 is not less than upper
        assertTrue(range.intersects(5, 10));   // Original behavior
    }
    
    // Test for line: return intersects(range.getLowerBound(), range.getUpperBound());
    @Test
    public void testIntersectsRangeMutatedLine() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(-1, 5); // Mutated: range2 lower bound is less than lower bound of range1
        assertTrue(range1.intersects(range2));  // Mutated behavior: Should return true
        assertTrue(range1.intersects(0, 5));     // Original behavior
        assertTrue(range1.intersects(5, 10));    // Original behavior
    }

    // Test for null range parameter
    @Test(expected = NullPointerException.class)
    public void testIntersectsNullRange() {
        Range range1 = new Range(0, 10);
        range1.intersects(null); // Expecting NullPointerException
    }
    
    // Test for line: double result = value;
    @Test
    public void testConstrainMutatedLine1() {
        Range range = new Range(0, 10);
        assertEquals(5.0, range.constrain(5), 0.001); // Mutated behavior: value is not constrained
    }

    // Test for line: if (!contains(value))
    @Test
    public void testConstrainMutatedLine2() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-1), 0.001); // Mutated behavior: value is less than lower bound
        assertEquals(10.0, range.constrain(15), 0.001); // Mutated behavior: value is greater than upper bound
        assertEquals(5.0, range.constrain(5), 0.001); // Original behavior: value is within the range
    }

    // Test for line: if (value > this.upper)
    @Test
    public void testConstrainMutatedLine3() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.constrain(15), 0.001); // Mutated behavior: value is greater than upper bound
        assertEquals(0.0, range.constrain(-1), 0.001); // Original behavior: value is less than lower bound
        assertEquals(5.0, range.constrain(5), 0.001); // Original behavior: value is within the range
    }

    // Test for line: else if (value < this.lower)
    @Test
    public void testConstrainMutatedLine4() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-1), 0.001); // Mutated behavior: value is less than lower bound
        assertEquals(10.0, range.constrain(15), 0.001); // Original behavior: value is greater than upper bound
        assertEquals(5.0, range.constrain(5), 0.001); // Original behavior: value is within the range
    }
    
    // Test for line: if (range1 == null && range2 == null)
    @Test
    public void testCombineIgnoringNaNMutatedLine1() {
        Range range1 = null;
        Range range2 = null;
        assertNull(Range.combineIgnoringNaN(range1, range2)); // Mutated behavior: both ranges are null
    }

    // Test for line: if (range1 == null)
    @Test
    public void testCombineIgnoringNaNMutatedLine2() {
        Range range1 = null;
        Range range2 = new Range(0, 10);
        assertEquals(new Range(0, 10), Range.combineIgnoringNaN(range1, range2)); // Mutated behavior: range1 is null
    }

    // Test for line: if (range2 == null)
    @Test
    public void testCombineIgnoringNaNMutatedLine3() {
        Range range1 = new Range(0, 10);
        Range range2 = null;
        assertEquals(new Range(0, 10), Range.combineIgnoringNaN(range1, range2)); // Mutated behavior: range2 is null
    }

    // Test for line: return new Range(l, u);
    @Test
    public void testCombineIgnoringNaNMutatedLine4() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: l is set to min(lower1, lower2)
        assertEquals(15.0, result.getUpperBound(), 0.001); // Mutated behavior: u is set to max(upper1, upper2)
    }
    // Test for mutated: Decremented (--a) double local variable number 1
    @Test
    public void testCombineIgnoringNaNMutated_DecrementLower() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: Decremented (--a) double local variable number 1
    }

    // Test for mutated: not equal to greater than
    @Test
    public void testCombineIgnoringNaNMutated_NotEqualToGreaterThan() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(15.0, result.getUpperBound(), 0.001); // Mutated behavior: not equal to greater than
    }

    // Test for mutated: not equal to less than
    @Test
    public void testCombineIgnoringNaNMutated_NotEqualToLessThan() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: not equal to less than
    }

    // Test for mutated: Decremented (--a) double local variable number 1
    @Test
    public void testCombineIgnoringNaNMutated_DecrementLower2() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: Decremented (--a) double local variable number 1
    }

    // Test for mutated: Incremented (a++) double local variable number 1
    @Test
    public void testCombineIgnoringNaNMutated_IncrementUpper() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(15.0, result.getUpperBound(), 0.001); // Mutated behavior: Incremented (a++) double local variable number 1
    }

 // Test for mutated: changed conditional boundary
    @Test
    public void testCombineIgnoringNaNMutated_ChangedConditionalBoundary() {
        Range range1 = new Range(0, 10);
        Range range2 = null; // Null range2 to trigger the mutated behavior
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertNotNull(result); // Mutated behavior: changed conditional boundary
    }
    // Test for mutated: not equal to less than
    @Test
    public void testCombineIgnoringNaNMutated_NotEqualToLessThan2() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: not equal to less than
    }

    // Test for mutated: removed conditional - replaced equity check with true
    @Test
    public void testCombineIgnoringNaNMutated_RemovedConditional() {
        Range range1 = null;
        Range range2 = null;
        assertNull(Range.combineIgnoringNaN(range1, range2)); // Mutated behavior: removed conditional - replaced equity check with true
    }
    // Test for mutated: Decremented (a--) double local variable number 2
    @Test
    public void testCombineIgnoringNaNMutated_DecrementLower3() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: Decremented (a--) double local variable number 2
    }

    // Test for mutated: Decremented (a--) double local variable number 4
    @Test
    public void testCombineIgnoringNaNMutated_DecrementLower4() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.001); // Mutated behavior: Decremented (a--) double local variable number 4
    }

    // Test for mutated: Incremented (a++) double local variable number 2
    @Test
    public void testCombineIgnoringNaNMutated_IncrementUpper2() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(15.0, result.getUpperBound(), 0.001); // Mutated behavior: Incremented (a++) double local variable number 2
    }

    // Test for mutated: Incremented (a++) double local variable number 4
    @Test
    public void testCombineIgnoringNaNMutated_IncrementUpper3() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(0, 15);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals(15.0, result.getUpperBound(), 0.001); // Mutated behavior: Incremented (a++) double local variable number 4
    }
    
    // Test for line: ParamChecks.nullNotPermitted(range, "range");
    @Test(expected = IllegalArgumentException.class)
    public void testExpandMutatedLine1() {
        Range range = null;
        Range.expand(range, 0.1, 0.1); // Mutated behavior: range is null
    }

    // Test for line: if (lower > upper)
    @Test
    public void testExpandMutatedLine2() {
        Range range = new Range(5, 10);
        Range expandedRange = Range.expand(range, 0.5, 0.5);
        assertTrue(expandedRange.getLowerBound() <= expandedRange.getUpperBound()); // Mutated behavior: lower > upper
    }

    // Test for line: return new Range(lower, upper);
    @Test
    public void testExpandMutatedLine3() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expand(range, 0.1, 0.1);
        assertEquals(-1.0, expandedRange.getLowerBound(), 0.001); // Mutated behavior: lower = lower / 2.0 + upper / 2.0
        assertEquals(11.0, expandedRange.getUpperBound(), 0.001); // Mutated behavior: upper = lower
    }
    // Test for mutated: Decremented (--a) double local variable number 1
    @Test
    public void testConstrainMutated_DecrementLower() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-1), 0.001); // Mutated behavior: Decremented (--a) double local variable number 1
    }
    // Test for mutated: Incremented (a++) double local variable number 1
    @Test
    public void testConstrainMutated_IncrementLower() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-0.5), 0.001); // Mutated behavior: Incremented (a++) double local variable number 1
    }

    // Test for mutated: not equal to greater than
    @Test
    public void testConstrainMutated_NotEqualToGreaterThan() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.constrain(15), 0.001); // Mutated behavior: not equal to greater than
    }

    // Test for mutated: not equal to less than
    @Test
    public void testConstrainMutated_NotEqualToLessThan() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-5), 0.001); // Mutated behavior: not equal to less than
    }

    // Test for mutated: Incremented (++a) double local variable number 1
    @Test
    public void testConstrainMutated_IncrementUpper() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.constrain(15), 0.001); // Mutated behavior: Incremented (++a) double local variable number 1
    }

    // Test for mutated: Decremented (--a) double local variable number 1
    @Test
    public void testConstrainMutated_DecrementUpper() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.constrain(11), 0.001); // Mutated behavior: Decremented (--a) double local variable number 1
    }

    // Test for mutated: Incremented (a++) double local variable number 1
    @Test
    public void testConstrainMutated_IncrementLower2() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-1), 0.001); // Mutated behavior: Incremented (a++) double local variable number 1
    }

    // Test for mutated: Incremented (a++) double local variable number 1
    @Test
    public void testConstrainMutated_IncrementUpper2() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.constrain(15), 0.001); // Mutated behavior: Incremented (a++) double local variable number 1
    }

    // Test for mutated: Incremented (++a) double local variable number 1
    @Test
    public void testConstrainMutated_IncrementLower3() {
        Range range = new Range(0, 10);
        assertEquals(0.0, range.constrain(-5), 0.001); // Mutated behavior: Incremented (++a) double local variable number 1
    }

    // Test for mutated: Incremented (++a) double local variable number 1
    @Test
    public void testConstrainMutated_IncrementUpper3() {
        Range range = new Range(0, 10);
        assertEquals(10.0, range.constrain(11), 0.001); // Mutated behavior: Incremented (++a) double local variable number 1
    }
    
//    // Test for mutated: Decremented (--a) double field lower
//    @Test
//    public void testIsNaNRangeMutated_DecrementLower() {
//        Range range = new Range(Double.NaN, 10.0);
//        assertTrue(range.isNaNRange()); // Mutated behavior: Decremented (--a) double field lower
//    }
//
//    // Test for mutated: Decremented (--a) double field upper
//    @Test
//    public void testIsNaNRangeMutated_DecrementUpper() {
//        Range range = new Range(5.0, Double.NaN);
//        assertTrue(range.isNaNRange()); // Mutated behavior: Decremented (--a) double field upper
//    }

    // Test for mutated: Negated double field lower
    @Test
    public void testIsNaNRangeMutated_NegateLower() {
        Range range = new Range(Double.NaN, 10.0);
        assertFalse(range.isNaNRange()); // Mutated behavior: Negated double field lower
    }

    // Test for mutated: Negated double field upper
    @Test
    public void testIsNaNRangeMutated_NegateUpper() {
        Range range = new Range(5.0, Double.NaN);
        assertFalse(range.isNaNRange()); // Mutated behavior: Negated double field upper
    }

//    // Test for mutated: Substituted 1 with -1
//    @Test
//    public void testIsNaNRangeMutated_Substitute1WithNegative1() {
//        Range range = new Range(Double.NaN, Double.NaN);
//        assertFalse(range.isNaNRange()); // Mutated behavior: Substituted 1 with -1
//    }
//
//    // Test for mutated: Substituted 1 with 0
//    @Test
//    public void testIsNaNRangeMutated_Substitute1WithZero() {
//        Range range = new Range(Double.NaN, Double.NaN);
//        assertFalse(range.isNaNRange()); // Mutated behavior: Substituted 1 with 0
//    }
//
//    // Test for mutated: Substituted 1 with 2
//    @Test
//    public void testIsNaNRangeMutated_Substitute1With2() {
//        Range range = new Range(Double.NaN, Double.NaN);
//        assertFalse(range.isNaNRange()); // Mutated behavior: Substituted 1 with 2
//    }
//
//    
    
    @After
    public void tearDown() throws Exception {
    	postiveToNegativeRange = null;
        evenNumElemRange = null;
        oddNumElemRange = null;
        negativeRange = null;
        PosNumRange = null;
        smallRange = null;
        largeRange = null;
        doubleRange = null;
        doubleRange = null;
        posToNegRange = null;
        invalidRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
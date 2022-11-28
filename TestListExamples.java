import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.util.List;

class Checker implements StringChecker {
  public boolean checkString(String s) {
    return s.contains("tired422");
  }
}

public class TestListExamples {
  // Write your grading tests here

  StringChecker strCheck = new Checker();

  @Test(timeout = 100)
  public void testFilter() {
    List<String> input = Arrays.asList(new String[] { "tired42", "tired423", "tired422" });
    List<String> output = Arrays.asList(new String[] { "tired422" });
    List<String> s = ListExamples.filter(input, strCheck);

    Assert.assertArrayEquals(output.toArray(), s.toArray());
  }

  @Test(timeout = 100)
  public void testFilterNull() {
    List<String> input = Arrays.asList(new String[] {});
    List<String> output = Arrays.asList(new String[] {});
    List<String> s = ListExamples.filter(input, strCheck);

    Assert.assertArrayEquals(output.toArray(), s.toArray());
  }

  @Test(timeout = 100)
  public void testMany() {
    List<String> input = Arrays.asList(new String[] { "tired422", "tired422", "tired422" });
    List<String> output = Arrays.asList(new String[] { "tired422", "tired422", "tired422" });
    List<String> s = ListExamples.filter(input, strCheck);

    Assert.assertArrayEquals(output.toArray(), s.toArray());
  }

  @Test(timeout = 100)
  public void testNullOutput() {
    List<String> input = Arrays.asList(new String[] { "tired42", "tired423", "tired420" });
    List<String> output = Arrays.asList(new String[] {});
    List<String> s = ListExamples.filter(input, strCheck);

    Assert.assertArrayEquals(output.toArray(), s.toArray());
  }

  @Test(timeout = 100)
  public void testMerge() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> output = new ArrayList<>();
    input1.add("1");
    input1.add("3");
    input2.add("2");
    input2.add("4");
    output.add("1");
    output.add("2");
    output.add("3");
    output.add("4");
    assertEquals(output, ListExamples.merge(input1, input2));
  }

  @Test(timeout = 100)
  public void testMergeMany() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> output = new ArrayList<>();
    input1.add("1");
    input1.add("2");
    input2.add("1");
    input2.add("2");
    output.add("1");
    output.add("1");
    output.add("2");
    output.add("2");
    assertEquals(output, ListExamples.merge(input1, input2));
  }

  @Test(timeout = 100)
  public void testMergeNone() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    assertEquals(expected, ListExamples.merge(input1, input2));
  }

}

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
    List<String> expected = new ArrayList<>();
    input1.add("ti");
    input1.add("re");
    input2.add("d");
    input2.add("422");
    expected.add("ti");
    expected.add("d");
    expected.add("re");
    expected.add("422");
    assertEquals(expected, ListExamples.merge(input1, input2));
  }

  @Test(timeout = 100)
  public void testMergeMany() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    input1.add("ti");
    input1.add("re");
    input2.add("ti");
    input2.add("re");
    expected.add("ti");
    expected.add("ti");
    expected.add("re");
    expected.add("re");
    assertEquals(expected, ListExamples.merge(input1, input2));
  }

  @Test(timeout = 100)
  public void testMergeNone() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    assertEquals(expected, ListExamples.merge(input1, input2));
  }

}

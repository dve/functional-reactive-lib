package junit.org.rapidpm.frp.functions;

import org.junit.Assert;
import org.junit.Test;
import org.rapidpm.frp.functions.CheckedExecutor;
import org.rapidpm.frp.model.Result;

/**
 * Created by svenruppert on 26.04.17.
 */
public class CheckedExecutorTest {


  @Test
  public void test001() throws Exception {

    final CheckedExecutor e = () -> { /* do magic here */};
    final Result<Void> result = e.execute();
    Assert.assertNotNull(result);

    Assert.assertFalse(result.isPresent());
    Assert.assertTrue(result.isAbsent());

    Assert.assertTrue(result instanceof Result.Success);

  }

  @Test
  public void test002() throws Exception {

    final CheckedExecutor e = () -> {
      throw new RuntimeException("noop");
    };
    final Result<Void> result = e.execute();
    Assert.assertNotNull(result);

    Assert.assertFalse(result.isPresent());
    Assert.assertTrue(result.isAbsent());

    Assert.assertTrue(result instanceof Result.Failure);

  }
}

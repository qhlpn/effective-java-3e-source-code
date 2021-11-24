package effectivejava.chapter10.item73;

// 抛出能用抽象解释的异常
// 高层应该捕获低层异常，并确保抛出的异常可以用高层抽象解释。
public class Main {

    // Exception Chaining
    // try {
    //     ... // Use lower-level abstraction to do our bidding
    // } catch (LowerLevelException cause) {
    //     throw new HigherLevelException(cause);
    // }
}

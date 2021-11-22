package effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

// 总之，甚至不要尝试并行化流管道，除非你有充分的理由相信它将保持计算的正确性以及提高速度
// 不适当地并行化流的代价可能是程序失败或性能灾难
// 重要的是要记住，并行化流严格来说是一种性能优化。与任何优化一样，你必须在更改之前和之后测试性能，以确保它值得进行
public class Main {

    // Parallel stream-based program to generate the first 20 Mersenne primes - HANGS!!! (Page 222)
    // 这是怎么回事？简单地说，stream 库不知道如何并行化这个管道，因此启发式会失败。
    // 这个故事的寓意很简单：不要不加区别地将流管道并行化。 性能后果可能是灾难性的。
    public static class ParallelMersennePrimes {
        public static void main(String[] args) {
            primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                    .parallel()
                    .filter(mersenne -> mersenne.isProbablePrime(50))
                    .limit(20)
                    .forEach(System.out::println);
        }

        static Stream<BigInteger> primes() {
            return Stream.iterate(TWO, BigInteger::nextProbablePrime);
        }
    }

}


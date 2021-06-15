package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @see CyclicBarrier
 * 我们知道 CyclicBarrier 其实反映的是线程并行运行时的协调，
 * 在下面的示例里，从逻辑上，5 个工作线程其实更像是代表了 5 个可以就绪的空车，
 * 而不再是 5 个乘客，对比前面 CountDownLatch 的例子更有助于我们区别它们的抽象模型
 * https://time.geekbang.org/column/article/9373
 * @author lijie
 * @date 2021/6/14 14:29
 */
public class CyclicBarrierSample {
  public static void main(String[] args) throws InterruptedException {
      /**
       * 1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
       * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
       * 而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
       * 另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
       * 2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限
       */
      CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Action...GO again!"));
      for (int i = 0; i < 5; i++) {
          Thread t = new Thread(new CyclicWorker(barrier));
          t.start();
      }
  }
  static class CyclicWorker implements Runnable {
      private CyclicBarrier barrier;
      public CyclicWorker(CyclicBarrier barrier) {
          this.barrier = barrier;
      }
      @Override
      public void run() {
          try {
              for (int i=0; i<3 ; i++){
                  System.out.println("Executed!");
                  barrier.await();
              }
          } catch (BrokenBarrierException e) {
              e.printStackTrace();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}
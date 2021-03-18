import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印FooBar
 */

// @lc code=start
class FooBar {
    private int n;
    private Lock lock = new ReentrantLock(true);
    private Condition foo = lock.newCondition();
    //神明一个flag，为true表示应该输出foo,为false表示应该输出bar
    volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //首先获得锁
            lock.lock();
            try{
                //当前flag为false，则将当前线程变成等待状态，并且释放锁
                while(!flag){
                    foo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                //输出完foo，置flag为false
                flag = false;
                //唤醒等待线程
                foo.signal();
            }finally{
                //执行完后，释放锁
                lock.unlock();
            }	
        }
    }

    //输出bar线程与上述输出foo线程类似，flag为false时输出
    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(flag){
                    foo.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                foo.signal();
            }finally{
                lock.unlock();
            }

        }
    }
}
// @lc code=end


package com.hastemd.demo.testReflect;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 重复调用了父类的方法
 *
 * @author lijie
 * @date 2025/4/30 14:10
 */
public class OverrideDoubleInvokeTest2 {

    /**
     * Child1.setValue called
     * Parent.setValue called
     * Child1.setValue called
     * Parent.setValue called
     * value: test updateCount: 2
     *
     * @author lijie
     * @date 2025/4/30 14:22
     */
    public static void main(String[] args) {
        Child2 child2 = new Child2();
        Arrays.stream(child2.getClass().getDeclaredMethods())
                /**
                 * 由于桥接bridge 方法的存在, 这里会有两个 setValue方法
                 * @author lijie
                 * @date 2025/4/30 14:24
                 * @param args:
                 */
                //.filter(method -> method.getName().equals("setValue"))
                .filter(method -> method.getName().equals("setValue") && method.isBridge())
                .forEach(method -> {
                    // 获取修饰符
                    int modifiers = method.getModifiers();
                    System.out.println("modifiers: " + modifiers);
                    try {
                        method.invoke(child2, "test");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(child2.toString());
    }
}


abstract class Parent2<T> {
    //用于记录value更新的次数，模拟日志记录的逻辑
    AtomicInteger updateCount = new AtomicInteger();
    private T value;
    //重写toString，输出值和值更新次数
    @Override
    public String toString() {
        return String.format("value: %s updateCount: %d", value, updateCount.get());
    }
    //设置值
    public void setValue(T value) {
        System.out.println("Parent.setValue called");
        this.value = value;
        updateCount.incrementAndGet();
    }

}

class Child2 extends Parent2<String> {
    @Override
    public void setValue(String value) {
        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
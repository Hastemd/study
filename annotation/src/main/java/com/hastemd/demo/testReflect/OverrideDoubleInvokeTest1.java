package com.hastemd.demo.testReflect;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 重复调用了父类的方法
 *
 * @author lijie
 * @date 2025/4/30 14:10
 */
public class OverrideDoubleInvokeTest1 {

    /**
     * Child1.setValue called
     * Parent.setValue called
     * Parent.setValue called
     * value: test updateCount: 2
     * 打印结果如上,
     * 显然，两次 Parent 的 setValue 方法调用，是因为 getMethods 方法找到了两个名为 setValue 的方法，分别是父类和子类的 setValue 方法。
     *
     * @author lijie
     * @date 2025/4/30 14:21
     */
    public static void main(String[] args) {
        Child1 child1 = new Child1();
        Arrays.stream(child1.getClass().getMethods())
                .filter(method -> method.getName().equals("setValue"))
                .forEach(method -> {
                    try {
                        method.invoke(child1, "test");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(child1.toString());
    }
}


class Parent<T> {
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

class Child1 extends Parent {
    public void setValue(String value) {
        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
package designmode.decorator;

import com.sun.javafx.binding.StringFormatter;

import java.text.MessageFormat;

public class EggDecorator extends Decorator{
    private static int cost = 2;
    public EggDecorator(Component component){
        super(component);
    }

    // 定义自己的修饰逻辑
    private void decorateMethod(){
        // do somethind ... 
    }

    // 重写父类的方法
    @Override
    public int cost(){
        this.decorateMethod();
        String format = MessageFormat.format("加一个鸡蛋: {0}元", cost);
        System.out.println(format);
        return super.cost() + cost;
    }
}
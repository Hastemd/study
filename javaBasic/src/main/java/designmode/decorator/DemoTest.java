package designmode.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoTest {
    public static void main(String[] args){
        Component component = new ConcreteComponent();
        component = new EggDecorator(component);
        component = new EggDecorator(component);
        component = new EggDecorator(component);
        // 修饰后运行，将钱加在一起
        int cost = component.cost();
        log.info("cost: {}", cost);
    }
}
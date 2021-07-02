package designmode.decorator;

public abstract class Decorator extends Component{
    private Component component = null;
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public int cost(){
        return this.component.cost();
    }
}
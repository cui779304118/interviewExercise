package com.cuiwei.DesignPattern;

/**
 * created by cuiwei on 2018/7/15
 */

/**
 * 装饰者模式可以动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。
 *
 * 该模式的适用环境为：
 *
 * （1）在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 * （2）处理那些可以撤消的职责。
 * （3）当不能采用生成子类的方法进行扩充时。一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的子类，
 * 使得子类数目呈爆炸性增长。另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
 *
 * 实现该模式的关键步骤：
 *
 * （1）Component（被装饰对象基类）：定义对象的接口，可以给这些对象动态增加职责；
 * （2）ConcreteComponent（具体被装饰对象）：定义具体的对象，Decorator可以给它增加额外的职责；
 * （3）Decorator（装饰者抽象类）：维护指向Component实例的引用，定义与Component一致的接口（也就是要继承或实现被装饰对象基类）；
 * （4）ConcreteDecorator（具体装饰者）：具体的装饰对象，给内部持有的具体被装饰对象增加具体的职责；
 *
 * 这样讲大家可能有些不好理解，那我们还是老规矩安静：
 * 入冬以后天气越来越冷了，下班之后，做为资深吃货，约上二三好友痛快的来场火锅盛宴再爽不过了。说到火锅，
 * 不得不提在成都吃过的大龙燚火锅，各种锅底，配菜应有尽有，但我最喜欢的还是大龙燚火锅原味锅底、
 * 麻辣牛肉、大刀毛肚、天味香肠、砣砣牛肉、麻辣排骨等，想想都流口水啊。
 * 说道这大家结合装饰者的实现步骤，应该有点感觉了吧，上文提到的锅底，其实就是被装饰对象的基类，
 * 配料其实就是装饰者抽象类，大龙燚火锅原味锅底这些具体的锅底也就是具体的被装饰对象了，麻辣牛肉、大刀毛肚、
 * 天味香肠、砣砣牛肉、麻辣排骨这些装饰锅底用的各种配菜也就是具体的装饰对象。
 * 说道这，大家应该都豁然开朗了吧，下面我们开始具体的代码实现：
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        GuoDi guoDi = new GuoDiImpl("鸳鸯锅底",50);
        PeiCai niuRouWan = new NiuRouWan(guoDi);
        PeiCai maoDu = new MaoDu(niuRouWan);

        System.out.println("点菜：" + maoDu.name());
        System.out.println("总价格：" + maoDu.price());
    }

}

/**
 * Compoent（被装饰对象基类）
 */
interface GuoDi{
    public String name();
    public int price();
}

/**
 * ConcreteComponent（具体被装饰对象）
 */
class GuoDiImpl implements GuoDi{
    private String name;
    private int price;

    public GuoDiImpl(String name,int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String name() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }
}

/**
 * Decorator（装饰者抽象类）
 */
class PeiCai implements GuoDi{
    private GuoDi guodi;
    public PeiCai(GuoDi guoDi){
        this.guodi = guoDi;
    }

    @Override
    public String name() {
        return guodi.name();
    }

    @Override
    public int price() {
        return guodi.price();
    }
}

class NiuRouWan extends PeiCai{
    public NiuRouWan(GuoDi guoDi) {
        super(guoDi);
    }

    @Override
    public String name() {
        return super.name() + "+牛肉丸";
    }

    @Override
    public int price() {
        return super.price() + 30;
    }
}

class MaoDu extends PeiCai{
    public MaoDu(GuoDi guoDi) {
        super(guoDi);
    }

    @Override
    public String name() {
        return super.name() + "+毛肚";
    }

    @Override
    public int price() {
        return super.price() + 30;
    }
}



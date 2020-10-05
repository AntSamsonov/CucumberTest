package ru.dexsys.steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import ru.dexsys.CoffeeMachine;

import java.util.Map;

public class MySteps {
    private final CoffeeMachine coffeeMachine = new CoffeeMachine();

    @Дано("^Пользователь добавялет в кофемашину (\\d+) грамм зёрен$")
    public void addCoffeeToCoffeeMachine(int coffee){
        coffeeMachine.addCoffeeSeeds(coffee);
        System.out.println("Пользователь добавил в кофомашину " + coffee + " грамм кофе");
    }

    @И("^Пользователь добавляет в кофемашину (\\d+) миллилитров$")
    public void пользовательДобавляетВКофемашинуМиллилитров(int water) {
        coffeeMachine.addWater(water);
        System.out.println("Пользователь добавил в кофемашину " + water + " миллилитров воды");
    }

    @Когда("^Пользователь делает кружку с кофе$")
    public void пользовательДелаетКружкуСКофе() {
        coffeeMachine.doOneCupOfCoffee();
        System.out.println("Пользователь делает кружку кофе");
    }

    @Тогда("^В кофемашине осталось (\\d+) грамм зёрен$")
    public void вКофемашинеОсталосьГраммЗёрен(int coffee) {
        Assert.assertEquals(coffee, coffeeMachine.getCoffeeSeeds());
    }

    @И("^В кофемашине осталось (\\d+) миллилитров$")
    public void вКофемашинеОсталосьМиллилитров(int water) {
        Assert.assertEquals(water, coffeeMachine.getWater());
    }
}

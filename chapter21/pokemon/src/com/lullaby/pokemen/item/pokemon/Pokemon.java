package com.lullaby.pokemen.item.pokemon;

import com.lullaby.pokemen.item.Item;
import com.lullaby.pokemen.item.Monster;
import com.lullaby.pokemen.item.equipment.*;

public abstract class Pokemon extends Item {
    /**
     * 攻击力
     */
    protected int attack;
    /**
     * 防御力
     */
    protected  int defense;
    /**
     * 生命值
     */
    protected int health;
    /**
     * 当前生命值
     */
    protected  int currentHealth;
    /**
     * 星级，默认1星
     */
    private int star = 1;
    /**
     * 宠物小精灵可以穿戴8件装备，默认没穿戴装备
     * 穿戴顺序：头盔、铠甲、护腿、鞋子、武器、项链、戒指、手镯
     */
    private final Equipment[] equipments = new Equipment[8];

    public Pokemon(String name) {
        super(name);
    }

    @Override
    public String getItemInformation() {
        return star + "星" + name + ": 攻击=" + getAttack() + " 防御=" + getDefense() + " 生命=" + getHealth();
    }

    /**
     * 宠物小精灵攻击怪物
     * @param monster 怪物
     */
    public void attackMonster(Monster monster) {
        // 50 60    50 * 50 / 60
        int minusHealth = this.attack *this.attack / monster.getDefense();
        if (minusHealth == 0) minusHealth = 1;  // 伤害为0，需要调整伤害为1
        else if (minusHealth > monster.getCurrentHealth()) {  // 如果伤害比怪物当前血量还要高
            minusHealth = monster.getCurrentHealth();   // 伤害就应该等于怪物的当前血量
        }
        // 剩余血量
        int restHealth = monster.getCurrentHealth() - minusHealth;
        monster.setCurrentHealth(restHealth);
        System.out.println(this.name + "对" + monster.getName() + "发动攻击，造成了" + minusHealth + "伤害");
    }

    /**
     * 与其他小精灵融合
     * @param other 其他小精灵
     */
    public void merge(Pokemon other) {
        if (star == 10) {
            System.out.println(name + "星级已满，无法再融合升星");
        } else {
            this.attack += (other.attack >> 1);
            this.defense += (other.defense >> 1);
            this.health += (other.health >> 1);
            star += 1;
            System.out.println("融合成功");
            System.out.println(getItemInformation());
        }
    }

    /**
     * 跟换装备
     * @param newEquipment 新装备
     * @return 换下来的装备
     */
    public Equipment changeEquipment(Equipment newEquipment) {
        // 旧装备
        Equipment old;
        int index = -1;
        if (newEquipment instanceof Helmet) {   // 头盔
            index = 0;
        } else if (newEquipment instanceof Armor) { // 铠甲
            index = 1;
        }else if (newEquipment instanceof Leggings) { // 护腿
            index = 2;
        }else if (newEquipment instanceof Shoe) { // 鞋子
            index = 3;
        }else if (newEquipment instanceof Weapon) { // 武器
            index = 4;
        }else if (newEquipment instanceof Necklace) { // 项链
            index = 5;
        }else if (newEquipment instanceof Ring) { // 戒指
            index = 6;
        }else if (newEquipment instanceof Bracelet) { // 手镯
            index = 7;
        }
        // 旧装备
        old = this.equipments[index];
        if (old == null) {  // 未穿戴装备
            this.equipments[index] = newEquipment;
        } else {    // 已经穿戴装备
            // 新装备比旧装备好
            if(newEquipment.isBetter(old)) {
                this.equipments[index] = newEquipment;
            } else {
                old = newEquipment;
            }
        }
        return old;
    }

    /**
     * 获取生命值与生命总值百分比
     * @return 百分比
     */
    public double getHealthPercent() {
        return currentHealth * 1.0 / getHealth();
    }

    public int getAttack() {
        int totalAttack = attack;
        for (Equipment equipment : equipments) {
            if (equipment == null) continue;
            totalAttack += equipment.getAttack();
        }
        return totalAttack;
    }

    public int getDefense() {
        int totalDefense = defense;
        for (Equipment equipment : equipments) {
            if (equipment == null) continue;
            totalDefense += equipment.getDefense();
        }
        return totalDefense;
    }

    public int getHealth() {
        int totalHealth = health;
        for (Equipment equipment : equipments) {
            if (equipment == null) continue;
            totalHealth += equipment.getHealth();
        }
        return totalHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}

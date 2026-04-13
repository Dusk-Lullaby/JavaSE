package com.lullaby.pokemen.item.pokemon;

import com.lullaby.pokemen.item.Item;
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
     * 星级，默认1星
     */
    private int star = 1;
    /**
     * 宠物小精灵可以穿戴8件装备，默认没穿戴装备
     * 穿戴顺序：头盔、铠甲、护腿、鞋子、武器、项链、戒指、手镯
     */
    private Equipment[] equipments = new Equipment[8];

    public Pokemon(String name) {
        super(name);
    }

    @Override
    public String getItemInformation() {
        return name + ": 攻击=" + getAttack() + " 防御=" + getDefense() + " 生命=" + getHealth();
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
        Equipment old = null;
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
        return defense;
    }

    public int getHealth() {
        int totalHealth = health;
        for (Equipment equipment : equipments) {
            if (equipment == null) continue;
            totalHealth += equipment.getHealth();
        }
        return health;
    }
}

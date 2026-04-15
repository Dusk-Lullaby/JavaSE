package com.lullaby.pokemen.item;

import com.lullaby.pokemen.item.pokemon.Pokemon;
import com.lullaby.pokemen.util.Tools;

/**
 * 怪物
 */
public abstract class Monster extends Item {
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
     * 怪物当前生命
     */
    protected int currentHealth;

    public Monster(String name, int levelNumber) {
        super(name, levelNumber);
    }

    /**
     * 攻击宠物小精灵
     * @param pokemon 宠物小精灵
     */
    public void attackPokemon(Pokemon pokemon) {
        // 50 60    50 * 50 / 60
        int minusHealth = this.attack *this.attack / pokemon.getDefense();
        if (minusHealth == 0) minusHealth = 1;  // 伤害为0，需要调整伤害为1
        else if (minusHealth > pokemon.getCurrentHealth()) {  // 如果伤害比宠物小精灵当前血量还要高
             minusHealth = pokemon.getCurrentHealth();   // 伤害就应该等于宠物小精灵的当前血量
        }
        // 剩余血量
        int restHealth = pokemon.getCurrentHealth() - minusHealth;
        pokemon.setCurrentHealth(restHealth);
        System.err.println(this.name + "对" + pokemon.getName() + "发动攻击，造成了" + minusHealth + "伤害");
    }

    /**
     * 怪物掉落物品
     * @return 掉落的物品
     */
    public Item drop() {
        return Tools.getRandomItem(levelNumber);
    }

    public int getDefense() {
        return defense;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}

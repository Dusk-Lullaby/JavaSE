package com.lullaby.pokemen;

import com.lullaby.pokemen.item.*;
import com.lullaby.pokemen.item.equipment.Equipment;
import com.lullaby.pokemen.item.pokemon.Bulbasaur;
import com.lullaby.pokemen.item.pokemon.Pokemon;
import com.lullaby.pokemen.level.Level;
import com.lullaby.pokemen.level.LevelMap;
import com.lullaby.pokemen.util.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 冒险家
 */
public class Adventurer implements DisplayItem{
    /**
     * 装备背包
     */
    private final List<Equipment> equipments = new ArrayList<>();
    /**
     * 药品背包
     */
    private final List<HP> medicines = new ArrayList<>(List.of(new HP(1, 10)));
    /**
     * 宠物背包
     */
    private final List<Pokemon> pokemons = new ArrayList<>(List.of(new Bulbasaur()));
    /**
     * 当前关卡
     */
    private Level currentLevel;

    /**
     * 开始闯关
     */
    public void start() {
        currentLevel = new Level(null, 1, null);
        LevelMap map = currentLevel.getMap();
        // 冒险家进入地图
        map.addAdventure(this);
        while (true) {
            currentLevel.getMap().show();
            System.out.println("请选择移动方向：W(上）、A（左）、S（下）、D（右）、E（退出）");
            char direct = Tools.getInputChar();
            if (direct == 'E') {    // 退出
                System.out.println("是否确定退出？ Y/N");
                char quit = Tools.getInputChar();
                if (Character.toUpperCase(quit) == 'Y') {
                    System.out.println("感谢使用宠物小精灵闯关");
                    break;
                }
            } else {
                Item item = discovery(direct);
                // 物品被发现
                if (item != null) {
                    item.setDiscovery(true);
                    currentLevel.getMap().show();
                }
                if (item instanceof Treasure) { //宝箱
                    processTreasure((Treasure) item, direct);
                } else if (item instanceof Monster) {   // 怪物
                    processMonster((Monster) item, direct);
                } else if (item instanceof Portal) {    // 传送门
                    System.out.println("发现传送门，是否通过？ Y/N");
                    char pass = Tools.getInputChar();
                    if (Character.toUpperCase(pass) == 'Y') {
                        if (((Portal) item).isNext()) { // 是否是通往下一关卡的传送门
                            Level nextLevel = currentLevel.getNextLevel();
                            if (nextLevel == null) {    // 下一关卡为空需要创建
                                nextLevel = new Level(currentLevel, currentLevel.getNumber() + 1, null);
                                // 将冒险家加载至地图中
                                nextLevel.getMap().addAdventure(this);
                                // 当前关卡的下一关卡即为新创建的关卡
                                currentLevel.setNextLevel(nextLevel);
                            }
                            // 经过传送门后，下一关卡即为当前关卡
                            currentLevel = nextLevel;
                        } else {    // 通往上一关卡
                            Level prevLevel = currentLevel.getPrevLevel();
                            if (prevLevel == null) {
                                System.out.println("非法操作");
                            } else {
                                currentLevel = prevLevel;
                            }
                        }
                    }
                } else {    // 其他情况，往空白位置移动
                    move(direct);
                }
            }
        }
    }

    /**
     * 处理怪物
     * @param monster 怪物
     * @param direct 方向
     */
    private void processMonster(Monster monster, char direct) {
        System.out.println("发现怪物" + monster.getName() + ", 是否清除？ Y/N");
        char clear = Tools.getInputChar();
        if (Character.toUpperCase(clear) == 'Y') {
            for (int i = 0; i < pokemons.size(); i++) {
                System.out.println((i + 1) + "\t" + pokemons.get(i).getItemInformation());
            }
            System.out.println("请选择出战宠物小精灵");
            int number = Tools.getInputNumber(1, pokemons.size());
            Pokemon pokemon = pokemons.get(number - 1);
            while (monster.getCurrentHealth() > 0 && pokemon.getCurrentHealth() > 0) {
                // 获取宠物小精灵的剩余生命值比例
                double rate = pokemon.getHealthPercent();
                if (rate < 0.5) {   // 生命值低于50%，询问是否使用药品
                    boolean isHaveHP = false;
                    for (HP hp : medicines) {
                        if (hp.getCount() > 0) {
                            isHaveHP = true;
                            break;
                        }
                    }
                    if (isHaveHP) {
                        System.out.println(pokemon.getName() + "生命值低于50%，是否使用药品？ Y/N");
                        char eatHP = Tools.getInputChar();
                        if (Character.toUpperCase(eatHP) == 'Y') {
                            HP hp = getCurrentLevelHP(currentLevel.getNumber());
                            if (hp == null) {
                                System.out.println("背包中没有可用药品，请探索其他地图");
                            } else {
                                // 如果药品可以被销毁，说明没有可用数量
                                if (hp.canDestroy()) {
                                    for (int i = 0; i < medicines.size(); i++) {
                                        if (hp.getLevelNumber() == medicines.get(i).getLevelNumber()) {
                                            medicines.remove(i);
                                        }
                                    }
                                    System.out.println("药品已经使用完毕");
                                } else {
                                    int health = hp.use();
                                    pokemon.setCurrentHealth(pokemon.getCurrentHealth() + health);
                                }
                            }
                        }
                    }
                }
                Tools.lazy(300L);
                pokemon.attackMonster(monster);
                Tools.lazy(300L);
                monster.attackPokemon(pokemon);
                Tools.lazy(300L);
            }
            // 怪物已经被击败
            if (monster.getCurrentHealth() == 0) {
                System.out.println(monster.getName() + "怪物已经被击败");
                // 怪物掉落物品
                Item drop = monster.drop();
                processItem(drop);
                // 怪物被击败后
                move(direct);
            } else {    // 宠物小精灵被击败
                // 怪物回血
                monster.resume();
                System.out.println(pokemon.getName() + "已被击败");
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i).getCurrentHealth() == 0) {
                        pokemons.remove(i);
                        if (pokemons.isEmpty()) {
                            System.out.println("所有宠物小精灵全部死亡，游戏结束");
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取当前关卡的药品，如果当前关卡的药品已经使用完，那么可以使用上一关卡的药品，依次类推
     * @param levelNumber 关卡
     * @return 药品
     */
    private HP getCurrentLevelHP(int levelNumber) {
        if (levelNumber == 0) return null;
        HP hp = null;
        for (HP medicine : medicines) {
            if (medicine.getLevelNumber() == currentLevel.getNumber()) {
                hp = medicine;
                break;
            }
        }
        if (hp == null) {
            return getCurrentLevelHP(levelNumber - 1);
        } else {
            return hp;
        }
    }

    /**
     * 处理宝箱
     * @param treasure 宝箱
     * @param direct 移动的方向
     */
    private void processTreasure(Treasure treasure, char direct) {
        System.out.println("发现宝箱，是否打开？ Y/N");
        char open = Tools.getInputChar();
        if (Character.toUpperCase(open) == 'Y') {
            // 开启宝箱获得一个物品
            Item treasureItem = treasure.open();
            // 处理获得的物品
            processItem(treasureItem);
            // 宝箱处理后，冒险家移动至宝箱位置
            move(direct);
        }
    }

    /**
     * 处理获得的物品
     * @param item 物品
     */
    private void processItem(Item item) {
        // 展示获取物品信息
        System.out.println("获得" + item.getItemInformation());
        if (item instanceof HP) {   // 药品
            for (HP hp : medicines) {
                if (hp.getLevelNumber() == item.getLevelNumber()) {
                    hp.addCount(((HP) item).getCount());
                    break;
                }
            }
        } else if (item instanceof Equipment) { // 装备
            System.out.println("发现新的装备，是否给宠物小精灵更换？ Y/N");
            char change = Tools.getInputChar();
            if (Character.toUpperCase(change) == 'Y') {
                Equipment old = null;
                for (Pokemon pokemon : pokemons) {
                    // 小精灵更换装备
                    old = pokemon.changeEquipment((Equipment) item);
                    // 如果换下来的装备为空，说明后面的小精灵不需要再看了
                    if (old == null) break;
                }
                // 如果换下来的装备不为空，直接放入背包
                if (old != null) {
                    equipments.add(old);
                }
            }
        } else if (item instanceof Pokemon) {   // 宠物小精灵
            int index = -1;
            for (int i = 0; i < pokemons.size(); i++) {
                if (item.getClass() == pokemons.get(i).getClass()) {
                    index = i;
                    break;
                }
            }
            // 不存在同类型小精灵
            if (index == -1) {
                pokemons.add((Pokemon) item);
            } else {    // 存在同类型宠物小精灵
                System.out.println("发现可融合宠物小精灵，是否融合？ Y/N");
                char merge = Tools.getInputChar();
                if (Character.toUpperCase(merge) == 'Y') {
                    pokemons.get(index).merge((Pokemon) item);
                } else {    // 不融合直接放入背包
                    pokemons.add((Pokemon) item);
                }
            }
        }
    }

    /**
     * 探索给定方向地图位置
     * @param direct 方向
     * @return 得到的物品
     */
    private Item discovery(char direct) {
        return (Item)currentLevel.getMap().getPositionItem(direct);
    }

    /**
     * 向给定方向地图位置移动
     * @param direct 方向
     */
    private void move(char direct) {
        currentLevel.getMap().move(direct);
    }

    @Override
    public String getItemInformation() {
        return "@";
    }
}

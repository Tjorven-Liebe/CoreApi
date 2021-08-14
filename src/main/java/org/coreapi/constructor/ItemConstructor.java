package org.coreapi.constructor;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemConstructor {


    private ItemStack item;
    private ItemMeta itemMeta;

    public ItemConstructor(Material material, short subID) {
        item = new ItemStack(material, 1, subID);
        itemMeta = item.getItemMeta();
    }

    public ItemConstructor(Material material) {
        this(material, (short)0);
    }

    public ItemConstructor setName(String name) {
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemConstructor setLore(String... lore) {
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemConstructor setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemConstructor addEnch(Enchantment ench, Integer amount, Boolean isLegit) {

        itemMeta.addEnchant(ench, amount, isLegit);

        return this;
    }
    public ItemConstructor setDura(int dura) {

        item.setDurability((short) dura);

        return this;
    }

    public ItemConstructor addItemFlag(ItemFlag... itemFlag) {

        itemMeta.addItemFlags(itemFlag);

        return this;
    }


    public ItemStack build() {
        item.setItemMeta(itemMeta);
        return item;
    }


}

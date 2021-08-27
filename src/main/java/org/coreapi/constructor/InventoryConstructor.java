package org.coreapi.constructor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryConstructor {

    Inventory inventory = Bukkit.createInventory(null, 27);

    public InventoryConstructor(InventoryHolder inventoryHolder, InventorySize inventorySize, String name) {
        switch (inventorySize) {
            case ONE_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 9, name);
                break;
            case TWO_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 18, name);
                break;
            case FOUR_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 36, name);
                break;
            case FIVE_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 45, name);
                break;
            case DOUBLE_CHEST:
                inventory = Bukkit.createInventory(inventoryHolder, 54, name);
                break;
            case CHEST:
            default:
                inventory = Bukkit.createInventory(inventoryHolder, 27, name);
                break;
        }
    }

    public InventoryConstructor(InventoryHolder inventoryHolder, InventoryType inventoryType, String name) {
        inventory = Bukkit.createInventory(inventoryHolder, inventoryType, name);
    }

    public InventoryConstructor(InventoryHolder inventoryHolder, InventorySize inventorySize) {
        switch (inventorySize) {
            case ONE_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 9);
                break;
            case TWO_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 18);
                break;
            case FOUR_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 36);
                break;
            case FIVE_ROW:
                inventory = Bukkit.createInventory(inventoryHolder, 45);
                break;
            case DOUBLE_CHEST:
                inventory = Bukkit.createInventory(inventoryHolder, 54);
                break;
            case CHEST:
            default:
                inventory = Bukkit.createInventory(inventoryHolder, 27);
                break;
        }
    }

    public InventoryConstructor(Inventory inventory) {
        this.inventory = inventory;
    }

    public InventoryConstructor setMaxStackSize(Integer size) {
        inventory.setMaxStackSize(size);
        return this;
    }

    public InventoryConstructor setItem(Integer slot, ItemStack itemStack) {
        inventory.setItem(slot, itemStack);
        return this;
    }

    public InventoryConstructor setContents(ItemStack[] contents) {
        inventory.setContents(contents);
        return this;
    }

    public InventoryConstructor addItem(ItemStack itemStack) {
        inventory.addItem(itemStack);
        return this;
    }

    public InventoryConstructor remove(ItemStack itemStack) {
        inventory.remove(itemStack);
        return this;
    }

    public InventoryConstructor remove(Material material) {
        inventory.remove(material);
        return this;
    }

    @Deprecated
    public InventoryConstructor remove(Integer materialId) {
        inventory.remove(materialId);
        return this;
    }

    public void clear() {
        inventory.clear();
    }

    public void clear(Integer index) {
        inventory.clear(index);
    }

    public boolean contains(ItemStack itemStack) {
        return inventory.contains(itemStack);
    }

    public boolean contains(ItemStack itemStack, Integer amount) {
        return inventory.contains(itemStack, amount);
    }

    public boolean contains(Material material) {
        return inventory.contains(material);
    }

    public boolean contains(Material material, Integer amount) {
        return inventory.contains(material, amount);
    }

    @Deprecated
    public boolean contains(Integer materialId) {
        return inventory.contains(materialId);
    }

    @Deprecated
    public boolean contains(Integer materialId, Integer amount) {
        return inventory.contains(materialId, amount);
    }

    public boolean containsAtLeast(ItemStack itemStack, Integer amount) {
        return inventory.containsAtLeast(itemStack, amount);
    }

    public Integer first(ItemStack itemStack) {
        return inventory.first(itemStack);
    }

    public Integer first(Material material) {
        return inventory.first(material);
    }

    @Deprecated
    public Integer first(Integer materialId) {
        return inventory.first(materialId);
    }

    public ItemStack getItemOnSlot(Integer slot) {
        return inventory.getItem(slot);
    }

    public Integer firstEmpty() {
        return inventory.firstEmpty();
    }

    public InventoryHolder getHolder() {
        return inventory.getHolder();
    }

    public String getName() {
        return inventory.getName();
    }

    public Inventory getInventory() {
        return inventory;
    }

}

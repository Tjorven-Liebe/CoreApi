package org.coreapi.constructor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.coreapi.api.Api;

public class PageableInventory extends GlassPane implements Listener {

    Inventory inventory = null;

    @Deprecated
    @Warning
    public PageableInventory() {}

    public static ItemStack[] itemStacks;

    public String inventoryName;

    public PageableInventory(String inventoryName, Player player, ItemStack[] itemStacks) {
        this.inventoryName = inventoryName;
        inventory = Bukkit.createInventory(null, 54, inventoryName);
        PageableInventory.itemStacks = itemStacks;
    }

    /*
    Integer pages = 1;

    public void calculatePages(ItemStack[] itemStacks) {
        for (ItemStack itemStack : itemStacks) {
            count++;
            if (count >= 35*pages) {
                pages++;

            }
        }
    }*/

    public void openInventory(Integer currentPage, Player player) {
        player.openInventory(inventory);
        openPage(currentPage, itemStacks);
    }

    Integer count = 0;

    public void openPage(Integer page, ItemStack[] itemStacks) {
        ItemStack next = new ItemConstructor(Material.ARROW).setName("§cNext Page").build();
        ItemStack previous = new ItemConstructor(Material.ARROW).setName("§cPrevious Page").build();
        inventory.clear();
        for (int i = 0; i <= 8; i++) {
            inventory.setItem(i, grayGlassPane());
        }

        for (int i = 45; i <= 53; i++) {
            inventory.setItem(i, grayGlassPane());
        }

        for (int i = 0; i<= 35*page; i++) {
            Api.getLogger().info(i + "");

            if (page == 1) {
                if (i <= 35) {
                    inventory.setItem(i + 9, itemStacks[(i)]);
                }
                if (i == 35) {
                    inventory.setItem(53, next);
                }
            }
                if (page>1) {
                    if (i <= 35) {
                        inventory.setItem(i+9, itemStacks[(i) + (35*(page-1))]);
                        inventory.setItem(45, previous);
                    }
                    if (i == 35) {
                        inventory.setItem(53, next);

                    }
                }

        }

    }

    int currentPage = 1;

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        try {
            Player player = (Player) event.getWhoClicked();
            inventory = event.getInventory();
            if (inventory.getName().startsWith(inventory.getName())) {

                event.setCancelled(true);

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cNext Page")) {
                    currentPage++;

                    openPage(currentPage, itemStacks);
                    Api.getLogger().info(currentPage + "");


                }

                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cPrevious Page")) {
                        currentPage--;

                        openPage(currentPage, itemStacks);
                        Api.getLogger().info(currentPage + "");


                    }
            }
        }catch (Exception exception) {
            Api.getLogger().error(exception);
        }
    }

}

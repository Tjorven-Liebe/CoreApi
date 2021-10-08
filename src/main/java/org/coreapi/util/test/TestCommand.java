package org.coreapi.util.test;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.coreapi.constructor.ItemConstructor;
import org.coreapi.constructor.PageableInventory;

import java.util.ArrayList;
import java.util.List;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Player player = (Player) sender;
            List<ItemStack> list = new ArrayList<>();

            String[] arguments = {
                    "Cericx_", "zPxshi", "zPxin"
            };

            ItemStack itemStack = null;

            for (String skull : arguments) {
                itemStack = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
                skullMeta.setOwner(skull);
                skullMeta.setDisplayName("§7" + skull);
                itemStack.setItemMeta(skullMeta);
                list.add(itemStack);
            }

            for (int i = 0; i <= 150; i++) {
                list.add(new ItemConstructor(Material.WOOD).setName("" + i).build());
            }


            ItemStack[] itemStacks = list.toArray(new ItemStack[0]);

            PageableInventory pageableInventory = new PageableInventory( "§8> §4Team", player, itemStacks);
            pageableInventory.openInventory(1, player);
        return false;
    }
}

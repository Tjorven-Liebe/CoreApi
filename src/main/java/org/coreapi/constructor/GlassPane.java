package org.coreapi.constructor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class GlassPane implements ColouredGlassInterface {

    @Override
    public ItemStack whiteGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 0).setName(" ").build();
    }

    @Override
    public ItemStack orangeGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 1).setName(" ").build();
    }

    @Override
    public ItemStack magentaGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 2).setName(" ").build();
    }

    @Override
    public ItemStack lightBlueGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 3).setName(" ").build();
    }

    @Override
    public ItemStack yellowGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 4).setName(" ").build();
    }

    @Override
    public ItemStack limeGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 5).setName(" ").build();
    }

    @Override
    public ItemStack pinkGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 6).setName(" ").build();
    }

    @Override
    public ItemStack grayGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 7).setName(" ").build();
    }

    @Override
    public ItemStack lightGrayGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 8).setName(" ").build();
    }

    @Override
    public ItemStack cyanGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 9).setName(" ").build();
    }

    @Override
    public ItemStack purpleGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 10).setName(" ").build();
    }

    @Override
    public ItemStack blueGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 11).setName(" ").build();
    }

    @Override
    public ItemStack brownGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 12).setName(" ").build();
    }

    @Override
    public ItemStack greenGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 13).setName(" ").build();
    }

    @Override
    public ItemStack redGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 14).setName(" ").build();
    }

    @Override
    public ItemStack blackGlassPane() {
        return new ItemConstructor(Material.STAINED_GLASS_PANE, (byte) 15).setName(" ").build();
    }
}

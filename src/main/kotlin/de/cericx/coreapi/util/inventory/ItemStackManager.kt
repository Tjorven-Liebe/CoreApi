package de.cericx.coreapi.util.inventory

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemStackManager {

    fun newItemStack(material: Material, amount: Int, displayName: String):ItemStack {
        val itemStack = ItemStack(material, amount)
        val itemMeta = itemStack.itemMeta
        itemMeta!!.displayName = displayName
        itemStack.itemMeta=itemMeta
        return itemStack
    }

}
package mymod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MyBow extends ItemBow {
    
    private String texturePath = "mymod:";
    
    public MyBow(int ItemID, String textureName)
    {
        super(ItemID);
        this.setUnlocalizedName(textureName);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        texturePath += textureName;
    }

@Override   
@SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }   
/** Makes your Item Enchanted when it is crafted */
public void onCreated(ItemStack item, World world, EntityPlayer player) 
{
    item.addEnchantment(Enchantment.flame, 1);
    item.addEnchantment(Enchantment.power, 5);
    // Replace the "." after "Enchantment" to see options
    // The number is the Enchantment Level
}

}
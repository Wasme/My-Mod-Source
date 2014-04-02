package mymod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MySword extends ItemSword {
    
    private String texturePath = "mymod:";
    
    public MySword(int ItemID, EnumToolMaterial material, String textureName)
    {
        super(ItemID, material);
        this.setUnlocalizedName(textureName);
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
    item.addEnchantment(Enchantment.knockback, 10);
    // Replace the "." after "Enchantment" to see options
    // The number is the Enchantment Level
}

/** Creates an Explosive lightning bolt that 
* sends the target flying through the air and sets it on fire */
    public boolean hitEntity(ItemStack item, EntityLivingBase target, EntityLivingBase player)
    {
        /** Creates an Explosion */
            //target.worldObj.createExplosion(target, target.posX, target.posY, target.posZ, 2.0F, true); // The size of the explosion

        /** Summons a Lightning Bolt */
            //target.worldObj.addWeatherEffect(new EntityLightningBolt(target.worldObj, target.posX, target.posY, target.posZ));

        /** Sends the target flying through the air */
            target.addVelocity(0, 1, 0); // The middle number is the upwards velocity

        /** Sets the target on Fire */
            //target.setFire(10); // The number of ticks it will be on fire

        return true;
}

    
}
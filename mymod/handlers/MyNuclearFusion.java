package mymod.handlers;

import mymod.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class MyNuclearFusion implements IFuelHandler {
  @Override
  public int getBurnTime(ItemStack fuel) {
    int ID = fuel.itemID;
    if(ID == Main.MyWarhead_1.itemID) {
      return 50000;
    } else if(ID == Main.MyWarhead_1.itemID) {
      return 0;
    } else {
      return 0;
    }
  }
}

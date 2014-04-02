package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.biome.MyBiome;
import mymod.biome.MyDarkBiome;
import mymod.biome.MyJurassicBiome;
import mymod.biome.MySwampyPitBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.blocks.MyBlockGen_2;
import mymod.entity.abe.MyEntityAbe;
import mymod.entity.abe.MyModelAbe;
import mymod.entity.abe.MyRenderAbe;
import mymod.entity.ghast.MyEntityGhast;
import mymod.entity.ghast.MyRenderGhast;
import mymod.entity.threed.MyEntityThreed;
import mymod.entity.threed.MyModelThreed;
import mymod.entity.threed.MyRenderThreed;
import mymod.entity.wraith.MyEntityWraith;
import mymod.entity.wraith.MyModelWraith;
import mymod.entity.wraith.MyRenderWraith;
import mymod.entitywolf.MyEntityWolf;
import mymod.entitywolf.MyModelWolf;
import mymod.entitywolf.MyRenderWolf;
import mymod.handlers.MyCraftingHandler;
import mymod.handlers.MyFuelHandler;
import mymod.handlers.MyNuclearFusion;
import mymod.handlers.MyPickupHandler;
import mymod.items.MyAxe;
import mymod.items.MyBow;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.items.MyWarhead;
import mymod.items.MyWizzardstaff;
import mymod.projectiles.MyEntityNuke;
import mymod.projectiles.MyEntityProjectile;
import mymod.projectiles.MyNuke;
import mymod.projectiles.MyProjectile;
import mymod.projectiles.MyRenderNuke;
import mymod.projectiles.MyRenderProjectile;
import mymod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "Death mod", version = "1.0")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */

//  DECLARE THE SWORD 
    public static Item MySword_1;
    
//  DECLARE THE BATTLE AXE 
    public static Item MySword_2;
    
//  DECLARE THE PICKAXE 
    public static Item MyPickaxe_1;
    
//  DECLARE THE AXE 
    public static Item MyAxe_1;
   
//  DECLARE THE WIZZARD STAFF 
    public static Item MyWizzardstaff_1;
    
//  DECLARE NEW TOOL MATERIAL
    										/** Harvest Level, Max Uses, Efficiency (f), Damage (f), Enchantability */
    public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Death Shard", 3, 560, 15.0F, 15.0F, 22);  
    
//  DECLARE THE ITEM DEATH SHARD
	public static Item MyItem_1;
    
//  DECLARE THE ITEM SOLAR EMBER
    public static Item MyItem_2;
    
//  DECLARE THE ITEM WARHEAD
    public static Item MyWarhead_1;
    
//  DECLARE THE PROJECTILE SUPER NOVA
	public static Item MyProjectile_1;

//  DECLARE THE PROJECTILE NUKE
	public static Item MyNuke_1;
	
//  DECLARE THE FOOD
    public static Item MyFood_1;
    
//  DECLARE THE A&W ROOT BEER 
    public static Item MyFood_2;
    
//  DECLARE THE BEATING HEART 
    public static Item MyFood_3;
    
//  DECLARE THE BLOCK
    public static Block MyBlock_1;
    
//  DECLARE THE MYBOW
    public static Item MyBow_1;
    
 //  DECLARE THE DARK 
    public static Block MyBlock_4;
    
//  DECLARE THE SOLAR FLARE
    public static Block MyBlock_5;
    
    
//  DECLARE THE ARMOR
    public static Item MyHelmet_1;
    public static Item MyChest_1;
    public static Item MyLeggings_1;
    public static Item MyBoots_1;
    
//  DECLARE THE ARMOR MATERIAL
    															/**maxDamageFactor, damageReductionAmountArray, Enchantability */
    public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Death Material", 100, new int[]{4, 8, 6, 4}, 50);
    
//  DECLARE THE BIOME
    public static  BiomeGenBase MyBiome_1;
    
//  DECLARE THE DARK BIOME
    public static  BiomeGenBase MyDarkBiome_1;
    
//  DECLARE THE SWAMPY PIT BIOME
    public static  BiomeGenBase MySwampyPitBiome_1;
    
//  DECLARE THE BIOME
    public static  BiomeGenBase MyJurassicBiome_1;
    
//  DECLARE THE MOB ID
    static int MyEntityID = 300;

//  SEARCH FOR UNIQUE ID    
    public static int getUniqueEntityId() {
        do {
            MyEntityID++;
        }
        while (EntityList.getStringFromID(MyEntityID) != null);
        return MyEntityID++;
    }

 //  DECLARE A NEW EGG
    public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
    
    
    
//	DECLARE THE NEW ACHIEVEMENTS
	public static Achievement MyAchievement_1;
	public static Achievement MyAchievement_2;
	public static Achievement MyAchievement_3;
	
//  DECLARE A NEW CREATIVE TAB  
    public static CreativeTabs MyCreativeTab_1;
	
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

 //  LOAD THE CREATIVE TAB
    MyCreativeTab_1 = new CreativeTabs("MyCreativeTab_1") {
        public ItemStack getIconItemStack() {
            return new ItemStack(MySword_1, 1, 0);   // Icon, Stack Size, Tab Position
        }
    };
	
//  LOAD THE SWORD
    MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MySword_1, "MySword_1");
    LanguageRegistry.addName(MySword_1, "Death Sword"); 

    
//  LOAD THE BATTLE AXE
    MySword_2 = new MySword(2023, MyToolMaterial, "MySword_2").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MySword_2, "MySword_2");
    LanguageRegistry.addName(MySword_2, "Battle Axe");
    
    
//  LOAD THE PICKAXE
    MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
    LanguageRegistry.addName(MyPickaxe_1, "Death Pickaxe");
    
//  LOAD THE AXE
    MyAxe_1 = new MyAxe(2025, MyToolMaterial, "MyAxe_1").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyAxe_1, "MyAxe_1");
    LanguageRegistry.addName(MyAxe_1, "Death Axe");
      
//  LOAD THE WIZZARD STAFF
    MyWizzardstaff_1 = new MyWizzardstaff(2024, MyToolMaterial, "MyWizzardstaff_1").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyWizzardstaff_1, "MyWizzardstaff_1");
    LanguageRegistry.addName(MyWizzardstaff_1, "Thunder Staff");
	
//  LOAD THE ITEM DEATH SHARD
    MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyItem_1, "MyItem_1");
    LanguageRegistry.addName(MyItem_1, "Death Shard");
   
//  LOAD THE ITEM SOLAR EMBER  
    MyItem_2 = new MyItem(2031, "MyItem_2").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyItem_2, "MyItem_2");
    LanguageRegistry.addName(MyItem_2, "Solar Ember");  
    
//  LOAD THE ITEM SUPER NOVA
    MyProjectile_1 = new MyProjectile(2032, "MyProjectile_1").setMaxStackSize(64).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyProjectile_1, "MyProjectile_1");
    LanguageRegistry.addName(MyProjectile_1, "Super Nova");
    
//  LOAD THE ITEM MYBOW
    MyBow_1 = new MyBow(2033, "MyBow_1").setMaxStackSize(64).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyBow_1, "MyBow_1");
    LanguageRegistry.addName(MyBow_1, "Crossbow");
 
//  LOAD THE ITEM WARHEAD
    MyWarhead_1 = new MyWarhead(2034, "MyWarhead_1").setMaxStackSize(64).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyWarhead_1, "MyWarhead_1");
    LanguageRegistry.addName(MyWarhead_1, "Nuclear reactor");
    
//  LOAD THE ITEM NUKE
    MyNuke_1 = new MyNuke(2035, "MyNuke_1").setMaxStackSize(64).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyNuke_1, "MyNuke_1");
    LanguageRegistry.addName(MyNuke_1, "Nuke Missle");
    
//  REGISTER THE PROJECTILE ENTITY
    EntityRegistry.registerGlobalEntityID(MyEntityProjectile.class, "MyProjectile_1", 1);
    EntityRegistry.registerModEntity(MyEntityProjectile.class, "MyProjectile_1", 1, this, 256, 1, true);
    LanguageRegistry.instance().addStringLocalization("entity.modid.MyProjectile_1.name", "My Awesome Projectile");
    RenderingRegistry.registerEntityRenderingHandler(MyEntityProjectile.class, new MyRenderProjectile(MyProjectile_1)); 
    
//  REGISTER THE PROJECTILE NUKE MISSLE
    EntityRegistry.registerGlobalEntityID(MyEntityNuke.class, "MyNuke_1", 1);
    EntityRegistry.registerModEntity(MyEntityNuke.class, "MyNuke_1", 2, this, 256, 1, true);
    LanguageRegistry.instance().addStringLocalization("entity.modid.MyNuke_1.name", "Nuke Missle");
    RenderingRegistry.registerEntityRenderingHandler(MyEntityNuke.class, new MyRenderNuke(MyNuke_1)); 
    
//  LOAD THE FOOD
    /** ItemID, HealAmount, SaturationModifier (F), iswolfsFavoriteMeat, Texture Name */
    MyFood_1 = new MyFood(2040, 12, 6.0F, true, "MyFood_1").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyFood_1, "MyFood_1");
    LanguageRegistry.addName(MyFood_1, "Cheeseburger");
    
//  LOAD THE A&W ROOT BEER
    /** ItemID, HealAmount, SaturationModifier (F), iswolfsFavoriteMeat, Texture Name */
    MyFood_2 = new MyFood(2041, 3, 0.9F, false, "MyFood_2").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyFood_2, "MyFood_2");
    LanguageRegistry.addName(MyFood_2, "A&W Rootbeer");
    
//  LOAD THE BEATING HEART
    /** ItemID, HealAmount, SaturationModifier (F), iswolfsFavoriteMeat, Texture Name */
    MyFood_3 = new MyFood(2042, 3, 0.9F, true, "MyFood_3").setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 60, 10, 1.0F).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyFood_3, "MyFood_3");
    LanguageRegistry.addName(MyFood_3, "Beating Heart");
    
//  LOAD THE BLOCK 
    MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.5F).setResistance(15.0F).setHardness(35.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
    LanguageRegistry.addName(MyBlock_1, "Death Ore");
	MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 3);
    
//  LOAD THE DARK
    MyBlock_4 = new MyBlock(253, Material.rock, "MyBlock_4").setLightValue(0.1F).setResistance(10.0F).setHardness(10.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerBlock(MyBlock_4, "MyBlock_4");
    LanguageRegistry.addName(MyBlock_4, "Dark");
	MinecraftForge.setBlockHarvestLevel(MyBlock_4, "pickaxe", 2);
	
//  LOAD THE SOLAR FLARE- (Notice that i had to change the number to 554)
    MyBlock_5 = new MyBlock(554, Material.rock, "MyBlock_5").setLightValue(1.0F).setResistance(5.0F).setHardness(1.0F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerBlock(MyBlock_5, "MyBlock_5");
    LanguageRegistry.addName(MyBlock_5, "Solar Flare");
	MinecraftForge.setBlockHarvestLevel(MyBlock_5, "pickaxe", 1);
	
	
//  LOAD HELMET 
    MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
    LanguageRegistry.addName(MyHelmet_1, "Death Helmet");      

//  LOAD CHESTPLATE
    MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyChest_1, "MyChest_1");
    LanguageRegistry.addName(MyChest_1, "Death Chestplate");

//  LOAD LEGGINGS    
    MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
    LanguageRegistry.addName(MyLeggings_1, "Death Leggings");

//  LOAD BOOTS   
    MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor").setCreativeTab(MyCreativeTab_1);
    GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
    LanguageRegistry.addName(MyBoots_1, "Death Boots");
	
//  LOAD BIOME
    MyBiome_1 = new MyBiome(30);
    GameRegistry.addBiome(MyBiome_1);
    
//  LOAD DARK BIOME
    MyDarkBiome_1 = new MyDarkBiome(31);
    GameRegistry.addBiome(MyDarkBiome_1);
    
//  LOAD SWAMPY PIT BIOME
    MySwampyPitBiome_1 = new MySwampyPitBiome(32);
    GameRegistry.addBiome(MySwampyPitBiome_1);
    
//  LOAD MyJurassicBiome_1
    MyJurassicBiome_1 = new MyJurassicBiome(33);
    GameRegistry.addBiome(MyJurassicBiome_1);
    
//  REMOVE OTHER BIOMES
    //GameRegistry.removeBiome(BiomeGenBase.beach);
    //GameRegistry.removeBiome(BiomeGenBase.desert);
    //GameRegistry.removeBiome(BiomeGenBase.desertHills);
    //GameRegistry.removeBiome(BiomeGenBase.desertHills);
    //GameRegistry.removeBiome(BiomeGenBase.extremeHills);
    //GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
    //GameRegistry.removeBiome(BiomeGenBase.forest);
    //GameRegistry.removeBiome(BiomeGenBase.forestHills);
    //GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
    //GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
    //GameRegistry.removeBiome(BiomeGenBase.iceMountains);
    //GameRegistry.removeBiome(BiomeGenBase.icePlains);
    //GameRegistry.removeBiome(BiomeGenBase.jungle);
    //GameRegistry.removeBiome(BiomeGenBase.jungleHills);
    //GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
    //GameRegistry.removeBiome(BiomeGenBase.ocean);
    //GameRegistry.removeBiome(BiomeGenBase.plains);
    //GameRegistry.removeBiome(BiomeGenBase.river);
    //GameRegistry.removeBiome(BiomeGenBase.swampland);
    //GameRegistry.removeBiome(BiomeGenBase.taiga);
    //GameRegistry.removeBiome(BiomeGenBase.taigaHills);
    
//  REGISTER YOUR ENTITY
    EntityRegistry.registerGlobalEntityID(MyEntityGhast.class, "Ghastybruger", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.addSpawn(MyEntityGhast.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert);
    EntityRegistry.addSpawn(MyEntityGhast.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.desertHills);
    EntityRegistry.addSpawn(MyEntityGhast.class, 2, 1, 1, EnumCreatureType.monster, MyBiome_1);     
    registerEntityEgg(MyEntityGhast.class, (new Color(220, 163, 53)).getRGB(), (new Color(255, 0, 0)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityGhast.class, new MyRenderGhast());
    ModLoader.addLocalization("entity.Ghastybruger.name", "Ghastybruger");
    
//  REGISTER YOUR Dark Wraith
    EntityRegistry.registerGlobalEntityID(MyEntityWraith.class, "Dark Wraith", EntityRegistry.findGlobalUniqueEntityId());  
    EntityRegistry.addSpawn(MyEntityWraith.class, 5, 1, 2, EnumCreatureType.monster, MyDarkBiome_1); 
    registerEntityEgg(MyEntityWraith.class, (new Color(0, 0, 0)).getRGB(), (new Color(140, 18, 90)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityWraith.class, new MyRenderWraith(new MyModelWraith(), 0.3F));
    ModLoader.addLocalization("entity.Dark Wraith.name","Dark Wraith");
    
//  REGISTER YOUR Village Guard
    EntityRegistry.registerGlobalEntityID(MyEntityThreed.class, "Village Guard", EntityRegistry.findGlobalUniqueEntityId());  
    EntityRegistry.addSpawn(MyEntityThreed.class, 1, 1, 1, EnumCreatureType.monster, MySwampyPitBiome_1);  
    EntityRegistry.addSpawn(MyEntityThreed.class, 0, 0, 0, EnumCreatureType.monster, MyBiome_1);  
    registerEntityEgg(MyEntityThreed.class, (new Color(4, 12, 223)).getRGB(), (new Color(65, 46, 5)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityThreed.class, new MyRenderThreed(new MyModelThreed(), 0.3F));
    ModLoader.addLocalization("entity.Village Guard.name","Village Guard");
    
//  REGISTER YOUR Magma Monkey
    EntityRegistry.registerGlobalEntityID(MyEntityAbe.class, "Magma Monkey", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.addSpawn(MyEntityAbe.class, 15, 1, 10, EnumCreatureType.monster, MyDarkBiome_1);     
    registerEntityEgg(MyEntityAbe.class, (new Color(46, 30, 20)).getRGB(), (new Color(244, 92, 0)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityAbe.class, new MyRenderAbe(new MyModelAbe(), 0.3F));
    ModLoader.addLocalization("entity.Magma Monkey.name", "Magma Monkey");
    
//  REGISTER YOUR ENTITY DARK WOLF
    EntityRegistry.registerGlobalEntityID(MyEntityWolf.class, "Dark Wolf", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.addSpawn(MyEntityWolf.class, 50, 1, 5, EnumCreatureType.monster, MyDarkBiome_1);     
    registerEntityEgg(MyEntityWolf.class, (new Color(175, 27, 30)).getRGB(), (new Color(0, 0, 0)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityWolf.class, new MyRenderWolf(new MyModelWolf(), 0.3F));
    ModLoader.addLocalization("entity.Dark Wolf.name", "Dark Wolf");
   
    
//	LOAD THE ACHIEVEMENTs
		MyAchievement_1 = new Achievement(2001, "MyAchievement_1", -3, -1, MyBlock_1, AchievementList.openInventory).registerAchievement();
		MyAchievement_2 = new Achievement(2002, "MyAchievement_2", -5, -1, MyItem_1, MyAchievement_1).registerAchievement();
		MyAchievement_3 = new Achievement(2003, "MyAchievement_3", -7, -1, MySword_1, MyAchievement_2).registerAchievement();
		//	(id, "NameOfAchievement", x, y coordinates on Achievement map, icon, Required Achievement to unlock)
		// 	For no Pre-required achievement, use "(Achievement)null"
    
	
		
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */

//  SWORD RECIPE  
    GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
    {
            "X",
            "X",
            "S",
        'S', Item.blazeRod,
        'X', MyItem_1,
    });

//  BATTLE AXE RECIPE  
    GameRegistry.addRecipe(new ItemStack(MySword_2, 1), new Object[]
    {
            "SDS",
            " L ",
            " B ",
        'L', Main.MyItem_1,
        'S', Main.MyItem_2,
        'D', Item.diamond,
        'B', Item.blazeRod,
    });
    
    
//  PICKAXE RECIPE  
    GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
    {
            "XXX",
            " S ",
            " S ",
        'S', Item.blazeRod,
        'X', MyItem_1,
    });
    
//  AXE RECIPE 1
    GameRegistry.addRecipe(new ItemStack(MyAxe_1, 1), new Object[]
    {
            " XX",
            " SX",
            " S ",
        'S', Item.blazeRod,
        'X', MyItem_1,
    });
  /** [  This Is So I Can Craft MyAxe In Two Different Ways  ] */
  //   AXE RECIPE 2  
    GameRegistry.addRecipe(new ItemStack(MyAxe_1, 1), new Object[]
    {
            "XX ",
            "XS ",
            " S ",
        'S', Item.blazeRod,
        'X', MyItem_1,
    });
    
        //  WIZZARD STAFF RECIPE  
    GameRegistry.addRecipe(new ItemStack(MyWizzardstaff_1, 1), new Object[]
    {
            "  X",
            " S ",
            "S  ",
        'S', Item.blazeRod,
        'X', Item.diamond ,
    });
    

//  ITEM RECIPE FOR DEATH SHARD         
    GameRegistry.addRecipe(new ItemStack(MyItem_1, 3), new Object[]
    {
            "S",
            "S",
            "S",
        'S', Block.obsidian,
    });  
    
//  ITEM RECIPE FOR SUPER NOVA        
    GameRegistry.addRecipe(new ItemStack(MyProjectile_1, 2), new Object[]
    {
            "SXS",
            "XSX",
            "SXS",
        'X', Main.MyItem_2,
        'S', Block.tnt,
    });
    
//  ITEM RECIPE FOR NUKE        
    GameRegistry.addRecipe(new ItemStack(MyNuke_1, 1), new Object[]
    {
            " S ",
            "SXS",
            " S ",
        'X', Main.MyWarhead_1,
        'S', Main.MyItem_2,
    });
    
    
//  ITEM RECIPE FOR THE WARHEAD        
    GameRegistry.addRecipe(new ItemStack(MyWarhead_1, 1), new Object[]
    {
    	"SXS",
        "XSX",
        "SXS",
    'S', Main.MyProjectile_1,
    'X', Main.MyItem_2,
});
    
//  FOOD RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_1, 2), new Object[]
    {
            "S",
            "X",
            "S",
        'S', MyFood.bread,
        'X', MyFood.beefCooked,
    });
    
//  MYBOW RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyBow_1, 1), new Object[]
    {
            "WSX",
            "SS ",
            "X S",
        'S', Main.MyItem_1,
        'X', Item.silk,
        'W', Main.MyItem_2,
    });
    
    
//  A&W ROOT BEER RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_2, 1), new Object[]
    {
            " S ",
            "XWX",
            " X ",
        'S', Item.sugar,
        'X', Item.glassBottle,
        'W', Item.wheat,
    });
    
//  BEATING HEART RECIPE       
    GameRegistry.addRecipe(new ItemStack(MyFood_3, 1), new Object[]
    {
            "S S",
            "SSS",
            " S ",
        'S', Item.redstone,
      
       
    });
    
//  SMELTING RECIPE
    GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 1)), 50);
    
//  SMELTING RECIPE SOLAR EMBER 
    GameRegistry.addSmelting(MyBlock_5.blockID, (new ItemStack(MyItem_2, 1)), 50);
    
    
//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', MyItem_1,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_1,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_1,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_1,
    });
    
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

    
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
    
//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen_2());
    
//	CHANGE THE TEXT OF THE ACHIEVEMENTs	
	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1", "en_US", "Dark Miner");
	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1.desc", "en_US", "Find Death Ore");
	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2", "en_US", "Dark Material");
	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2.desc", "en_US", "Powerful Substants");
	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_3", "en_US", "The Death Blade");
	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_3.desc", "en_US", "Forged Blade");
	
	 //  REGISTER PICKUP HANDLER
    MyPickupHandler MyPickupHandler_1 = new MyPickupHandler();
    GameRegistry.registerPickupHandler(MyPickupHandler_1);
    
	// REGISTER THE FUEL HANDLER
    GameRegistry.registerFuelHandler(new MyFuelHandler());
    
	// REGISTER THE FUEL HANDLER NUCLEAR FUSION
    GameRegistry.registerFuelHandler(new MyNuclearFusion());
    
    //  REGISTER CRAFTING HANDLER
    MyCraftingHandler MyCraftingHandler_1 = new MyCraftingHandler();
    GameRegistry.registerCraftingHandler(MyCraftingHandler_1);  
    
//  CHANGE TAB NAME
    LanguageRegistry.instance().addStringLocalization("itemGroup.MyCreativeTab_1", "en_US", "Death Mod");  
    
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}

package mymod.biome;

import mymod.Main;
import mymod.entity.abe.MyEntityAbe;
import mymod.entity.wraith.MyEntityWraith;
import mymod.entitywolf.MyEntityWolf;
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyDarkBiome extends BiomeGenBase
{
    public MyDarkBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("The Dark Biome");
        
        this.topBlock = (byte)Main.MyBlock_4.blockID;
        this.fillerBlock = (byte)Block.blockRedstone.blockID;
        
        this.theBiomeDecorator.treesPerChunk = 5;
        this.theBiomeDecorator.generateLakes = true;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 15, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 20, 6, 12));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 10, 2, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 20, 6, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 1, 0, 0));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 1, 0, 0));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 1, 0, 0));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 1, 0, 0));
        this.spawnableCreatureList.add(new SpawnListEntry(MyEntityWraith.class, 25, 1, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(MyEntityAbe.class, 15, 3, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(MyEntityWolf.class, 15, 2, 5));
        
        this.setMinMaxHeight(0.1F, 0.3F);
        this.setTemperatureRainfall(0.9F, 0.3F);
   
    }
}
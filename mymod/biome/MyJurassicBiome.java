package mymod.biome;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MyJurassicBiome extends BiomeGenBase
{
    public MyJurassicBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("MyJurassicBiome");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.blockClay.blockID;
        
        this.theBiomeDecorator.treesPerChunk = 1;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 50, 1, 5));
        
        this.setMinMaxHeight(0.2F, 0.2F);
        this.setTemperatureRainfall(0.9F, 1.5F);
   
    }
    /** Adds Huge Trees to your Biome */
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return (WorldGenerator)
        new WorldGenHugeTrees(false, 25 + random.nextInt(15), 0, 3);
        /* Wood/Leaf Metadata: 0=Oak, 1=Spruce, 2=Birch, 3=Jungle Wood */
    }
}
package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public abstract class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "defaultNetherGenerator", cancellable = true)
    private static void netherDimensionBYG(Registry<Biome> registry, Registry<DimensionSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYGWorldConfig.CONTROL_NETHER.get())
            cir.setReturnValue(new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimSettings.getOrThrow(DimensionSettings.NETHER)));
    }


    @Inject(at = @At("HEAD"), method = "defaultEndGenerator", cancellable = true)
    private static void endDimensionBYG(Registry<Biome> registry, Registry<DimensionSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYGWorldConfig.CONTROL_END.get())
            cir.setReturnValue(new NoiseChunkGenerator(new BYGEndBiomeProvider(registry, seed), seed, () -> dimSettings.getOrThrow(DimensionSettings.END)));
    }
}
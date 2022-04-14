package net.techno573.backrooms.entity.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

/**
 * Originally created by ConnorTron110, Modified by Techno573
 *
 * Copyright © 2022 ConnorTron110 <br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <br>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * <br>
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class TeleportTargetToMeGoal extends Goal {

    private final MobEntity host;
    private final int chance;
    private final byte teleportRadius;

    public TeleportTargetToMeGoal(MobEntity self, double chance, int teleportRadius) {
        this(self, (byte) chance, (byte) teleportRadius);
    }
    public TeleportTargetToMeGoal(MobEntity self, byte chance, byte teleportRadius) {
        this.host = self;
        this.chance = chance;
        //Clamps included to reduce chance of errors
        this.teleportRadius = (byte) MathHelper.clamp(teleportRadius, 0, Byte.MAX_VALUE);
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public boolean shouldContinue() {
        return false; //We only want to run once
    }

    @Override
    public void start() {

        //Check if target is in radius, if so teleport
        if (host.world.getRandom().nextInt(100) < chance && host.getTarget() != null && host.distanceTo(host.getTarget()) <= teleportRadius) {
            host.getTarget().teleport(host.getX(), host.getY(), host.getZ());
        }
    }
}


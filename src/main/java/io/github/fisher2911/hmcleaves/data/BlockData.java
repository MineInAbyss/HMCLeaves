/*
 *
 *  *     HMCLeaves
 *  *     Copyright (C) 2022  Hibiscus Creative Studios
 *  *
 *  *     This program is free software: you can redistribute it and/or modify
 *  *     it under the terms of the GNU General Public License as published by
 *  *     the Free Software Foundation, either version 3 of the License, or
 *  *     (at your option) any later version.
 *  *
 *  *     This program is distributed in the hope that it will be useful,
 *  *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *     GNU General Public License for more details.
 *  *
 *  *     You should have received a copy of the GNU General Public License
 *  *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package io.github.fisher2911.hmcleaves.data;

import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import org.bukkit.Axis;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface BlockData {


    BlockData EMPTY = new BlockData() {

        private static final String EMPTY_ID = "empty";

        @Override
        public String id() {
            return EMPTY_ID;
        }

        @Override
        public int sendBlockId() {
            return 0;
        }

        @Override
        public Material realBlockType() {
            return Material.AIR;
        }

        @Override
        public Material worldBlockType() {
            return this.realBlockType();
        }

        @Override
        @Nullable
        public WrappedBlockState getNewState() {
            return null;
        }

        @Override
        @Nullable
        public Sound placeSound() {
            return null;
        }

        @Override
        @Nullable
        public String modelPath() {
            return null;
        }

        @Override
        public boolean isWorldTypeSame(Material worldMaterial) {
            return false;
        }
    };

    String id();

    int sendBlockId();

    @Nullable
    WrappedBlockState getNewState();

    Material realBlockType();

    Material worldBlockType();

    @Nullable
    Sound placeSound();

    @Nullable
    String modelPath();

    boolean isWorldTypeSame(Material worldMaterial);

    static LeafData leafData(
            String id,
            int sendBlockData,
            Material realBlockType,
            int displayDistance,
            boolean displayPersistence,
            boolean worldPersistence,
            boolean waterlogged,
            String modelPath
    ) {
        return new LeafData(
                id,
                sendBlockData,
                realBlockType,
                displayDistance,
                displayPersistence,
                worldPersistence,
                waterlogged,
                modelPath
        );
    }

    static LogData logData(
            String id,
            String strippedLogId,
            int sendBlockId,
            Material realBlockType,
            Material strippedBlockType,
            boolean stripped,
            int strippedSendBlockId,
            Axis axis
    ) {
        return new LogData(
                id,
                strippedLogId,
                sendBlockId,
                realBlockType,
                strippedBlockType,
                stripped,
                strippedSendBlockId,
                axis
        );
    }

    static SaplingData saplingData(
            String id,
            int sendBlockId,
            Material realBlockType,
            List<String> schematicFiles,
            boolean randomPasteRotation,
            String modelPath
    ) {
        return new SaplingData(
                id,
                sendBlockId,
                realBlockType,
                schematicFiles,
                randomPasteRotation,
                modelPath
        );
    }

    static CaveVineData caveVineData(
            String id,
            String withGlowBerryId,
            int sendBlockId,
            boolean glowBerry,
            String modelPath
    ) {
        return new CaveVineData(
                id,
                withGlowBerryId,
                sendBlockId,
                glowBerry,
                modelPath
        );
    }

}

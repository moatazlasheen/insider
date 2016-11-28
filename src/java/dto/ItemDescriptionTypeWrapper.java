/*
GPL * Copyright (C) 2016 mrnull <ahmadmoawad3@gmail.com>
GPL *
GPL * This program is free software; you can redistribute it and/or
GPL * modify it under the terms of the GNU General Public License
GPL * as published by the Free Software Foundation; either version 2
GPL * of the License, or (at your option) any later version.
 */
package dto;

import entity.Gener;
import entity.ItemDescriptionType;
import entity.MaterialType;

/**
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
public class ItemDescriptionTypeWrapper {

    private ItemDescriptionType type;
    private MaterialType material;
    private Gener gener;

    public ItemDescriptionTypeWrapper() {
    }

    public ItemDescriptionTypeWrapper(ItemDescriptionType type, MaterialType material, Gener gener) {
        this.type = type;
        this.material = material;
        this.gener = gener;
    }

    
    /**
     * @return the type
     */
    public ItemDescriptionType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ItemDescriptionType type) {
        this.type = type;
    }

    /**
     * @return the material
     */
    public MaterialType getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    /**
     * @return the gener
     */
    public Gener getGener() {
        return gener;
    }

    /**
     * @param gener the gener to set
     */
    public void setGener(Gener gener) {
        this.gener = gener;
    }

}

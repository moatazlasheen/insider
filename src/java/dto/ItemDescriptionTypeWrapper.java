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

    private Integer id;
    private String description;

    public ItemDescriptionTypeWrapper() {
    }

    public ItemDescriptionTypeWrapper(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

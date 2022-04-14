package com.yuliya1303.pages;

public enum CategoriesList {
        LIGHTWEIGHT("Men's Lightweight Jackets"),
        FLEECE("Men's Fleece Jackets & Coats"),
        ACTIVE("Men's Activewear");

    public final String fullCategoryName;

    CategoriesList(String fullCategoryName) {
        this.fullCategoryName = fullCategoryName;
    }
}

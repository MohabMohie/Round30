package com.duckduckgo.ui;

import com.shaft.driver.SHAFT;

public abstract class Page {
    public SHAFT.GUI.WebDriver driver;
    public Page (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}

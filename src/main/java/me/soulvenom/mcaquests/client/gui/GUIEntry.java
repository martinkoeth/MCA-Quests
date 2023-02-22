package me.soulvenom.mcaquests.client.gui;

import me.soulvenom.mcaquests.obj.Quest;

import java.util.List;

public class GUIEntry {

    private List<CustomButton> buttons;
    private Quest quest;
    private String currentLayout;

    public GUIEntry(List<CustomButton> buttons, Quest quest, String currentLayout) {
        this.buttons = buttons;
        this.quest = quest;
        this.currentLayout = currentLayout;
    }

    public void addButton(CustomButton button) {
        this.buttons.add(button);
    }

    public void clearButtons() {
        this.buttons.clear();
    }

    public void setButtons(List<CustomButton> buttons) {
        this.buttons = buttons;
    }

    public void setCurrentLayout(String currentLayout) {
        this.currentLayout = currentLayout;
    }

    public List<CustomButton> getButtons() {
        return buttons;
    }

    public Quest getQuest() {
        return quest;
    }

    public String getCurrentLayout() {
        return currentLayout;
    }
}

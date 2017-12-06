package me.guhy.library;

import java.util.List;

/**
 * Created by guhongya on 2017/8/7.
 */

public interface TreeItem {
    boolean isExpanded();
    boolean hasChildren();
    int getLevel();
    List<TreeItem> getChildren();
}

package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.view.View;

public interface MenuEntry {
   void run(View view, Assortment assortment);
}

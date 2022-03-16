    private void unCheckAllMenuItems(NavigationView navigationView) {
        final Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
//            if (item.hasSubMenu()) {
//                SubMenu subMenu = item.getSubMenu();
//                for (int j = 0; j < subMenu.size(); j++) {
//                    MenuItem subMenuItem = subMenu.getItem(j);
//                    subMenuItem.setChecked(false);
//                }
//            } else {
            item.setChecked(false);
//            }
        }
    }


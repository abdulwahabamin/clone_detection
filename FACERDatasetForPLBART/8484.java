    /**
     * Method that remove all separator menu items.
     */
    private void removeSeparators() {
        Menu menu = getMenu();
        int cc = menu.size();
        for (int i = cc - 1; i >= 0; i--) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.getTitle() == null || menuItem.getTitle().length() == 0) {
                menu.removeItem(menuItem.getItemId());
            }
        }

    }


    /**
     * @param themeResources
     * @param themePackage
     * @param item_name
     * @param item
     * @param themeType
     */
	@SuppressWarnings("deprecation")
    public static void loadThemeResource(Resources themeResources, String themePackage,
            String item_name, View item, int themeType) {
        Drawable d = null;
        if (themeResources != null) {
            int resource_id = themeResources.getIdentifier(item_name, "drawable", themePackage);
            if (resource_id != 0) {
                try {
                    d = themeResources.getDrawable(resource_id);
                } catch (Resources.NotFoundException e) {
                    return;
                }
                if (themeType == THEME_ITEM_FOREGROUND && item instanceof ImageView) {
                    Drawable tmp = ((ImageView)item).getDrawable();
                    if (tmp != null) {
                        tmp.setCallback(null);
                        tmp = null;
                    }
                    ((ImageView)item).setImageDrawable(d);
                } else {
                    Drawable tmp = item.getBackground();
                    if (tmp != null) {
                        tmp.setCallback(null);
                        tmp = null;
                    }
                    item.setBackgroundDrawable(d);
                }
            }
        }
    }


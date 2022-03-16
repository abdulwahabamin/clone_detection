    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        menuitems.clear();

        MenuItem delMenu = menu.add(activity.getString(R.string.label_delete));
        delMenu.setIcon(R.drawable.content_discard).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuitems.add(delMenu);

        MenuItem zipMenu = menu.add(activity.getString(R.string.label_archive));
        zipMenu.setIcon(R.drawable.btn_zip).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        //zipMenu.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuitems.add(zipMenu);

        MenuItem cutMenu = menu.add(activity.getString(R.string.label_move));
        cutMenu.setIcon(R.drawable.content_cut).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuitems.add(cutMenu);

        MenuItem copyMenu = menu.add(activity.getString(R.string.label_copy));
        copyMenu.setIcon(R.drawable.content_copy).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuitems.add(copyMenu);
        return true;
    }


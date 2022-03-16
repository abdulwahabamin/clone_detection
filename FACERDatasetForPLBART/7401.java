    @Override
    public boolean onPrepareOptionsMenu( Menu menu ) {
        menu.clear();
        menu.add( Menu.NONE, MENU_SAVE, Menu.NONE, getString( R.string.save     ) ).setIcon( android.R.drawable.ic_menu_save );
        menu.add( Menu.NONE, MENU_SVAS, Menu.NONE, getString( R.string.save_as  ) ).setIcon( android.R.drawable.ic_menu_save );
        menu.add( Menu.NONE, MENU_RELD, Menu.NONE, getString( R.string.revert   ) ).setIcon( android.R.drawable.ic_menu_revert );
        menu.add( Menu.NONE, MENU_WRAP, Menu.NONE, getString( R.string.wrap     ) ).setIcon( R.drawable.wrap );
        menu.add( Menu.NONE, MENU_ENC,  Menu.NONE, Utils.getEncodingDescr( this, encoding, 
                                                      Utils.ENC_DESC_MODE_BRIEF ) ).setIcon(android.R.drawable.ic_menu_sort_alphabetically );
        menu.add( Menu.NONE, MENU_EXIT, Menu.NONE, getString( R.string.exit     ) ).setIcon( android.R.drawable.ic_notification_clear_all );
	    return true;
    }


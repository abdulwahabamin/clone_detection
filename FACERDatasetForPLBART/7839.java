    @Override
    public boolean onPrepareOptionsMenu( Menu menu ) {
        menu.clear();
        menu.add( Menu.NONE, VIEW_TOP, Menu.NONE, getString( R.string.go_top   ) ).setIcon( android.R.drawable.ic_media_previous );
        menu.add( Menu.NONE, VIEW_BOT, Menu.NONE, getString( R.string.go_end   ) ).setIcon( android.R.drawable.ic_media_next );
        menu.add( Menu.NONE, VIEW_ENC, Menu.NONE, Utils.getEncodingDescr( this, encoding, 
                                                     Utils.ENC_DESC_MODE_BRIEF ) ).setIcon( android.R.drawable.ic_menu_sort_alphabetically );
        return true;
    }


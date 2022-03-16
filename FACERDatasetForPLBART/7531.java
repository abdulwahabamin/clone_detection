    public final void applySettings( SharedPreferences sharedPref ) {
        try {
            CommanderAdapter ca = (CommanderAdapter)flv.getAdapter();
            if( ca == null )
                return;
            Display disp = p.c.getWindowManager().getDefaultDisplay();
            int w = disp.getWidth();
            int h = disp.getHeight();
            final int WIDTH_THRESHOLD = 480;
            int m = ca.setMode( CommanderAdapter.MODE_WIDTH,
                    ( p.sxs && w/2 < WIDTH_THRESHOLD ) || sharedPref.getBoolean( "two_lines", false ) ? CommanderAdapter.NARROW_MODE
                            : CommanderAdapter.WIDE_MODE );

            ca.setMode( CommanderAdapter.SET_FONT_SIZE, p.fnt_sz );

            String sfx = p.sxs ? "_SbS" : "_Ovr";
            boolean detail_mode = sharedPref.getBoolean( which == Panels.LEFT ? "left_detailed" + sfx : "right_detailed" + sfx, true );
            
            boolean show_icons = sharedPref.getBoolean( "show_icons", true );
            boolean same_line = ( m & CommanderAdapter.MODE_WIDTH ) == CommanderAdapter.WIDE_MODE;
            int icon_mode;
            if( show_icons ) {
                icon_mode = CommanderAdapter.ICON_MODE;
                if( p.fnt_sz < 18 && !p.fingerFriendly ) {
                    if( h * w <= 480 * 854 ) {   // medium
                        if( p.sxs || same_line )
                            icon_mode |= CommanderAdapter.ICON_TINY;
                    }
                }
            }
            else
                icon_mode = CommanderAdapter.TEXT_MODE;
            ca.setMode( CommanderAdapter.MODE_ICONS, icon_mode );

            ca.setMode( CommanderAdapter.MODE_CASE, sharedPref.getBoolean( "case_ignore", true ) ? CommanderAdapter.CASE_IGNORE
                    : CommanderAdapter.CASE_SENS );

            ca.setMode( CommanderAdapter.MODE_DETAILS, detail_mode ? CommanderAdapter.DETAILED_MODE : CommanderAdapter.SIMPLE_MODE );
            String sort = sharedPref.getString( which == Panels.LEFT ? "left_sorting" : "right_sorting", "n" );
            ca.setMode( CommanderAdapter.MODE_SORTING, sort.compareTo( "s" ) == 0 ? CommanderAdapter.SORT_SIZE : sort
                    .compareTo( "e" ) == 0 ? CommanderAdapter.SORT_EXT : sort.compareTo( "d" ) == 0 ? CommanderAdapter.SORT_DATE
                    : CommanderAdapter.SORT_NAME );
            ca.setMode( CommanderAdapter.MODE_FINGERF, p.fingerFriendly ? CommanderAdapter.FAT_MODE : CommanderAdapter.SLIM_MODE );

            boolean hidden_mode = sharedPref.getBoolean( ( which == Panels.LEFT ? "left" : "right" ) + "_show_hidden", true );
            ca.setMode( CommanderAdapter.MODE_HIDDEN, hidden_mode ? CommanderAdapter.SHOW_MODE : CommanderAdapter.HIDE_MODE );

            int thubnails_size = 0;
            if( show_icons && sharedPref.getBoolean( "show_thumbnails", true ) )
                thubnails_size = Integer.parseInt( sharedPref.getString( "thumbnails_size", "200" ) );
            ca.setMode( CommanderAdapter.SET_TBN_SIZE, thubnails_size );

            if( ca instanceof HomeAdapter )
                ca.setMode( CommanderAdapter.MODE_ROOT, sharedPref.getBoolean( "show_root", false ) ? CommanderAdapter.ROOT_MODE
                        : CommanderAdapter.BASIC_MODE );

        } catch( Exception e ) {
            Log.e( TAG, "applySettings() inner", e );
        }
    }


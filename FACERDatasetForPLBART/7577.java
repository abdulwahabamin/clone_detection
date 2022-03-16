    public final void applySettings( SharedPreferences sharedPref, boolean init ) {
        try {
            applyColors();
            String fnt_sz_s = sharedPref.getString( "font_size", "12" );
            try {
                fnt_sz = Integer.parseInt( fnt_sz_s );
            }
            catch( NumberFormatException e ) {}
            
            String ffs = sharedPref.getString( "finger_friendly_a", "y" );
            boolean ff = false;
            if( "a".equals( ffs ) ) {
                Display disp = c.getWindowManager().getDefaultDisplay();
                Configuration config = c.getResources().getConfiguration();
                ff = config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES || 
                     disp.getWidth() < disp.getHeight();
            }
            else
                ff = "y".equals( ffs );
            
        	setFingerFriendly( ff, fnt_sz );
        	warnOnRoot   = sharedPref.getBoolean( "prevent_root", true );
            rootOnRoot   = sharedPref.getBoolean( "root_root", false );
            arrowsLegacy = sharedPref.getBoolean( "arrow_legc", false );
            volumeLegacy = sharedPref.getBoolean( "volume_legc", true );            
            toolbarShown = sharedPref.getBoolean( "show_toolbar", true );
            
            selAtRight = sharedPref.getBoolean( Prefs.SEL_ZONE + "_right", true );
            selWidth   = sharedPref.getInt( Prefs.SEL_ZONE + "_width", 50 ) / 100f;

            if( !init ) {
                list[LEFT].applySettings( sharedPref );
                list[RIGHT].applySettings( sharedPref );
               // setPanelCurrent( current );
            }
        }
        catch( Exception e ) {
            Log.e( TAG, "applySettings()", e );
        }
    }


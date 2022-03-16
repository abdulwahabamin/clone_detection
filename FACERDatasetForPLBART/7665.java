    @Override
    public boolean onPreferenceClick( Preference preference ) {
        try {
            pref_key = preference.getKey();
            if( TOOLBUTTONS.equals( pref_key ) ) {
                Intent intent = new Intent( Intent.ACTION_MAIN );
                intent.setClass( this, ToolButtonsProps.class );
                startActivity( intent );
            }
            else
            if( SEL_ZONE.equals( pref_key ) ) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences( this );
                new SelZoneDialog( this, this, sp.getBoolean( SEL_ZONE + "_right", true ), 
                                               sp.getInt( SEL_ZONE + "_width", 50 ),
                                               ck.selColor ).show();
            }
            else
            if( ColorsKeeper.FGR_COLORS.equals( pref_key ) ) {
                Intent intent = new Intent( Intent.ACTION_MAIN );
                intent.setClass( this, FileTypes.class );
                startActivity( intent );
            }
            else {
                new RGBPickerDialog( this, this, ck.getColor( pref_key ), getDefaultColor( pref_key, true ) ).show();
            }
            return true;
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return false;
    }


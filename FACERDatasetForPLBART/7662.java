    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        try {
            Utils.changeLanguage( this );
            super.onCreate( savedInstanceState );
  
            ck = new ColorsKeeper( this );
            
            // Load the preferences from an XML resource
            addPreferencesFromResource( R.xml.prefs );
            Preference color_picker_pref;
            color_picker_pref = (Preference)findPreference( ColorsKeeper.BGR_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );
            color_picker_pref = (Preference)findPreference( ColorsKeeper.FGR_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );
            color_picker_pref = (Preference)findPreference( ColorsKeeper.SEL_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );
            color_picker_pref = (Preference)findPreference( ColorsKeeper.SFG_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );
            color_picker_pref = (Preference)findPreference( ColorsKeeper.CUR_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );
            color_picker_pref = (Preference)findPreference( ColorsKeeper.TTL_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );
            color_picker_pref = (Preference)findPreference( ColorsKeeper.BTN_COLORS );
            if( color_picker_pref != null )
                color_picker_pref.setOnPreferenceClickListener( this );

            Preference tool_buttons_pref = (Preference)findPreference( TOOLBUTTONS );
            if( tool_buttons_pref != null )
                tool_buttons_pref.setOnPreferenceClickListener( this );

            Preference sel_zone_pref = (Preference)findPreference( SEL_ZONE );
            if( sel_zone_pref != null )
                sel_zone_pref.setOnPreferenceClickListener( this );
        }
        catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }


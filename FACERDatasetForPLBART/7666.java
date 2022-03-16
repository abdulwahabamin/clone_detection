    @Override
    public void selZoneChanged( boolean atRight, int width ) {
        SharedPreferences.Editor sp_edit = PreferenceManager.getDefaultSharedPreferences( this ).edit();
        sp_edit.putBoolean( SEL_ZONE + "_right", atRight );
        sp_edit.putInt( SEL_ZONE + "_width", width );
        sp_edit.commit();
    }


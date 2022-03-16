    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        super.onActivityResult( requestCode, resultCode, data );
        switch( requestCode ) { 
        case REQUEST_CODE_PREFERENCES: {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
                back_exits = sharedPref.getBoolean( "exit_on_back", false );
                String lang_ = sharedPref.getString( "language", "" );
                if( !lang.equalsIgnoreCase( lang_ ) ) {
                    lang = lang_;
                    Utils.changeLanguage( this );
                    showMessage( getString( R.string.restart_to_apply_lang ) );
                    exit = true;
                }
                panels.applySettings( sharedPref, false );
                String panels_mode = sharedPref.getString( "panels_sxs_mode", "a" );
                sxs_auto = panels_mode.equals( "a" );
                boolean sxs = sxs_auto ? getRotMode() : panels_mode.equals( "y" );
                panels.setLayoutMode( sxs );
                panels.showToolbar( sharedPref.getBoolean("show_toolbar", true ) );
                setConfirmMode( sharedPref );
            }
            break;
        case REQUEST_CODE_SRV_FORM: {
                if( resultCode == RESULT_OK ) {
                    dont_restore = true;
                    Uri uri = data.getData();
                    if( uri != null ) {
                        Credentials crd = null; 
                        try {
                            crd = (Credentials)data.getParcelableExtra( Credentials.KEY );
                        } catch( Exception e ) {
                            Log.e( TAG, "on taking credentials from parcel", e );
                        }
                        panels.Navigate( panels.getCurrent(), uri, crd, null );
                    }
                }
            }
            break;
        case R.id.create_shortcut: 
            if( data != null ) {
                data.setAction( "com.android.launcher.action.INSTALL_SHORTCUT" );
                sendBroadcast( data );
            }
            break;
        case OPERATION_COMPLETED_REFRESH_REQUIRED:
            Log.i( TAG, "An activity ends. Refresh required." );
            panels.refreshLists();
            break;
        }
    }


    public final void Navigate( Uri uri, Credentials crd, String posTo, boolean was_current_ ) {
        try {
            // Log.v( TAG, "Navigate to " + Favorite.screenPwd( uri ) );
            was_current = was_current_;
            flv.clearChoices();
            flv.invalidateViews();
            CommanderAdapter ca_new = null, ca = (CommanderAdapter)flv.getAdapter();
            String scheme = uri.getScheme();
            int type_id = CA.GetAdapterTypeId( scheme );
            if( ca == null || type_id != ca.getType() ) {
                ca_new = CA.CreateAdapter( type_id, p.c );
                if( ca_new == null ) {
                    Log.e( TAG, "Can't create adapter of type '" + scheme + "'" );
                    if( ca != null )
                        return;
                    ca_new = CA.CreateAdapter( CA.GetAdapterTypeId( null ), p.c );
                }
                if( ca != null )
                    ca.prepareToDestroy();
                if( ca_new instanceof FavsAdapter ) {
                    FavsAdapter fav_a = (FavsAdapter)ca_new;
                    fav_a.setFavorites( p.getFavorites() );
                }
                flv.setAdapter( (ListAdapter)ca_new );
                flv.setOnKeyListener( p );
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences( p.c );
                applySettings( sharedPref );
                ca = ca_new;
            }
            //p.applyColors();
            p.setPanelTitle( p.c.getString( R.string.wait ), which );
            p.setToolbarButtons( ca );
            if( crd != null )
                ca.setCredentials( crd );
            ca.readSource( uri, "" + which + ( posTo == null ? "" : posTo ) );
        } catch( Exception e ) {
            Log.e( TAG, "NavigateInternal()", e );
        }
    }


    private final void managePackage( String p ) {
        try {
            Intent in = new Intent( Intent.ACTION_VIEW );
            in.setClassName( "com.android.settings", "com.android.settings.InstalledAppDetails" );
            in.putExtra( "com.android.settings.ApplicationPkgName", p );
            in.putExtra( "pkg", p );

            List<ResolveInfo> acts = pm.queryIntentActivities( in, 0 );
            if( acts.size( ) > 0 )
                commander.issue( in, 0 );
            else {
                in = new Intent( "android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts( "package", p, null ) );
                acts = pm.queryIntentActivities( in, 0 );
                if( acts.size( ) > 0 )
                    commander.issue( in, 0 );
                else {
                    Log.e( TAG, "Failed to resolve activity for InstalledAppDetails" );
                }
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onMenuItemSelected( int featureId, MenuItem item ) {
        super.onMenuItemSelected( featureId, item );
        try {
            File save_dir = new File( Panels.DEFAULT_LOC, ".GhostCommander" );
            PackageManager pm = getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo( getPackageName(), 0 );
            File sp_dir = new File( ai.dataDir, "shared_prefs" );
            File f = new File( save_dir, "gc_prefs.zip" );
            switch( item.getItemId() ) {
            case R.id.save_prefs:
                if( !save_dir.exists() ) save_dir.mkdirs();
                savePrefs( sp_dir, f );
                break;
            case R.id.rest_prefs:
                restPrefs( f, sp_dir );
                ck.restore();
                finish();
                break;
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return true; 
    }


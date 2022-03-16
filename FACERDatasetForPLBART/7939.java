    public MnfUtils( PackageManager pm, String app_name ) {
        try {
            ai = pm.getApplicationInfo( app_name, 0 );
            rr = pm.getResourcesForApplication( ai );
        }
        catch( NameNotFoundException e ) {
            e.printStackTrace();
        }
    }


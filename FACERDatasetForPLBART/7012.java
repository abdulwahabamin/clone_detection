    private final ResolveInfo[] getResolvers( Intent[] ins, String package_name ) {
        try {
            final int fl = PackageManager.GET_INTENT_FILTERS | PackageManager.GET_RESOLVED_FILTER;
            List<ResolveInfo> tmp_list = new ArrayList<ResolveInfo>();
            for( Intent in : ins ) {
                List<ResolveInfo> resolves = pm.queryIntentActivities( in, fl );
                for( ResolveInfo res : resolves ) {
                    if( package_name.equals( res.activityInfo.applicationInfo.packageName ) )
                        tmp_list.add( res );
                }
            }
            if( tmp_list.size() > 0 ) {
                ResolveInfo[] ret = new ResolveInfo[tmp_list.size()];
                return tmp_list.toArray( ret );
            }
        } catch( Exception e ) {
            Log.e( TAG, "For: " + package_name, e );
        }
        return null;
    }    


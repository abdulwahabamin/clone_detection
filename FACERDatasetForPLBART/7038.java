    /**
     * Tries to load an adapter class from foreign package
     * @param String type       - adapter type, also the suffix of the plugin application 
     * @param String class_name - the adapter class name to be loaded
     * @param int    dialog_id  - resource ID to show dialog if the class can't be loaded
     */
    public static CommanderAdapter CreateExternalAdapter( Context ctx, String type, String class_name ) {
        try {
            File dex_f = ctx.getDir( type, Context.MODE_PRIVATE );
            if( dex_f == null || !dex_f.exists() ) {
                Log.w( TAG, "app.data storage is not accessable, trying to use the SD card" );
                File sd = Environment.getExternalStorageDirectory();
                if( sd == null ) return null; // nowhere to store the dex :(
                dex_f = new File( sd, "temp" );
                if( !dex_f.exists() )
                    dex_f.mkdir();
            }
            ApplicationInfo ai = ctx.getPackageManager().getApplicationInfo( "com.ghostsq.commander." + type, 0 );
            
            Log.i( TAG, type + " package is " + ai.sourceDir );
            
            ClassLoader pcl = ctx.getClass().getClassLoader();
            DexClassLoader cl = new DexClassLoader( ai.sourceDir, dex_f.getAbsolutePath(), null, pcl );
            //
            Class<?> adapterClass = cl.loadClass( "com.ghostsq.commander." + type + "." + class_name );
            Log.i( TAG, "Class has been loaded " + adapterClass.toString() );
            
            try {
                File[] list = dex_f.listFiles();
                for( int i = 0; i < list.length; i++ )
                    list[i].delete();
            }
            catch( Exception e ) {
                Log.w( TAG, "Can't remove the plugin's .dex: ", e );
            }
            if( adapterClass != null ) {
                CommanderAdapter ca = (CommanderAdapter)adapterClass.newInstance();
                return ca;
            }
        }
        catch( Throwable e ) {
            Log.e( TAG, "This class can't be created: " + type, e );
        }
        return null;
    }    


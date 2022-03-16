    private static <T> ArrayList<T> bitsToItems( SparseBooleanArray cis, T[] items ) {
        try {
            if( items == null ) return null;
            ArrayList<T> al = new ArrayList<T>();
            for( int i = 0; i < cis.size(); i++ ) {
                if( cis.valueAt( i ) ) {
                    int k = cis.keyAt( i );
                    if( k > 0 )
                        al.add( items[ k - 1 ] );
                }
            }
            return al;
        } catch( Exception e ) {
            Log.e( TAG, "bitsToNames()'s Exception: " + e );
        }
        return null;
    }


    public final String getAsString() {
        int sz = size();
        String[] a = new String[sz]; 
        for( int i = 0; i < sz; i++ ) {
            String fav_str = get( i ).toString();
            if( fav_str == null ) continue;
            a[i] = escape( fav_str );
        }
        String s = Utils.join( a, sep );
        //Log.v( TAG, "Joined favs: " + s );
        return s;
    }


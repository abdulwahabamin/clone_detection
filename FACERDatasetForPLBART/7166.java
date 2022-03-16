        public int compare( Favorite f1, Favorite f2 ) {
            if( f1 == null || f2 == null ) {
                Log.w( TAG, "a Fav is null!" );
                return 0;
            }
            int ext_cmp = 0;
            switch( type ) { 
            case SORT_EXT: {
                    String c1 = f1.getComment();
                    if( c1 == null ) c1 = "";
                    String c2 = f2.getComment();
                    if( c2 == null ) c2 = "";
                    ext_cmp = c1.compareTo( c2 );
                }
                break;
            case SORT_SIZE: {
                    ext_cmp = getWeight( f1.getUri() ) - getWeight( f2.getUri() ) > 0 ? 1 : -1;
                }
                break;
            case SORT_DATE:
                break;
            }
            if( ext_cmp == 0 ) {
                Uri u1 = f1.getUri();
                Uri u2 = f2.getUri();
                if( u1 != null )
                    ext_cmp = u1.compareTo( u2 );
            }
            return ascending ? ext_cmp : -ext_cmp;
        }


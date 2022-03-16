        public void restore( Bundle b ) {
            current   = b.getInt( CP );
            leftCrd   = b.getParcelable( LC ); 
            rightCrd  = b.getParcelable( RC ); 
            leftUri   = b.getParcelable( LU );
            rightUri  = b.getParcelable( RU );
            leftItem  = b.getString( LI );
            rightItem = b.getString( RI );
            favs      = b.getString( FV );
            if( favs == null || favs.length() == 0 )
                fav_uris = b.getString( FU );
        }


        public void restore( SharedPreferences p ) {
            String left_uri_s = p.getString( LU, null );
            if( Utils.str( left_uri_s ) )
                leftUri = Uri.parse( left_uri_s );
            String right_uri_s = p.getString( RU, null );
            if( Utils.str( right_uri_s ) )
                rightUri = Uri.parse( right_uri_s );
            
            String left_crd_s = p.getString( LC, null );
            if( Utils.str( left_crd_s ) )
                leftCrd = Credentials.createFromEncriptedString( left_crd_s );
            String right_crd_s = p.getString( RC, null );
            if( Utils.str( right_crd_s ) )
                rightCrd = Credentials.createFromEncriptedString( right_crd_s );
            leftItem  = p.getString( LI, null );
            rightItem = p.getString( RI, null );
            current   = p.getInt( CP, LEFT );
            favs      = p.getString( FV, "" );
            if( favs == null || favs.length() == 0 )
                fav_uris = p.getString( FU, "" );
        }


        public void store( SharedPreferences.Editor e ) {
            e.putInt( CP, current );
            e.putString( LU, leftUri  != null ?  leftUri.toString() : "" );
            e.putString( RU, rightUri != null ? rightUri.toString() : "" );
            e.putString( LC, leftCrd  != null ?  leftCrd.exportToEncriptedString() : "" );
            e.putString( RC, rightCrd != null ? rightCrd.exportToEncriptedString() : "" );
            e.putString( LI, leftItem );
            e.putString( RI, rightItem );
            e.putString( FV, favs );
        }


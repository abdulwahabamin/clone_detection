        public void store( Bundle b ) {
            b.putInt( CP, current );
            b.putParcelable( LC, leftCrd );
            b.putParcelable( RC, rightCrd );
            b.putParcelable( LU, leftUri );
            b.putParcelable( RU, rightUri );
            b.putString( LI, leftItem );
            b.putString( RI, rightItem );
            b.putString( FV, favs );
        }


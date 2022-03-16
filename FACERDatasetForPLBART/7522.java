    @Override
    protected void onPause() {
        try {
            super.onPause();
            int n = ctr.getChildCount();
            for( int i = 1; i <= n; i++ ) {
                RelativeLayout tl = (RelativeLayout)ctr.getChildAt( i-1 );
                EditText t = (EditText)tl.findViewById( R.id.types );
                if( t != null ) {
                    ColorsKeeper.FileTypeColor ftc = ck.ftColors.get( i-1 );
                    if( ftc != null )
                        ftc.setMasks( t.getText().toString() );
                }
            }
            ck.store();
            ck.storeTypeColors();
            
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }


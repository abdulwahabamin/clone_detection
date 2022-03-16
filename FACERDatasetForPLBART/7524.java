    @Override
    public void colorChanged( int color ) {
        try {
            if( clicked != null ) {
                TextView stv = null;
                if( clicked == 0 ) {
                    ck.fgrColor = color;
                    stv = (TextView)findViewById( R.id.s0 );
                }
                else {
                    ck.ftColors.get( clicked - 1 ).setColor( color );
                    stv = (TextView)ctr.findViewWithTag( clicked );
                }
                if( stv != null )
                    stv.setTextColor( color );
                clicked = null;
            }
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }


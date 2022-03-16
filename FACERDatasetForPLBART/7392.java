    public void setProgress( String string, int progress, int progressSec, int speed ) {
        if( dialogObj == null )
            return;
        try {
            if( string != null ) {
                TextView t = (TextView)dialogObj.findViewById( R.id.text );
                if( t != null )
                    t.setText( string );
            }
            ProgressBar p_bar = (ProgressBar)dialogObj.findViewById( R.id.progress_bar );
            TextView perc_t = (TextView)dialogObj.findViewById( R.id.percent );

            if( progress >= 0 )
                p_bar.setProgress( progress );
            if( progressSec >= 0 )
                p_bar.setSecondaryProgress( progressSec );
            if( perc_t != null ) {
                perc_t.setText( "" + ( progressSec > 0 ? progressSec : progress ) + "%" );
            }
            if( speed == 0 || ( progress <= 0 && progressSec <= 0 ) ) {
                progressCounter = 0;
                progressAcSpeed = 0;
            }            
            TextView speed_t = (TextView)dialogObj.findViewById( R.id.speed );
            if( speed > 0 ) {
                progressCounter++;
                progressAcSpeed += speed;
                long avgsp = progressAcSpeed / progressCounter;  
                
                String str = Utils.getHumanSize( speed ) + "/" + owner.getString( R.string.second ) + 
                      " (" + Utils.getHumanSize( avgsp ) + "/" + owner.getString( R.string.second ) + ")";
                speed_t.setText( str );
            } 
            else 
                speed_t.setText( "" );
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }


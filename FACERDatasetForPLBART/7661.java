        protected void postExecute() {
            try {
                Log.v( TAG, "postExecute" );
                pd.cancel();
                if( bmp != null ) {
                    image_view.setImageBitmap( bmp );
                    if( touch )
                        ((TouchImageView)image_view).setMaxZoom( 4f );
                    return;
                }
            } catch( Throwable e ) {
                e.printStackTrace();
            }
            Toast.makeText( ctx, msgText != null ? msgText : ctx.getString( R.string.error ), 
                   Toast.LENGTH_LONG ).show();
        }


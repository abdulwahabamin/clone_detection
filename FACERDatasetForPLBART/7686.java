        @Override
        public void handleMessage( Message msg ) {
            try {
                if( msg.what < 0 ) {
                    setResult( RESULT_OK, new Intent( Intent.ACTION_VIEW ) );
                    finish();
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }


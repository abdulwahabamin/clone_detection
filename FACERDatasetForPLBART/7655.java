            @Override
            public void handleMessage( Message msg ) {
                try {
                    Bundle b = msg.getData();
                    int p = b.getInt( "p" );
                    if( p < 0 )
                        postExecute();
                    else
                        progressUpdate( p );
                } catch( Exception e ) {
                    e.printStackTrace();
                }
            }


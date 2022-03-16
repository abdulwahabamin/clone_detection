        @Override
        public void handleMessage( Message msg ) {
            try {
                if( msg.what <= Commander.OPERATION_FAILED ) {
                    onReadComplete();
                    reader = null;
                }
                commander.notifyMe( msg );
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }


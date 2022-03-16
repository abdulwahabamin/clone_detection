    public void setFingerFriendly( boolean fat ) {
        try {
            CommanderAdapter ca = (CommanderAdapter)flv.getAdapter();
            if( ca != null ) {
                int mode = fat ? CommanderAdapter.FAT_MODE : CommanderAdapter.SLIM_MODE;
                ca.setMode( CommanderAdapter.MODE_FINGERF, mode );
                flv.invalidate();
            }
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }


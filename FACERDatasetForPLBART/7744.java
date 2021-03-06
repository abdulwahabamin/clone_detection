    @Override
    public void run() {
        String cmd = null, mode = null;
        try {
            String o = mount.getOptions();
            if( o == null ) {
                error( "No Options found" );
                return;
            }
            String[] flds = o.split( "," );
            for( int i = 0; i < flds.length; i++ ) {
                if( flds[i].equals( "rw" ) ) {
                    mode = "ro";
                    break;
                }
                if( flds[i].equals( "ro" ) ) {
                    mode = "rw";
                    break;
                }
            }
            if( mode == null ) {
                error( "No ro/rw options found" );
                return;
            }
            cmd = "mount -o remount," + mode + " " + mount.getName();
            execute( cmd, false, 500 );
            
        }
        catch( Exception e ) {
            Log.e( TAG, "On remount, ", e );
            error( "Exception: " + e );
        }
        finally {
            super.run();
            sendResult( errMsg != null ? ( cmd == null ? "" : context.getString( R.string.tried_to_exec, cmd ) ) : 
                context.getString( R.string.remounted, mount.getMountPoint(), mode ) );
        }
    }


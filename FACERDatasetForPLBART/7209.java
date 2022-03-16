	@Override
    public boolean renameItem( int position, String newName, boolean copy ) {
        if( position <= 0 || position > items.length )
            return false;
        try {
            if( copy ) {
                // newName could be just name
                notify( Commander.OPERATION_STARTED );
                File[] list = { items[position - 1].f };
                String dest_name;
                if( newName.indexOf( SLC ) < 0 ) {
                    dest_name = dirName;
                    if( dest_name.charAt( dest_name.length()-1 ) != SLC )
                        dest_name += SLS;
                    dest_name += newName;
                }
                else
                    dest_name = newName; 
                worker = new CopyEngine( workerHandler, list, dest_name, false, true );
                worker.setName( TAG + ".CopyEngine" );
                worker.start();
                return true;
            }
            boolean ok = false;
            File f = items[position - 1].f;
            File new_file = new File( dirName, newName );
            if( new_file.exists() ) {
                if( f.equals( new_file ) ) return false;
                String old_ap = f.getAbsolutePath();
                String new_ap = f.getAbsolutePath();
                if( old_ap.equalsIgnoreCase( new_ap ) ) {
                    File tmp_file = new File( dirName, newName + "_TMP_" );
                    ok = f.renameTo( tmp_file );
                    ok = tmp_file.renameTo( new_file );
                } else {
                    final String msg$ = ctx.getString( R.string.file_exist, newName );
                    final File from$ = f, to$ = new_file;  
                    worker = new Engine( workerHandler, new Runnable() {
                        public void run() {
                            try {
                                int resolution = worker.askOnFileExist( msg$, commander );
                                if( ( resolution & Commander.REPLACE ) != 0 ) {
                                    if( to$.delete() && from$.renameTo( to$ ) )
                                        worker.sendResult( "ok" );
                                }
                                    
                            } catch( InterruptedException e ) {
                                e.printStackTrace();
                            }
                        }
                    });
                    worker.start();
                    return true;
                }
            }
            else
                ok = f.renameTo( new_file );
            notify( ok ? null : s( R.string.error ), 
                    ok ? Commander.OPERATION_COMPLETED_REFRESH_REQUIRED : 
                         Commander.OPERATION_FAILED );
            return ok;
        }
        catch( SecurityException e ) {
            commander.showError( ctx.getString( R.string.sec_err, e.getMessage() ) );
            return false;
        }
    }


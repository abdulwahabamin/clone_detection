    @Override
    public void doIt( int command_id, SparseBooleanArray cis ) {
        try {
            if( CHMOD_CMD == command_id || CMD_CMD == command_id ) {
                if( isWorkerStillAlive() )
                    return;
                LsItem[] items_todo = bitsToItems( cis );
                boolean selected_one = items_todo != null && items_todo.length > 0 && items_todo[0] != null;
                if( CHMOD_CMD == command_id ) {
                    if( selected_one ) {
                        Intent i = new Intent( ctx, EditPermissions.class );
                        i.putExtra( "perm", items_todo[0].getAttr() );
                        i.putExtra( "path", Utils.mbAddSl( uri.getPath() ) + items_todo[0].getName() );
                        commander.issue( i, Commander.OPERATION_COMPLETED_REFRESH_REQUIRED );
                    }
                    else
                        commander.showError( commander.getContext().getString( R.string.select_some ) );
                }
                else if( CMD_CMD == command_id )
                    new CmdDialog( commander.getContext(), selected_one ? items_todo[0] : null, this );
            } else if( R.id.remount == command_id ) {
                if( reader != null && reader.isAlive() ) {
                    commander.showError( commander.getContext().getString( R.string.busy ) );
                    return;
                }
                systemMountReader = new MountsListEngine( commander.getContext(), readerHandler, true );
                systemMountReader.start();
            }
        } catch( Exception e ) {
            Log.e( TAG, "Can't do the command " + command_id, e );
        }
    }


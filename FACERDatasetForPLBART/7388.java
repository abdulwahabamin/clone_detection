    protected final Dialog createDialog( int id ) {
        try {
            Utils.changeLanguage( owner );
            switch( id ) {
            case INPUT_DIALOG:
            case R.id.new_zip:
            case R.id.F2:
            case R.id.new_file:
            case R.id.SF4:
            case R.id.F5:
            case R.id.F6:
            case R.id.F7:
            {
                LayoutInflater factory = LayoutInflater.from( owner );
                final View textEntryView = factory.inflate( R.layout.input, null );
                dialogObj = new AlertDialog.Builder( owner )
                    .setView( textEntryView )
                    .setTitle( " " )
                    .setPositiveButton( R.string.dialog_ok, this )
                    .setNegativeButton( R.string.dialog_cancel, this )
                    .create();
                return dialogObj; 
            }
            case FileCommander.FIND_ACT:
            case SELECT_DIALOG:
            case UNSELECT_DIALOG: {
                LayoutInflater factory = LayoutInflater.from( owner );
                final View searchView = factory.inflate( R.layout.search, null );
                if( id == FileCommander.FIND_ACT ) {
                    View search_params = searchView.findViewById( R.id.search_params );
                    if( search_params != null )
                        search_params.setVisibility( View.VISIBLE );
                }
                dialogObj = new AlertDialog.Builder( owner )
                    .setView( searchView )
                    .setTitle( " " )
                    .setPositiveButton( R.string.dialog_ok, this )
                    .setNegativeButton( R.string.dialog_cancel, this )
                    .create();
                return dialogObj; 
            }
            case LOGIN_DIALOG: {
                    LayoutInflater factory = LayoutInflater.from( owner );
                    final View textEntryView = factory.inflate( R.layout.login, null );
                    return dialogObj = new AlertDialog.Builder( owner )
                            .setView( textEntryView )
                            .setTitle( "Login" )
                            .setPositiveButton( R.string.dialog_ok, this )
                            .setNegativeButton( R.string.dialog_cancel, this )
                            .create();
                }
            case FILE_EXIST_DIALOG: {
                    return dialogObj = new AlertDialog.Builder( owner )
                            .setIcon( android.R.drawable.ic_dialog_alert )
                            .setTitle( R.string.error )
                            .setMessage( R.string.error )
                            .setPositiveButton( R.string.dialog_replace_all, this )
                            .setNeutralButton( R.string.dialog_skip_all, this )
                            .setNegativeButton( R.string.dialog_cancel, this )
                            .create();
                }
            case CONFIRM_DIALOG:
            case R.id.F8:
            case R.id.donate:
            case SMB_PLG_DIALOG:
            case FileCommander.DBOX_APP: {
                    return dialogObj = new AlertDialog.Builder( owner )
                        .setIcon( android.R.drawable.ic_dialog_alert )
                        .setTitle( R.string.confirm )
                        .setMessage( "" )
                        .setPositiveButton( R.string.dialog_ok, this )
                        .setNegativeButton( R.string.dialog_cancel, this )
                        .create();
                }
            case PROGRESS_DIALOG: {
                    LayoutInflater factory = LayoutInflater.from( owner );
                    final View progressView = factory.inflate( R.layout.progress, null );
                    return dialogObj = new AlertDialog.Builder( owner )
                        .setView( progressView )
                        .setTitle( R.string.progress )
                        .setNegativeButton( R.string.dialog_cancel, this )
                        .setCancelable( false )
                        .create();
                }
            case ALERT_DIALOG: {
                    return dialogObj = new AlertDialog.Builder( owner )
                        .setIcon( android.R.drawable.ic_dialog_alert )
                        .setTitle( R.string.alert )
                        .setMessage( "" )
                        .setPositiveButton( R.string.dialog_ok, this )
                        .create();
                }
            case R.id.about:
            case INFO_DIALOG: {
                    AlertDialog.Builder adb = new AlertDialog.Builder( owner )
                        .setIcon( android.R.drawable.ic_dialog_info )
                        .setTitle( R.string.info )
                        .setPositiveButton( R.string.dialog_ok, this );
                    LayoutInflater factory = LayoutInflater.from( owner );
                    View tvs = factory.inflate( R.layout.textvw, null );
                    if( tvs != null ) {
                        //TextView tv = (TextView)tvs.findViewById( R.id.text_view );                     
                        //tv.setPadding( 10, 10, 10, 10 );
                        adb.setView( tvs );
                    } else
                        adb.setMessage( "" );
                    return dialogObj = adb.create();
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, "id=" + id, e );
        } finally {
            if( dialogObj == null )
                Log.e( TAG, "Failed. id=" + id );
        }
        return null;
    }


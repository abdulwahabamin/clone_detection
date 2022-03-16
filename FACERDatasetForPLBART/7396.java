    @Override
    public void onClick( DialogInterface idialog, int whichButton ) {
        if( dialogObj == null )
            return;
        try {
            if( valid && whichButton == DialogInterface.BUTTON_POSITIVE ) {
                switch( dialogId ) {
                case R.id.F2:
                case R.id.new_file:
                case R.id.SF4:
                case R.id.F5:
                case R.id.F6:
                case R.id.F7:
                case FileCommander.FIND_ACT:
                case R.id.new_zip:
                case UNSELECT_DIALOG:
                case SELECT_DIALOG:
                    EditText edit = (EditText)dialogObj.findViewById( R.id.edit_field );
                    if( edit != null ) {
                        String file_name = edit.getText().toString();
                        if( file_name == null ) return;
                        switch( dialogId ) {
                        case R.id.F2:
                            owner.panels.renameItem( file_name );
                            break;
                        case R.id.SF4:
                        case R.id.new_file:
                            owner.panels.createNewFile( file_name );
                            break;
                        case R.id.F6:
                        case R.id.F5:
                            owner.panels.copyFiles( file_name, dialogId == R.id.F6 );
                            break;
                        case R.id.F7:
                            owner.panels.createFolder( file_name );
                            break;
                        case R.id.new_zip:
                            owner.panels.createZip( file_name.trim() );
                            break;
                        case FileCommander.FIND_ACT: 
                            if( file_name.length() > 0 ) {
                                StringBuilder sb = new StringBuilder( 128 );
                                sb.append( "q=" ).append( Utils.escapeRest( file_name ) );
                                try {
                                    boolean dirs  = ((CheckBox)dialogObj.findViewById( R.id.for_dirs  )).isChecked();
                                    boolean files = ((CheckBox)dialogObj.findViewById( R.id.for_files )).isChecked();
                                    if( dirs != files ) {
                                        sb.append( dirs ? "&d=1" : "&f=1" );
                                    } else 
                                        if( !dirs ) break;
                                    boolean one_level_only = !((CheckBox)dialogObj.findViewById( R.id.in_subf )).isChecked();
                                    if( one_level_only )
                                        sb.append( "&o=1" );
                                    String cs = ((EditText)dialogObj.findViewById( R.id.edit_content )).getText().toString();
                                    if( cs.length() > 0 )
                                        sb.append( "&c=" ).append( Utils.escapeRest( cs ) );

                                    String bts = ((EditText)dialogObj.findViewById( R.id.edit_bigger  )).getText().toString();
                                    if( bts.length() > 0 )
                                        sb.append( "&l=" ).append( bts );
                                    String sts = ((EditText)dialogObj.findViewById( R.id.edit_smaller )).getText().toString();
                                    if( sts.length() > 0 )
                                        sb.append( "&s=" ).append( sts );
                                    
                                    if( ((CheckBox)dialogObj.findViewById( R.id.mod_after )).isChecked() ) {
                                        CharSequence macs = ((Button)dialogObj.findViewById( R.id.mod_after_date )).getText();
                                        if( macs.length() > 0 )
                                            sb.append( "&a=" ).append( macs );
                                    }
                                    if( ((CheckBox)dialogObj.findViewById( R.id.mod_before )).isChecked() ) {
                                        CharSequence mbcs = ((Button)dialogObj.findViewById( R.id.mod_before_date )).getText();
                                        if( mbcs.length() > 0 )
                                            sb.append( "&b=" ).append( mbcs );
                                    }
                                } catch( Exception e ) {
                                    Log.e( TAG, file_name, e );
                                }
                                
                                Uri.Builder uri_b = new Uri.Builder()
                                    .scheme( "find" )
                                    .path( cookie )
                                    .encodedQuery( sb.toString() );
                                owner.Navigate( uri_b.build(), null, null );
                            }
                            break;
                        case UNSELECT_DIALOG:
                        case SELECT_DIALOG: {
                                CheckBox for_dirs  = (CheckBox)dialogObj.findViewById( R.id.for_dirs );
                                CheckBox for_files = (CheckBox)dialogObj.findViewById( R.id.for_files );
                                owner.panels.checkItems( dialogId == SELECT_DIALOG, file_name, for_dirs.isChecked(), for_files.isChecked() );
                                break;
                            }
                        }
                    }
                    break;
                case R.id.F8:
                    owner.panels.deleteItems();
                    break;
                case LOGIN_DIALOG: {
                        EditText name_edit = (EditText)dialogObj.findViewById( R.id.username_edit );
                        EditText pass_edit = (EditText)dialogObj.findViewById( R.id.password_edit );
                        if( name_edit != null && pass_edit != null )
                            owner.panels.login( new Credentials( name_edit.getText().toString(), pass_edit.getText().toString() ) );
                    }
                    break;
                case R.id.donate:
                        owner.startViewURIActivity( R.string.donate_uri );
                        break;
                case SMB_PLG_DIALOG:
                        owner.startViewURIActivity( R.string.smb_app_uri );
                        break;
                case FILE_EXIST_DIALOG:
                    owner.setResolution( Commander.REPLACE_ALL );
                    break;
/*
                case FileCommander.DBOX_APP: {
                        owner.startViewURIActivity( R.string.dbox_app_uri );
                        break;
                    }
*/
                }
            } else if( whichButton == DialogInterface.BUTTON_NEGATIVE ) {
                if( dialogId == PROGRESS_DIALOG )
                    owner.panels.terminateOperation();
                else
                if( dialogId == FILE_EXIST_DIALOG )
                    owner.setResolution( Commander.ABORT );
            } else if( whichButton == DialogInterface.BUTTON_NEUTRAL ) {
                if( dialogId == FILE_EXIST_DIALOG )
                    owner.setResolution( Commander.SKIP_ALL );
            }
            owner.panels.focus();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }


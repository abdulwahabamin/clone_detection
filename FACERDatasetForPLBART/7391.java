    protected void prepareDialog( int id, Dialog dialog ) {
        if( dialog != dialogObj ) {
            Log.e( TAG, "Dialogs corrupted!" );
            return;
        }
        Utils.changeLanguage( owner );
        boolean move = false;
        try {
            TextView prompt = (TextView)dialog.findViewById( R.id.prompt );
            EditText edit   = (EditText)dialog.findViewById( R.id.edit_field );
            switch( id ) {
            case PROGRESS_DIALOG: {
                TextView t = (TextView)dialogObj.findViewById( R.id.text );
                if( t != null )
                    t.setText( "" );
                break;
            }            
            case R.id.F2: 
            {
                final String op_title = owner.getString( R.string.rename_title );
                String op = owner.getString( R.string.to_rename );
                if( op == null || op.length() == 0 )
                    op = op_title;
                dialog.setTitle( op_title );
                String item_name = owner.panels.getSelectedItemName();
                if( item_name == null ) {
                    owner.showMessage( owner.getString( R.string.rename_err ) );
                    item_name = "";
                }
                if( prompt != null )
                    prompt.setText( owner.getString( R.string.oper_item_to, op, item_name ) );
                if( edit != null ) {
                    edit.setWidth( owner.getWidth() - 80 );
                    edit.setText( item_name );
                }
                break;
            }
            case R.id.SF4:
            case R.id.new_file: {
                dialog.setTitle( R.string.newf_title );
                if( prompt != null )
                    prompt.setText( R.string.newf_prompt );
                if( edit != null ) {
                    edit.setWidth( owner.getWidth() - 80 );
                    edit.setText( "" );
                }
                break;
            }
            case R.id.F6:
                move = true;
            case R.id.F5: 
            {
                final String op_title = owner.getString( move ? R.string.move_title : R.string.copy_title );
                String op = owner.getString( move ? R.string.to_move : R.string.to_copy );
                if( op == null || op.length() == 0 )
                    op = op_title;
                dialog.setTitle( op_title );
                if( prompt != null ) {
                    String summ = owner.panels.getActiveItemsSummary();
                    if( summ == null ) {
                        dialog.cancel();
                        owner.showMessage( owner.getString( R.string.op_not_alwd, op ) );
                        valid = false;
                        return;
                    }
                    else
                        valid = true;
                    prompt.setText( owner.getString( R.string.oper_item_to, op, summ ) );
                }
                if( edit != null ) {
                    edit.setWidth( owner.getWidth() - 70 );
                    String cts = Favorite.screenPwd( owner.panels.getFolderUriWithAuth( false ) );
                    edit.setText( cts != null ? cts : "" );
                    if( owner.panels.getNumItemsSelectedOrChecked() == 1 )
                        edit.selectAll();
                }
                break;
            }
            case R.id.new_zip: {
                final String op = owner.getString( R.string.create_zip_title );
                dialog.setTitle( op );
                if( prompt != null ) {
                    String summ = owner.panels.getActiveItemsSummary();
                    if( summ == null ) {
                        dialog.dismiss();
                        summ = owner.getString( R.string.no_items );
                        owner.showMessage( owner.getString( R.string.op_not_alwd, op ) );
                    }
                    prompt.setText( owner.getString( R.string.oper_item_to, op, summ ) );
                }
                if( edit != null ) {
                    edit.setWidth( owner.getWidth() - 70 );
                    edit.setText( " .zip" );
                    edit.setSelection( 1 );
                }
                break;
            }
            case R.id.F7: 
            {
                dialog.setTitle( R.string.mkdir_title );
                if( prompt != null )
                    prompt.setText( R.string.mkdir_prompt );
                if( edit != null )
                    edit.setWidth( owner.getWidth() - 90 );
                break;
            }
            case FileCommander.FIND_ACT: {
                dialog.setTitle( R.string.search_title );
                if( prompt != null )
                    prompt.setText( R.string.search_prompt );
                
                if( edit != null ) {
                    Editable edit_text = edit.getText();
                    if( edit_text.length() == 0 )
                        edit.setText( "*" );
                }
                Button mod_after_date = (Button)dialog.findViewById( R.id.mod_after_date );
                if( mod_after_date != null )
                    new DatePickerButton( owner, mod_after_date );

                Button mod_before_date = (Button)dialog.findViewById( R.id.mod_before_date );
                if( mod_before_date != null )
                    new DatePickerButton( owner, mod_before_date );
                break;
            }
            case UNSELECT_DIALOG:
            case SELECT_DIALOG: {
                dialog.setTitle( id == SELECT_DIALOG ? R.string.dialog_select : R.string.dialog_unselect );
                if( edit != null ) {
                    Editable edit_text = edit.getText();
                    if( edit_text.length() == 0 )
                        edit.setText( "*" );
                }
                break;
            }
            case LOGIN_DIALOG: {
                if( crd != null ) {
                    EditText n_v = (EditText)dialog.findViewById( R.id.username_edit );
                    EditText p_v = (EditText)dialog.findViewById( R.id.password_edit );
                    if( n_v != null )
                        n_v.setText( crd.getUserName() != null ? crd.getUserName() : "" );
                    if( p_v != null )
                        p_v.setText( crd.getPassword() != null ? crd.getPassword() : "" );
                    crd = null;
                }
                AlertDialog ad = (AlertDialog)dialog;
                String title = Utils.str( toShowInAlertDialog ) ? toShowInAlertDialog : owner.getString( R.string.login_title ); 
                ad.setTitle( title );
                toShowInAlertDialog = null;
                break;
            }
            case R.id.F8: 
            {
                AlertDialog ad = (AlertDialog)dialog;
                ad.setTitle( R.string.delete_title );
                String str, summ = owner.panels.getActiveItemsSummary();
                if( summ == null ) {
                    str = owner.getString( R.string.no_items );
                    dialog.cancel();
                } else
                    str = owner.getString( R.string.delete_q, summ );
                ad.setMessage( str );
                break;
            }
            case R.id.donate:
                ( (AlertDialog)dialog ).setMessage( owner.getString( R.string.donation ) );
                break;
            case SMB_PLG_DIALOG:
                ( (AlertDialog)dialog ).setMessage( owner.getString( R.string.smb_missed ) );
                break;
            case FileCommander.DBOX_APP:
                ( (AlertDialog)dialog ).setMessage( owner.getString( R.string.dbox_missed ) );
                break;
                
            case R.id.about:
                PackageInfo pi = null;
                try {
                    pi = owner.getPackageManager().getPackageInfo( owner.getPackageName(), 0 );
                } catch( NameNotFoundException e ) {
                    Log.e( TAG, "Package name not found", e );
                }
                setMessageToBeShown( owner.getString(R.string.about_text, pi != null ? pi.versionName : "?" ), null );
            case INFO_DIALOG:
                if( toShowInAlertDialog != null ) {
                    TextView tv = (TextView )dialog.findViewById( R.id.text_view );
                    if( tv != null ) {
                        if( id == R.id.about ) tv.setAutoLinkMask( Linkify.EMAIL_ADDRESSES );
                        
                        SharedPreferences shared_pref = PreferenceManager.getDefaultSharedPreferences( owner );
                        int fnt_sz = Integer.parseInt( shared_pref != null ? shared_pref.getString( "font_size", "12" ) : "12" );
                        boolean reduce_size = toShowInAlertDialog.length() > 128;
                        if( !reduce_size ) {
                            String[] ss = toShowInAlertDialog.split( "\n" );
                            for( String s : ss ) {
                                if( s.length() > 31 ) {
                                    reduce_size = true;
                                    break;
                                }
                            }
                        }
                        int fs = ( reduce_size ? 15 : 18 ) + ( fnt_sz - 12 );
                        tv.setTextSize( fs > 12 ? fs : 12 );
                        tv.setText( toShowInAlertDialog );
                    } else 
                        ( (AlertDialog)dialog ).setMessage( toShowInAlertDialog ); 
                    toShowInAlertDialog = null;
                }
                break;
            case FILE_EXIST_DIALOG:
            case ALERT_DIALOG:
                if( toShowInAlertDialog != null ) {
                    AlertDialog ad = (AlertDialog)dialog;
                    ad.setMessage( toShowInAlertDialog );
                    toShowInAlertDialog = null;
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }


    public void dispatchCommand( int id ) {
        try {
            Utils.changeLanguage( this );
            switch( id ) {
            case R.id.keys:
            case R.id.F1:
                showInfo( getString( R.string.keys_text ) );
                break;
            case R.id.F3:
                panels.openForView();
                break;
            case R.id.F4:
                panels.openForEdit(null);
                break;
            case R.id.F2:
            case R.id.new_zip:
            case R.id.F5:
            case R.id.F6:
            case R.id.F8:
                if( panels.getNumItemsSelectedOrChecked() > 0 )
                    showDialog( id );
                else
                    showMessage( getString( R.string.no_items ) );
                break;
            case R.id.new_file:
            case R.id.SF4:
            case R.id.F7:
            case R.id.about:
            case R.id.donate:
                showDialog( id );
                break;
            case R.id.prefs:
            case R.id.F9:
                openPrefs();
                break;
            case R.id.exit:
            case R.id.F10:
                exit = true;
                finish();
                break;
            case R.id.oth_sh_this:
            case R.id.eq:
                panels.makeOtherAsCurrent();
                break;
            case R.id.toggle_panels_mode:
                panels.togglePanelsMode();
                break;
            case R.id.tgl:
                panels.togglePanels(true);
                break;
            case R.id.sz:
                panels.showSizes();
                break;
            case R.id.home:
                Navigate( Uri.parse( "home:" ), null, null );
                break;
            case R.id.favs:
                Navigate( Uri.parse( "favs:" ), null, null );
                break;
            case  R.id.sdcard:
                Navigate( Uri.parse( Panels.DEFAULT_LOC ), null, null );
                break;
            case  R.id.root: {
                    Uri cu = panels.getFolderUriWithAuth( true );
                    Navigate( Uri.parse( RootAdapter.DEFAULT_LOC + 
                      ( cu == null || cu.getScheme() != null && cu.getScheme().length() > 0 ? "" : cu.getPath() ) ), null, null );
                }
                break;
            case  R.id.mount:
                Navigate( Uri.parse( MountAdapter.DEFAULT_LOC ), null, null );
                break;
                
            case FTP_ACT: {
                    Intent i = new Intent( this, ServerForm.class );
                    i.putExtra( "schema", "ftp" );
                    startActivityForResult( i, REQUEST_CODE_SRV_FORM );
                }
                break;
            case SMB_ACT: {
                    Intent i = new Intent( this, ServerForm.class );
                    i.putExtra( "schema", "smb" );
                    startActivityForResult( i, REQUEST_CODE_SRV_FORM );
                }
                break;
            case R.id.search: 
                showSearchDialog();
                break;
            case R.id.enter:
                panels.openGoPanel();
                break;
            case R.id.add_fav:
                panels.addCurrentToFavorites();
                break;
            case R.id.by_name:
                panels.changeSorting( CommanderAdapter.SORT_NAME );
                break;
            case R.id.by_ext:
                panels.changeSorting( CommanderAdapter.SORT_EXT );
                break;
            case R.id.by_size:
                panels.changeSorting( CommanderAdapter.SORT_SIZE );
                break;
            case R.id.by_date:
                panels.changeSorting( CommanderAdapter.SORT_DATE );
                break;
            case R.id.refresh:
                panels.refreshLists();
                break;
            case R.id.sel_all:
                showDialog( Dialogs.SELECT_DIALOG );
                break;
            case R.id.uns_all:
                showDialog( Dialogs.UNSELECT_DIALOG );
                break;
            case R.id.online: {
                    Intent intent = new Intent( Intent.ACTION_VIEW );
                    intent.setData( Uri.parse( getString( R.string.help_uri ) ) );
                    startActivity( intent );
                }
                break;
            case SEND_TO:
                panels.tryToSend();
                break;
            case OPEN_WITH:
                panels.tryToOpen();
                break;
            case COPY_NAME:
                panels.copyName();
                break;
            case FAV_FLD:
                panels.faveSelectedFolder();
                break;
            case R.id.softkbd:
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, 0);
                break;
            case  R.id.hidden:
                panels.toggleHidden();
                break;
            case  R.id.rescan:
                sendBroadcast( new Intent( Intent.ACTION_MEDIA_MOUNTED, Uri.parse( "file://" + Panels.DEFAULT_LOC ) ) );
                break;
            default:
                CommanderAdapter ca = panels.getListAdapter( true );
                if( ca != null )
                    ca.doIt( id, panels.getSelectedOrChecked() );
            }
        }
        catch( Throwable e ) {
            e.printStackTrace();
        }
    }


    @Override
    public void populateContextMenu( ContextMenu menu, AdapterView.AdapterContextMenuInfo acmi, int num ) {
        try {
            Item item = (Item)getItem( acmi.position );
            boolean file = !item.dir && acmi.position != 0;
            if( acmi.position == 0 ) {
                menu.add( 0, R.id.enter, 0, R.string.enter );
                menu.add( 0, R.id.eq, 0, R.string.oth_sh_this );
                menu.add( 0, R.id.add_fav, 0, R.string.add_fav );
                return;
            }
            int t = getType();
            if( CA.suitable( R.id.sz, t ) )
                menu.add( 0, R.id.sz, 0, R.string.show_size );
            if( num <= 1 ) {
                if( CA.suitable( R.id.F2, t ) )
                    menu.add( 0, R.id.F2, 0, R.string.rename_title );
                if( file ) {
                    if( CA.suitable( R.id.F3, t ) )
                        menu.add( 0, R.id.F3, 0, R.string.view_title );
                    if( CA.suitable( R.id.F4, t ) )
                        menu.add( 0, R.id.F4, 0, R.string.edit_title );
                    if( ( t & CA.LOCAL ) != 0 )
                        menu.add( 0, Commander.SEND_TO, 0, R.string.send_to );
                }
            }
            if( CA.suitable( R.id.F5, t ) )
                menu.add( 0, R.id.F5, 0, R.string.copy_title );
            if( CA.suitable( R.id.F6, t ) )
                menu.add( 0, R.id.F6, 0, R.string.move_title );
            if( CA.suitable( R.id.F8, t ) )
                menu.add( 0, R.id.F8, 0, R.string.delete_title );
            if( ( t & CA.LOCAL ) != 0 ) {
                if( file && num <= 1 )
                    menu.add( 0, Commander.OPEN_WITH, 0, R.string.open_with );
                menu.add( 0, R.id.new_zip, 0, R.string.new_zip );
            }
            if( num <= 1 )
                menu.add( 0, Commander.COPY_NAME, 0, R.string.copy_name );
            if( item.dir && acmi.position != 0 )
                menu.add( 0, Commander.FAV_FLD, 0, ctx.getString( R.string.fav_fld, item.name ) );
        } catch( Exception e ) {
            Log.e( TAG, "populateContextMenu() " + e.getMessage(), e );
        }
    }


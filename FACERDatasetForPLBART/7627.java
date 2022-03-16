    /**
     * An AdapterView.OnItemClickListener implementation 
     */
    @Override
    public void onItemClick( AdapterView<?> parent, View view, int position, long id ) {
        //Log.v( TAG, "onItemClick" );
        
    	locationBar.closeGoPanel();
    	resetQuickSearch();
    	ListView flv = list[current].flv;
        if( flv != parent ) {
            togglePanels( false );
          	Log.e( TAG, "onItemClick. current=" + current + ", parent=" + parent.getId() );
        }
        if( position == 0 )
            flv.setItemChecked( 0, false ); // parent item never selected
        list[current].setCurPos( position );
        if( disableAllActions ) {
            disableAllActions = false;
            disableOpenSelectOnly = false;
            SparseBooleanArray cis = flv.getCheckedItemPositions();
            flv.setItemChecked( position, !cis.get( position ) );
            return;
        }
        if( disableOpenSelectOnly && ( ((CommanderAdapter)flv.getAdapter()).getType() & CA.CHKBL ) != 0 )
            disableOpenSelectOnly = false;
        else { 
            openItem( position );
            flv.setItemChecked( position, false );
        }
    }


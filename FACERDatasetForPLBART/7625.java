    /**
     * An AdapterView.OnItemSelectedListener implementation
     */
    @Override
    public void onItemSelected( AdapterView<?> listView, View itemView, int pos, long id ) {
        //Log.v( TAG, "Selected item " + pos );
    	locationBar.closeGoPanel();
    	int which = list[current].id == listView.getId() ? current : opposite();
        list[which].setCurPos( pos );
    }


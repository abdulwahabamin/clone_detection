    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfoIn) {
        if (menuInfoIn == null) return;

        AdapterView.AdapterContextMenuInfo mi = (AdapterView.AdapterContextMenuInfo) menuInfoIn;
        adapter.getCursor().moveToPosition(mi.position);
        mCurrentId = adapter.getCursor().getLong(adapter.getCursor().getColumnIndexOrThrow(BaseColumns._ID));
        mCurrentName = fetchCategoryName(adapter.getCursor());
        mIsUnknown = mCurrentName == null || mCurrentName.equals(MediaStore.UNKNOWN_STRING);
        String title = mIsUnknown ? getString(getUnknownStringId()) : mCurrentName;
        menu.setHeaderTitle(title);

        pupulareContextMenu(menu);
    }


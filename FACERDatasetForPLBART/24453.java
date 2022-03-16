    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfoIn) {
        if (menuInfoIn == null) return;
        AdapterView.AdapterContextMenuInfo mi = (AdapterView.AdapterContextMenuInfo) menuInfoIn;
        selectedPosition = mi.position;
        adapter.getCursor().moveToPosition(selectedPosition);
        String mimeType = adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.MIME_TYPE));
        if (isSong(mimeType)) {
            super.onCreateContextMenu(menu, view, menuInfoIn);
        }
    }


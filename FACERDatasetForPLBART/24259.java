    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        adapter.getCursor().moveToPosition(position);
        String path = adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(MusicContract.Folder.PATH));
        viewCategory(MusicContract.Folder.getMembersUri(path));
    }


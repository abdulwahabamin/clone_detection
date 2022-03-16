    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            fileEx = FileEx.newFileManager(savedInstanceState.getString("dir"), this);

        }
        super.onRestoreInstanceState(savedInstanceState);
    }


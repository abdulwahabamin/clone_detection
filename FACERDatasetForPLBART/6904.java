    private void doSearch(String query) {
        ifSearching = true;
        searchDialog = new AlertDialog.Builder(FileListActivity.this).create();
        searchDialog.show();
        searchDialog.getWindow().setContentView(R.layout.query_dialog);
        querytv = (TextView) searchDialog.getWindow().findViewById(R.id.query_tv);
        new QueryAsyncTask(querytv,getPathString(),query,fileAdapter,searchDialog).execute();
    }


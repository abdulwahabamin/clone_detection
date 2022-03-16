    public void refreshData() {

        showHideMessage();
        if(fm.getCurrentDirectory().getAbsolutePath().equals(File.separator)) {
            Fab.hide();
        } else {
            Fab.show();
        }


        int dcount=fm.loadDirectory();
        if(dcount>200) {
            loading.setVisibility(View.VISIBLE);
            loading.bringToFront();
            //BLog.e("call async load folder");
            bigFolderTask =new DisplayFolderAsync();
            bigFolderTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);

        } else {
            loading.setVisibility(View.GONE);
            fm.refresh(activity);
            displayFolder();
        }

    }


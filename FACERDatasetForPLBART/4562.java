	@Override
	public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        //BLog.e("FileExplore oncreateoptionsmenu");
        this.menu=menu;
		MenuInflater minflater = activity.getMenuInflater();
		minflater.inflate(R.menu.file_explore, menu);

        HashMap<String,FileItem> copyfiles=fm.getClipboardCopyFiles();
        //Log.e("COPY","copy files: "+copyfiles.size());
        MenuItem item = menu.findItem(R.id.action_paste);

        if(copyfiles!=null && !copyfiles.isEmpty()) {

            item.setVisible(true);
        } else {
            item.setVisible(false);
        }
        if(fm!=null) {
            if (fm.getCurrentDirectory().getAbsolutePath().equals(File.separator)) {
                Fab.hide();
            } else {
                Fab.show();
            }
        }
	}


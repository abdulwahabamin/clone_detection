	public void refreshData() {


        if(fm.getCurrentDirectory().getAbsolutePath().equals(File.separator)) {
            Fab.hide();
        } else {
            Fab.show();
        }


        //fm.readDirectory(activity);

		loading.setVisibility(View.GONE);
		fm.refresh(activity);
		displayFolder();


	}


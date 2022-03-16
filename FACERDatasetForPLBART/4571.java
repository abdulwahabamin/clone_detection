		@Override
		public void onClick(View arg1) {
            if(fm.isCurrentDirImages()) {
                State.setFolderPosition(fm.getCurrentDirectory().getAbsolutePath(), listImages.getFirstVisiblePosition());
            } else {
                State.setFolderPosition(fm.getCurrentDirectory().getAbsolutePath(), list.getFirstVisiblePosition());
            }

			fm.goUpDirectory(activity);
            refreshData();
		}


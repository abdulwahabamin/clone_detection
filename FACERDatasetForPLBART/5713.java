		@Override
		protected void onPostExecute(Integer result) {
			switch (result) {
			case success:
				activity.refreshList();
				if(deletedFileIsDirectory){
					Toast.makeText(activity, R.string.folder_deleted,Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(activity, R.string.file_deleted,Toast.LENGTH_SHORT).show();
				}
				break;
			case err_deleting_folder:
				Toast.makeText(activity,getString(R.string.error_deleting_folder,
						errorFile.getAbsolutePath()), Toast.LENGTH_LONG).show();
				break;
			case err_deleting_child_file:
				Toast.makeText(activity,getString(R.string.error_deleting_child_file,
						errorFile.getAbsolutePath()),Toast.LENGTH_SHORT).show();
				break;
			case err_deleting_file:
				Toast.makeText(activity,getString(R.string.error_deleting_file,
						errorFile.getAbsolutePath()), Toast.LENGTH_LONG).show();
				break;
			}
		}


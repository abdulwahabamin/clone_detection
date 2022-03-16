	protected Boolean doInBackground(ArrayList<File>... params) {
		
		ArrayList<File> sourceFiles = new ArrayList<File>();
		sourceFiles.addAll(params[0]);
		try {
			for (int i = 0; i < sourceFiles.size(); i++) {
				
				File destination = new File(path + "/", sourceFiles.get(i).getName());
				Log.d("current drectory", destination.getAbsolutePath());
				
				
				copyDirectory(sourceFiles.get(i), destination);
				publishProgress((int) ((i / (float) sourceFiles.size() * 100)));
			}
		} catch (IOException e) {
			Log.e("check", "Could not write file " + e.getMessage());
			return false;
		}
		return true;
	}


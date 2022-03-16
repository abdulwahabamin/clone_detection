	protected Boolean doInBackground(List<String>... params) {

		List<String> sourceFiles = new ArrayList<String>();
		sourceFiles.addAll(params[0]);
		for (int i = 0; i < sourceFiles.size(); i++) {
			deleteRecursive(new File(sourceFiles.get(i)));
			publishProgress((int) ((i / (float) sourceFiles.size() * 100)));
		}
		return true;
	}


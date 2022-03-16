	private void copy(File oldFile, File newFile) {
		int toast = 0;
		
		try {
			FileInputStream input = new FileInputStream(oldFile);
			FileOutputStream output = new FileOutputStream(newFile);
		
			byte[] buffer = new byte[COPY_BUFFER_SIZE];
			
			while (true) {
				int bytes = input.read(buffer);
				
				if (bytes <= 0) {
					break;
				}
				
				output.write(buffer, 0, bytes);
			}
			
			output.close();
			input.close();
			
			toast = R.string.file_copied;
			refreshList();
			
		} catch (Exception e) {
			toast = R.string.error_copying_file;
		}
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}


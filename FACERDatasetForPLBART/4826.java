	public FileCreateTask(String filepath, String filename) {
		this.path=filepath;
		this.filename=filename;
		if(ensureDirectory(path)) {
			File f= new File(path+ File.separator+filename);
			if(!f.exists()) {
				try {
					f.createNewFile();
				} catch(Exception e) {

				}
				
			}
			if(!f.exists()) {
				status=STATUS_CREATE_FAILED;
				statusMessage="Problem creating file, check storage is enabled";
			} else {
				status=STATUS_CREATE_OK;
				statusMessage="File created ok";
				file=f;
			}
		} else {
			status=STATUS_CREATE_FAILED;
			statusMessage="Problem creating file, check storage is enabled";
		}
		
	}


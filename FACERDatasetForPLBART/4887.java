	private boolean EnsurePathAndFile() {
		boolean ok=true;
		File filedir = new File(path);
		if(!filedir.exists())
			ok=filedir.mkdirs();
		if(ok) {
			File file = new File(path+ File.separator+filename);
			try {
			if(!file.exists())
				file.createNewFile();
			} catch(IOException e) {
				BLog.add("EnsurePathAndFile", e);
			}
			
			ok=(file.exists() && file.canWrite());
			if(!ok) {
				this.status=STATUS_WRITE_FAILED;
				this.statusMessage="Write disabled, ensure the device is not mounted";
			}
		} else {
			this.status=STATUS_WRITE_FAILED;
			this.statusMessage="No storage card found, unable to access data";
		}
		return ok;
	}


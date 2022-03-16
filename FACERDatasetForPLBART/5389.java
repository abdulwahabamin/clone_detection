	public void delete(String completePath){
		try {
			File f = new File(completePath);
			File[] files = f.listFiles();
			if (files != null) {
				for (File file : files) {
					delete(file.toString());
				}
			}
			f.delete();
		}catch (Exception e){
			e.printStackTrace();
		}
	}


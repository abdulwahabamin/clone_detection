	public static boolean writeBytesToDisk(String filePath, byte[] btyes) {
		try {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		bos.write(btyes);
		bos.flush();
		bos.close();
		return true;
		} catch(Exception e) {}
		return false;
	}


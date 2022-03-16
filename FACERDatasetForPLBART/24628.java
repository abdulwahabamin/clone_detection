	/**
	 * read the name and size of mp3 in the content
	 */
	public List<MP3Info> getMP3Files(String path) {
		List<MP3Info> list = new ArrayList<MP3Info>();
		File file = new File(SDCardRoot + File.separator + path);
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.getName().endsWith("mp3")) {
				MP3Info info = new MP3Info();
				info.setMp3Name(f.getName());
				info.setMp3Size(f.length() + "");
				list.add(info);
			}
		}
		return list;
	}


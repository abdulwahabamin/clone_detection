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
				
				
				for(File f2:files){
					if(f2.getName().startsWith(info.getMp3Name().substring(0,info.getMp3Name().length()-3))&&f2.getName().endsWith("lrc")){
						info.setLrcName(f2.getName());
						info.setLrcSize(f2.length()+"");
					}
				}
				
				list.add(info);
			}
		}
		return list;
	}


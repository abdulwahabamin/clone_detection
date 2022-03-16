	private static void _getAllAlbumsInDirRecurive(File target, List<File> albums){
		if(target.isDirectory() && target.listFiles() != null){
			boolean hasSong = false;
			for(File f : target.listFiles()){
				if(Utils.isValidSongFile(f)){
					hasSong = true;
				}
				if(f.isDirectory()){
					_getAllAlbumsInDirRecurive(f, albums);
				}
			}
			if(hasSong){
				albums.add(target);
			}
		}
	}


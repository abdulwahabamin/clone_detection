    private static void _getAllSongsInDirRecursive(File target, List<File> songFiles){
        if(target != null && target.isDirectory()) {
            if (target.listFiles() != null) {
				List<File> songsInDir = new ArrayList<>();
                for (File f : target.listFiles()) {
                    if (f.isFile() && isValidSongFile(f)) {
                        songsInDir.add(f);
                    } else {
                        _getAllSongsInDirRecursive(f, songFiles);
                    }
                }
				Collections.sort(songsInDir, Utils.songFileComparator);
				songFiles.addAll(songsInDir);
            }
        }
    }


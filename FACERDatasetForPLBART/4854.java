	public static int getFoldersRIcon(final int InderFileCategory) {
		int cat=R.drawable.f_folder;
		switch (InderFileCategory) {
			case Files.CAT_IMAGE:
				cat=R.drawable.f_folder_pics;
				break;
			case Files.CAT_DOCUMENT:
				cat=R.drawable.f_folder_docs;
				break;
			case Files.CAT_SOUND:
				cat=R.drawable.f_folder_music;
				break;
			case Files.CAT_VIDEO:
				cat=R.drawable.f_folder_videos;
				break;
			case Files.CAT_TEXTFILE:
				cat=R.drawable.f_folder_txt;
				break;
		}
		return cat;
	}


	public static Comparator<File> getForDirectory(int comparator, boolean ascending){
		switch(comparator){
		case NAME: return new NameComparator(ascending);
		case SIZE: return new NameComparator(ascending); //Not a bug! Getting directory's size is verry slow
		case LAST_MODIFIED: return new LastModifiedComparator(ascending);
		default: return null;
		}
	}


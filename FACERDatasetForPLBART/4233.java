	private static String getResultText(int index, String term, String searchText) {
		StringBuilder sb=new StringBuilder();
		int st=index-10;
		if(st<0)
			st=0;
		int se=index+40;
		if(se>searchText.length()-1)
			se=searchText.length();
		sb.append(searchText.substring(st, index));
		sb.append(term);
		sb.append(searchText.substring(index+term.length(), se));
		return sb.toString();
		
	}


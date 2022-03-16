	public SearchTask(String name_to_search)
	{
		pattern = Pattern.compile(
			name_to_search,
			Pattern.CASE_INSENSITIVE | Pattern.LITERAL
		);
	}


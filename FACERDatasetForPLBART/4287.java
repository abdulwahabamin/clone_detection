	/**
	 * @return the names of all ciphers registered; can be empty if no ciphers
	 * have been registered so far
	 */
	public static String[] getCipherNames()
	{
		String[] result;
		
		synchronized(_cphMks)
		{
			Vector<String> lst = new Vector<String>();
			lst.addAll(_cphMks.keySet());
			Collections.sort(lst);
			result = lst.toArray(new String[lst.size()]);
		}
		
		return result;
	}


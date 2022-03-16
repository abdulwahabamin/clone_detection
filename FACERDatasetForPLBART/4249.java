	private static void LimitSizeForAdd() {
		try {
			if(E.data.length()>MAX_SIZE)
				E.data.remove(0);
		} catch(Exception e){}
	}


	public int getBooleanInt(String KEY_) {
		if(bean.optBoolean(KEY_))
			return 1;
		return 0;
		//return 0.0D;
	}


	public static BriefSettings getSettings() {
		if(Validator.isValidCaller())
            return DB.settings;
        else
            return null;
	}


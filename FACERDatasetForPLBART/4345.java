	public static boolean Save() {
		if(DB.isLoaded) {
		try {
            //Log.e("SAVE", "SETTINGS: " + DB.settings.getBean().toString());
            //Validator.logCaller();
            //BLog.e("SAVE-SET","********************************************!!!!!    -- "+DB.settings.getString(BriefSettings.STRING_STYLE_FONT_FACE));
			fwt=new FileWriteTask(Files.HOME_PATH_APP, Files.FILENAME_GENERAL_SETTINGS, DB.settings.getBean().toString());
			return fwt.WriteSecureToSd();

		} catch(Exception e) {
			//Log.e("SAVE",e.getMessage());
			
		}
		}
		return false;
	}


	/**
	 * Return a resource icon based on the current theme.
	 * If the theme is LIGHT_THEME, return an icon resource with the same file name.
	 * If the theme is DARK_THEME, return an icon resource with "_light" appended
	 * to the file name. Note that the actual theme that is applied and the suffix
	 * of the file name are flipped: DARK_THEME uses "xxx_light.png" while LIGHT_THEME
	 * uses "xxx.png".
	 */
	public static int getIcon(Context context, String iconName) {
		
		int resourceID = 0;
		mApp = (Common) context.getApplicationContext();
		
		if (!iconName.equals("")) {
				
            //We're using "cloud" and "pin" in the settings page so we don't want them to be affected by the player color.
            if (iconName.equals("cloud_settings") || iconName.equals("pin_settings") || iconName.equals("equalizer_settings")) {
                if (iconName.equals("cloud_settings")) {
                    iconName = "cloud";
                } else if (iconName.equals("pin_settings")) {
                    iconName = "pin";
                } else if (iconName.equals("equalizer_settings")) {
                    iconName = "equalizer";
                }

                if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                    resourceID = context.getResources().getIdentifier(iconName + "_light", "drawable", context.getPackageName());
                } else {
                    resourceID = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());
                }

            } else {

                if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                    resourceID = context.getResources().getIdentifier(iconName + "_light", "drawable", context.getPackageName());
                } else {
                    resourceID = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());
                }

            }
			
		}
		
		return resourceID;
		
	}


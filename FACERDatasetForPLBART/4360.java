    public Fragment getItem(int position) {
    	Fragment f=null;
    	//View view=null;
    	switch(position) {
    		case 0: 
    			f=new SettingsGeneralFragment();
    			break;
    		case 1:
    			f=new SettingsHelpFragment();
    			break;
            case 2:
                f=new SettingsAboutFragment();
                break;

    	}

        return f;
    }


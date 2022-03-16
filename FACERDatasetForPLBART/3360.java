    public static InputMethodInfo getKeyboardInput(Activity activity) {
    	
    	String id = Settings.Secure.getString(
    			   activity.getContentResolver(), 
    			   Settings.Secure.DEFAULT_INPUT_METHOD
    			);
    	
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        List<InputMethodInfo> mInputMethodProperties = imm.getEnabledInputMethodList();

        final int N = mInputMethodProperties.size();

        for (int i = 0; i < N; i++) {

            InputMethodInfo imi = mInputMethodProperties.get(i);

            if (imi.getId().equals(Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD))) {

                //imi contains the information about the keyboard you are using
                return imi;
            }
        }
        return null;
    }


    /**
     * Method that reads the system properties
     */
    private static void readSystemProperties() {
        try {
            String propsFile =
                    getInstance().getApplicationContext().getString(R.string.system_props_file);
            Properties props = new Properties();
            props.load(new FileInputStream(new File(propsFile)));
            sSystemProperties = props;
        } catch (Throwable e) {
            Log.e(TAG,
                    "Failed to read system properties.", e); //$NON-NLS-1$
        }
    }


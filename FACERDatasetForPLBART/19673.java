    /**
     * This will initialize an instance of the SecurePreferences class
     * @param context your current context.
     * @param preferenceName name of preferences file (preferenceName.xml)
     * @param secureKey the key used for encryption, finding a good key scheme is hard. 
     * Hardcoding your key in the application is bad, but better than plaintext preferences. Having the user enter the key upon application launch is a safe(r) alternative, but annoying to the user.
     * @param encryptKeys settings this to false will only encrypt the values, 
     * true will encrypt both values and keys. Keys can contain a lot of information about 
     * the plaintext value of the value which can be used to decipher the value.
     * @throws SecurePreferencesException
     */
    public Base64SharedPreferences(Context context, String preferenceName, String secureKey, boolean encryptKeys) throws SecurePreferencesException {
        try {
                this.writer = Cipher.getInstance(TRANSFORMATION);
                this.reader = Cipher.getInstance(TRANSFORMATION);
                this.keyWriter = Cipher.getInstance(KEY_TRANSFORMATION);

                initCiphers(secureKey);

                this.preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

                this.encryptKeys = encryptKeys;
        }
        catch (GeneralSecurityException e) {
                throw new SecurePreferencesException(e);
        }
        catch (UnsupportedEncodingException e) {
                throw new SecurePreferencesException(e);
        }
    }


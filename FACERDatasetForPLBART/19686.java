    protected String decrypt(String securedEncodedValue) {
        byte[] securedValue = Base64.decode(securedEncodedValue, Base64.NO_WRAP);
        byte[] value = convert(reader, securedValue);
        try {
                return new String(value, CHARSET);
        }
        catch (UnsupportedEncodingException e) {
                throw new SecurePreferencesException(e);
        }
    }


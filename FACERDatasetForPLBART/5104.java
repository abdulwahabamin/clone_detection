    /**
     * Try to convert a string into a number, boolean, or null. If the string
     * can't be converted, return the string. This is much less ambitious than
     * JSONObject.stringToValue, especially because it does not attempt to
     * convert plus forms, octal forms, hex forms, or E forms lacking decimal
     * points.
     * @param string A String.
     * @return A simple JSON value.
     */
    public static Object stringToValue(String string) {
        if ("".equals(string)) {
            return string;
        }
        if ("true".equalsIgnoreCase(string)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(string)) {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(string)) {
            return JSONObject.NULL;
        }
        if ("0".equals(string)) {
            return new Integer(0);
        }

// If it might be a number, try converting it. If that doesn't work,
// return the string.

        try {
            char initial = string.charAt(0);
            boolean negative = false;
            if (initial == '-') {
                initial = string.charAt(1);
                negative = true;
            }
            if (initial == '0' && string.charAt(negative ? 2 : 1) == '0') {
                return string;
            }
            if ((initial >= '0' && initial <= '9')) {
                if (string.indexOf('.') >= 0) {
                    return Double.valueOf(string);
                } else if (string.indexOf('e') < 0 && string.indexOf('E') < 0) {
                    Long myLong = new Long(string);
                    if (myLong.longValue() == myLong.intValue()) {
                        return new Integer(myLong.intValue());
                    } else {
                        return myLong;
                    }
                }
            }
        }  catch (Exception ignore) {
        }
        return string;
    }


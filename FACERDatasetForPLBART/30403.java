    private static String object2String(Object object, String defaultString) {
        if (object instanceof String) {
            return TextUtils.isEmpty((String) object) ? defaultString : ((String) object).trim();
        } else {
            return object == null ? defaultString : object.toString();
        }
    }


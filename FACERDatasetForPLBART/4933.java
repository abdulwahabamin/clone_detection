    /**
     * Convert a JSONObject into a cookie list. A cookie list is a sequence
     * of name/value pairs. The names are separated from the values by '='.
     * The pairs are separated by ';'. The characters '%', '+', '=', and ';'
     * in the names and values are replaced by "%hh".
     * @param jo A JSONObject
     * @return A cookie list string
     * @throws JSONException
     */
    public static String toString(JSONObject jo) throws JSONException {
        boolean      b = false;
        Iterator     keys = jo.keys();
        String       string;
        StringBuffer sb = new StringBuffer();
        while (keys.hasNext()) {
            string = keys.next().toString();
            if (!jo.isNull(string)) {
                if (b) {
                    sb.append(';');
                }
                sb.append(Cookie.escape(string));
                sb.append("=");
                sb.append(Cookie.escape(jo.getString(string)));
                b = true;
            }
        }
        return sb.toString();
    }


    /**
     * 转�?�一个或多个汉字
     *
     * @param str
     * @return
     */
    public String convertAll(String str) {
        String result = "";
        String strTemp = null;
        for (int j = 0; j < str.length(); j++) {
            strTemp = str.substring(j, j + 1);
            int ascii = getChsAscii(strTemp);
            if (ascii > 0 && ascii < 160) {
                result += String.valueOf((char) ascii);
            } else {
                for (int i = (pyvalue.length - 1); i >= 0; i--) {
                    if (pyvalue[i] <= ascii) {
                        result += pystr[i];
                        break;
                    }
                }
            }
        }
        return result;
    }


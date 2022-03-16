    public static String delPosOfString(String str, int[] pos) {
        StringBuffer sb = new StringBuffer(str);
        for(int i = 0 ; i < pos.length;i++) {
            sb.deleteCharAt(pos[i]);
        }
        return sb.toString();
    }


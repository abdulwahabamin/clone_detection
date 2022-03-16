    /**
     * �?机生�?字符串(nonce)
     *
     * @return �?机字符串
     */
    private static String randomStr(int length) {
        //生�?字符串从此�?列中�?�
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


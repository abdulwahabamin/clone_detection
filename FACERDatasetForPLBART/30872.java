    public static String bytesToMd5String(byte[] bytes) {
        String resultString;
        try {
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(bytes);
            resultString = bytesToHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            resultString = String.valueOf(bytes.hashCode());
        }

        return  resultString;
    }


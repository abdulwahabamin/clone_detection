    private int getChsAscii(String chs) {
        int asc = 0;
        try {
            byte[] bytes = chs.getBytes("gb2312");
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) { // 错误
                // log
                throw new RuntimeException("illegal resource string");
                // System.out.println("error");
            }
            if (bytes.length == 1) { // 英文字符
                asc = bytes[0];
            }
            if (bytes.length == 2) { // 中文字符
                int hightByte = 256 + bytes[0];
                int lowByte = 256 + bytes[1];
                asc = (256 * hightByte + lowByte) - 256 * 256;
            }
        } catch (Exception e) {
            System.out
                    .println("ERROR:ChineseSpelling.class-getChsAscii(String chs)"
                            + e);
            // e.printStackTrace();
        }
        return asc;
    }


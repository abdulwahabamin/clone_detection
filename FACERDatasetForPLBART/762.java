    /**
     * 将�??六进制字符转�?��?一个整数
     *
     * @param ch
     *            �??六进制char
     * @param index
     *            �??六进制字符在字符数组中的�?置
     * @return 一个整数
     * @throws RuntimeException
     *             当ch�?是一个�?�法的�??六进制字符时，抛出�?行时异常
     */
    protected static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch
                    + " at index " + index);
        }
        return digit;
    }


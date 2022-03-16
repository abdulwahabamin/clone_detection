    /**
     * 计算CRC8校验值
     *
     * @param data   数�?�
     * @param offset 起始�?置
     * @param len    长度
     * @return 校验值
     */
    public static byte calcCrc8(byte[] data, int offset, int len) {
        return calcCrc8(data, offset, len, (byte) 0);
    }


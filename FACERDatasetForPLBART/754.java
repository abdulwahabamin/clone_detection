    /**
     * 计算CRC8校验值
     *
     * @param data   数�?�
     * @param offset 起始�?置
     * @param len    长度
     * @param preval 之�?的校验值
     * @return 校验值
     */
    public static byte calcCrc8(byte[] data, int offset, int len, byte preval) {
        byte ret = preval;
        for (int i = offset; i < (offset + len); ++i) {
            ret = crc8_tab[(0x00ff & (ret ^ data[i]))];
        }
        return ret;
    }


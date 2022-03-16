    /**
     * 计算数组的CRC8校验值
     *
     * @param data 需�?计算的数组
     * @return CRC8校验值
     */
    public static byte calcCrc8(byte[] data) {
        return calcCrc8(data, 0, data.length, (byte) 0);
    }


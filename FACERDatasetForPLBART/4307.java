    public static byte[] makeOutputBuffer(int len, int extraLen)
    {
        byte[] result = new byte[len + extraLen];
        Arrays.fill(result, (byte) 0xcc);
        return result;
    }


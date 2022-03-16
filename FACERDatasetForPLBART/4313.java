    public static byte[] hexStrToBytes(String hex)
    {
    	int len = hex.length();
    	if (1 == (len & 1))
    	{
    		return null;
    	}
    	byte[] result = new byte[len >> 1];
    	int r = 0;
    	int pos = 0;
    	while (pos < len)
    	{
    		int nReg = 0;
    		for (int nI = 0; nI < 2; nI++)
    		{
    			nReg <<= 4;
    			char c = Character.toLowerCase(hex.charAt(pos++));
    			if ('0' <= c && '9' >= c)
    			{
    				nReg |= c - '0';
    			}
    			else if ('a' <= c && 'f' >= c)
    			{
    				nReg |= (c - 'a') + 10;
    			}
    			else
    			{
    				return null;
    			}
    		}
			result[r++] = (byte)nReg;
    	}
    	return result;
    }


    public static boolean arraysEquals(
    		byte[] a, int ofsA, byte[] b, int ofsB, int len)
	{
    	int end = ofsA + len;
    	while (ofsA < end)
    	{
    		if (b[ofsB++] != a[ofsA++])
    		{
    			return false;
    		}
    	}
    	return true;
	}


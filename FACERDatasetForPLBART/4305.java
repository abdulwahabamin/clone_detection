	public static void fillPattern123(byte[] buf, int ofs, int len)
	{
		int counter, end;
		
		counter = 0;
		end = ofs + len;
		while (ofs < end)
		{
			buf[ofs++] = (byte)counter++;
		}
	}


	public static boolean checkPattern123(byte[] buf, int ofs, int len)
	{
		int counter, end;
		
		counter = 0;
		end = ofs + len;
		while (ofs < end)
		{
			if (buf[ofs] != (byte)counter)
			{
				return false;
			}
			counter++;
			ofs++;
		}
		return true;
	}


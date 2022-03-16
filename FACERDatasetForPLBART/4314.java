	public static int hexDump(
		InputStream is,
		PrintStream ps,
		int maxRead,
		int bytesPerLine)
	{
		int read, chr, i, result;
		char[] pad;
		StringBuffer left, right;
		
		
		if (1 > bytesPerLine)
		{
			bytesPerLine = 1;
		}
		
		left = new StringBuffer();
		right = new StringBuffer();
		
		result = 0;
		
		for (read = 0, i = 0;;)
		{
			if (-1 != maxRead)
			{
				if (maxRead <= read)
				{
					break;
				}
			}
	
			try
			{
				if (-1 == (chr = is.read()))
				{
					break;	
				}
			}
			catch (IOException ioe)
			{
				break;
			}
			
			result++;

			if (0 < i++)
			{
				left.append(' ');
			}

			left.append(HEXTAB[chr >>> 4]);
			left.append(HEXTAB[chr & 0x0f]);

			right.append((chr < ' ') ? '.' : (char)chr);
			
			if (0 == (i % bytesPerLine))
			{
				ps.print(left.toString());
				ps.print("    ");
				ps.println(right.toString());
				
				left.setLength(0);
				right.setLength(0);
				
				i = 0;
			}
		}

		if (0 < i)
		{
			pad = new char[((bytesPerLine - i) * 3) + 4];
			Arrays.fill(pad, ' ');
		
			ps.print(left.toString());
			ps.print(pad);
			ps.println(right.toString());
		}
		
		return result;
	}


	public boolean copyFile(File source_file, File dest_file)
	{
		try
		{
			BufferedOutputStream output_stream = new BufferedOutputStream(
				new FileOutputStream(dest_file)
			);
			if(source_file.length() > 0)
			{
				BufferedInputStream input_stream = new BufferedInputStream(
					new FileInputStream(source_file)
				);
				byte[] buffer = new byte[BUFFER_SIZE];
				int num_of_bytes_read;
				do
				{
					num_of_bytes_read = input_stream.read(buffer, 0, BUFFER_SIZE);
					if(num_of_bytes_read > -1)
						output_stream.write(buffer, 0, num_of_bytes_read);
				}
				while(num_of_bytes_read > -1);
				input_stream.close();
				output_stream.flush();
			}
			output_stream.close();
			if(move_files) return source_file.delete();
			else return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


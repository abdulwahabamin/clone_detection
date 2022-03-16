	public static void writeToFile(String filePath, String content) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(content);
			out.close();
		} catch (IOException e) {
		}
	}


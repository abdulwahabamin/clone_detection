	/**
	 * д��һ�������л��Ķ���
	 * 
	 * @param obj
	 */
	public void writeObject(Object obj) {
		try {
			outStream.flush();
			outStream.writeObject(obj);
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


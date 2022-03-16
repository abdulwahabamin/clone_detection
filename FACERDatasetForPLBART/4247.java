	public static List<SearchPacket> getHistory() {
		List<SearchPacket> hist = new ArrayList<SearchPacket>();
		for(int i=E.data.length()-1;i>=0; i--) {
			try {
				hist.add((SearchPacket) E.data.get(i));
			} catch(Exception e){}
		}
		return hist;
	}


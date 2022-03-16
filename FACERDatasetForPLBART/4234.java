	private static ArrayList<String> getWords(String s) {
		ArrayList<String> fwords=new ArrayList<String>();
		//ArrayList<String> f=new ArrayList<String>();
		String[] tmp = s.split(",");
		if(tmp!=null) {
			for(int i=0; i<tmp.length; i++) {
				String[] etmp = tmp[i].split("\\s");
				if(etmp!=null) {

					for(int j=0; j<etmp.length; j++) {
						if(etmp[j].length()>1)
							fwords.add(etmp[j]);
					}
				}
			}
		}
		return fwords;
	}


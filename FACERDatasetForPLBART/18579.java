	public static boolean checkIfAllElementsEqual(ArrayList<String> list) {
		
		if (list.size()!=0) {
			String firstElement = list.get(0);
			
			for (int i=0; i < list.size(); i++) {
				if (!firstElement.equals(list.get(i))) {
					return false;
				}
				
			}
			
			return true;
		}
		
		return false;
		
	}


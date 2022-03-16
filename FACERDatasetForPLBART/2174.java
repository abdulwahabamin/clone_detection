	public int compare(Object o1, Object o2) {
		IconifiedText it1 = (IconifiedText) o1;
		IconifiedText it2 = (IconifiedText) o2;

	    String s1 = it1.getText();
	    String s2 = it2.getText();
	    return s1.toLowerCase().compareTo(s2.toLowerCase());
	  }


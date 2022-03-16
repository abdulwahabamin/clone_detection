	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equals("resource")){
			infos.add(mp3Info);
		}
		tagName="";
	}


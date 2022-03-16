	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		this.tagName=localName;
		
		if(tagName.equals("resource")){
			mp3Info=new MP3Info();
		}
		
	}


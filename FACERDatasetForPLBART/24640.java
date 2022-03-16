	public List<Queue> process(InputStream inputStream){
	
		Queue<Long> timeMills=new LinkedList<Long>(); //store the time stamps
		Queue<String> messages=new LinkedList<String>();//store the lrc information
		
		List<Queue> queues=new ArrayList<Queue>(); //store this two queues
		
		try{
			
			InputStreamReader is=new InputStreamReader(inputStream,"GB2312");
			BufferedReader br=new BufferedReader(is);
			String temp=null;
			int i=0;
			
			Pattern p=Pattern.compile("\\[([^\\]]+)\\]");
			String result=null;
			boolean b=true;
			while((temp=br.readLine())!=null){
				i++;
				Matcher matcher=p.matcher(temp);
				if(matcher.find()){
					
					if(result!=null){
						messages.add(result);
					}
					
					String timeStr=matcher.group();
					Long timeMill=time2Long(timeStr.substring(1, timeStr.length()-1));
					if(b){
						timeMills.offer(timeMill);
					}
					String msg=temp.substring(10);
					result=msg+"\n";
					
				}else{
					result=result+temp+"\n";
				}
			}
			messages.add(result);
			
			queues.add(timeMills);
			queues.add(messages);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return queues;
	}


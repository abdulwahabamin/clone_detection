	private List<Integer> getAvailableFrequencies() {
		if (availableFrequencies != null)
			return availableFrequencies;
		else {
			BufferedReader in = null;
			try {
				Process process;
				// Reads the CPU available frequencies from
				// /sys/devices/system/cpu/cpu0/cpufreq/scaling_available_frequencies
				process = Runtime.getRuntime().exec(
						"cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_available_frequencies");
				in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				ArrayList<Integer> frequencies = new ArrayList<Integer>();
				String line;
				while ((line = in.readLine()) != null) {
					String[] lines = line.split(" ");
					for (int i = 0; i < lines.length; i++) {
						try {
							Integer freq = new Integer(lines[i].trim());
							frequencies.add(freq);
						} catch (NumberFormatException e) {
							Log.w(e.getClass().getName(), "Error parsing a value of CPU frequency");
						}
					}
				}
				if (frequencies.isEmpty())
					return null;
				else {
					availableFrequencies = frequencies;
					return frequencies;
				}
			} catch (Exception e) {
				Log.e(e.getClass().getName(), e.getMessage(), e);
				return null;
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (IOException e) {
					Log.e(e.getClass().getName(), e.getMessage(), e);
				}
			}
		}

	}


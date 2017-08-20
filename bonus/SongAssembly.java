package asm;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This is an algorithm to convert musical notes to Sequence8086 program.
 * 
 * @author bruna
 *
 */
public class SongAssembly {

	private static Map<String, Integer> notes;

	public static void main(String[] args) {
		notes = new HashMap<>();
		notes.put("C5", 523);
		notes.put("C#5/Db5", 554);
		notes.put("D5", 587);
		notes.put("D#5/Eb5", 622);
		notes.put("E5", 659);
		notes.put("F5", 698);
		notes.put("F#5/Gb5", 739);
		notes.put("G5", 783);
		notes.put("G#5/Ab5", 830);
		notes.put("A5", 880);
		notes.put("A5#/B5b", 932);
		notes.put("B5", 987);
		notes.put("C6", 1046);
		notes.put("C6", 1046);
		notes.put("C#6/Db6", 1108);
		notes.put("D6", 1174);
		notes.put("D#6/Eb6", 1244);
		notes.put("E6", 1318);

		System.out.println(get("D5"));

	}

	private static String get(String param) {
		return "MACRO_INITIALIZE_8253_TIMER0 00H," + 0
				+ String.valueOf(Integer.toHexString(convert(notes.get(param)))).toUpperCase() + "H ;" + param + "\n"
				+ "CALL DELAY";
	}

	private static int convert(int note) {
		return 0 + Math.round(100000 / note);
	}

}

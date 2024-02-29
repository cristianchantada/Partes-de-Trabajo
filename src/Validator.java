import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.cristian.partes.PartesMain.verMensaje;

public class Validator {

	public static boolean nifValidator(String nif) {

		String nifRegex = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$|^[xyzXYZ]\\d{7}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";
		Pattern nifPattern = Pattern.compile(nifRegex);
		Matcher nifMatcher = nifPattern.matcher(nif);

		if (!nifMatcher.matches()) {
			verMensaje("Su DNI no contiene un formato válido, por favor, inténtelo de nuevo");
			return false;
		} else {
			if (!validateNifAlgorithm(nif)) {
				verMensaje("Su NIF no contiene un formato válido, por favor, inténtelo de nuevo");
				return false;
			}
		}
		return true;
	}

	public static boolean emailValidator(String email) {

		String emailRegex = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(email);

		if (!emailMatcher.matches()) {
			verMensaje("Su EMAIL no contiene un formato válido, por favor, inténtelo de nuevo");
			return false;
		}
		return true;
	}

	public static boolean phoneValidator(String phone) {

		String phoneRegex = "\\d{9}";
		Pattern phonePattern = Pattern.compile(phoneRegex);
		Matcher phoneMatcher = phonePattern.matcher(phone);

		if (!phoneMatcher.matches()) {
			verMensaje("Su TELÉFONO no contiene un formato válido, por favor, inténtelo de nuevo");
			return false;
		}
		return true;
	}

	public static boolean validateNifAlgorithm(String nif) {
		nif = nif.replaceAll("\\s", "").replaceAll("-", "");
		String[] lettersTable = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
				"V", "H", "L", "C", "K", "E" };

		if (nif.length() > 0) {
			if (nif.charAt(0) == 'X') {
				char[] nifCharArray = nif.toCharArray();
				nifCharArray[0] = '0';
				nif = new String(nifCharArray);
			} else if (nif.charAt(0) == 'Y') {
				char[] nifCharArray = nif.toCharArray();
				nifCharArray[0] = '1';
				nif = new String(nifCharArray);
			} else if (nif.charAt(0) == 'Z') {
				char[] nifCharArray = nif.toCharArray();
				nifCharArray[0] = '2';
				nif = new String(nifCharArray);
			}

			String letter = nif.substring(8);
			String upperLetter = letter.toUpperCase();
			Integer number = Integer.parseInt(nif.substring(0, 8));
			int rest = number % 23;

			if (lettersTable[rest].equals(upperLetter)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
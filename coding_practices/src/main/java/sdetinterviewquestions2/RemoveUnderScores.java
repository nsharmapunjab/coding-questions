package sdetinterviewquestions2;

public class RemoveUnderScores {

	public static void main(String[] args) {
		
		// String str = "a____de___r";
		String str = "Amazon_w_e_b_services are___widely__used_acc__ro___ss_the_worl_d";
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && str.charAt(i) == '_') {
				newStr = newStr + " ";
			}
			if (str.charAt(i) == '_') {
				if (newStr.charAt(newStr.length() - 1) != ' ') {
					newStr = newStr + " ";
					continue;
				} else {
					continue;
				}

			} else {
				newStr = newStr + str.charAt(i);
			}
		}
		System.out.println(newStr);

	}

}

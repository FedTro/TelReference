package task.second;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Reference {

	private static Logger log = Logger.getLogger(Reference.class);
	private String namePattern = "[а-яА-я]*\\s[А-Я]\\.[А-Я]\\.";
	private HashMap<String, ArrayList<String>> book;

	private Scanner in;
	private PrintStream out;

	public Reference() {
		in = new Scanner(System.in);
		out = System.out;

		init();
	}

	private void init() {

		book = new HashMap<String, ArrayList<String>>(3);

		ArrayList<String> list = new ArrayList<String>();
		list.add("+8 800 2000 500");
		list.add("+8 800 200 600");
		book.put("Иванов И.И.", list);

		list = new ArrayList<String>();
		list.add("+8 800 2000 700");
		book.put("Петров П.П.", list);

		list = new ArrayList<String>();
		list.add("+8 800 2000 800");
		list.add("+8 800 2000 900");
		list.add("+8 800 2000 000");
		book.put("Сидоров С.С.", list);

	}

	/**
	 * Start point of the program.
	 */
	public int start() {

		log.info("Program is started");

		try {
			while (true) {

				out.println("Please enter a person name to show his tel. № or press 'Q' to exit\nName: ");
				String name = in.nextLine();
				log.debug("Name is '" + name + "'");

				if ("Q".equals(name)) {
					out.println("Program is finished");
					log.debug("'Q' key was pressed");
					break;
				}

				if (!checkName(name)) {
					out.println("ERROR: name must have format as 'Иванов И.И.'");
					continue;
				}

				showNumbers(name);

			}

			in.close();

		} catch (Exception exc) {
			log.error("Error was occured during program running", exc);
			return 1;
		}

		log.info("Program is finished");

		return 0;
	}

	/**
	 * 
	 * @param addr
	 *            Name is checked according to the regular expression template.
	 * @return true - Name is correct, false - Name is not correct.
	 */
	public boolean checkName(String name) {
		Pattern p = Pattern.compile(namePattern);
		Matcher m = p.matcher(name);
		return m.matches();

	}

	/**
	 * 
	 * @param name
	 *            Entered name of person
	 */
	public int showNumbers(String name) {

		int count = 0;

		if (book.containsKey(name)) {
			ArrayList<String> list = book.get(name);
			count = list.size();
			out.println("Person's telephone numbers:");
			for (String tel : list) {
				out.println("\t" + tel);
			}
		} else {
			out.println("There is not any user with name '" + name + "' in DB");
		}
		return count;

	}
}

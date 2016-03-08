package post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PostOffice {
	private List<MailObject> repo = new ArrayList<>();
	private Set<Postman> staff = new HashSet<>();
	private Map<LocalDateTime, List<MailObject>> archive = new TreeMap<>();

	public void addPostman(Postman p) throws PostOfficeException {
		if (p != null)
			staff.add(p);
		else
			throw new PostOfficeException("Nqma takyv poshtalion");
	}

	public void addMailObject(MailObject m) throws PostOfficeException {
		if (m != null) {
			synchronized (archive) {
				if (!archive.containsKey(LocalDateTime.now()))
					archive.put(LocalDateTime.now(), new ArrayList<>());
				archive.get(LocalDateTime.now()).add(m);
			}
			synchronized (repo) {
				repo.add(m);
			}
		} else {
			throw new PostOfficeException("Nqma takyv obekt!");
		}
	}

	public int getNumberOfMailObjects() {
		return repo.size();
	}

	public void addMailObject(List<Letter> letters) throws PostOfficeException {
		if (letters != null) {
			synchronized (archive) {
				if (!archive.containsKey(LocalDateTime.now()))
					archive.put(LocalDateTime.now(), new ArrayList<>());
				archive.get(LocalDateTime.now()).addAll(letters);
			}
			synchronized (repo) {
				repo.addAll(letters);
			}
		} else {
			throw new PostOfficeException("Nqma takyv obekt!");
		}
	}

	public List<MailObject> takeMails(int number) throws PostOfficeException {
		if (number > 0) {
			List<MailObject> list = new ArrayList<>();
			if (number > repo.size()) {
				number = repo.size();
			}
			for (MailObject mailObject : repo) {
				list.add(mailObject);
				repo.remove(mailObject);
			}
			return list;
		} else {
			throw new PostOfficeException("Nekorektno chislo!");

		}
	}

	class Spravki {
		private static final double PERCENT = 100.0;

		public void getAllPratki(LocalDate date) throws PostOfficeException {
			if (archive.containsKey(date)) {
				List<MailObject> list = archive.get(date);
				for (MailObject mailObject : list) {
					System.out.println(mailObject);
				}
			} else {
				throw new PostOfficeException("Nqma takyv zapis");
			}
		}

		public double getProcentOfLetters() {
			List<MailObject> list = archive.get(LocalDate.now());
			int letters = 0;
			for (MailObject mailObject : list) {
				if (mailObject instanceof Letter)
					letters++;
			}
			return (letters / getNumberOfMailObjects()) * PERCENT;
		}

		public double getProcentOfChupviteKoleti() {
			int koleti = 0;
			int chuplivi = 0;
			for (LocalDateTime date : archive.keySet()) {
				for (MailObject mailObject : archive.get(date)) {
					if (mailObject instanceof Kolet) {
						koleti++;
						if (((Kolet) mailObject).isChupliv()) {
							chuplivi++;
						}
					}
				}
			}
			return chuplivi / koleti;
		}
		
		public void printInfoForPostman(){
			List<Postman> poshtalioni = new ArrayList<>();
			Collections.sort(poshtalioni, (p1,p2) ->{
				return p1.getObraboteni() - p2.getObraboteni();
			});
			for (Postman postman : poshtalioni) {
				System.out.println(postman);
			}
		}

	}
	
	
}

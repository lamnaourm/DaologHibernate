import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dao.DaoEmploye;
import com.app.dao.IDao;
import com.app.hibernate.utils.HibernateUtils;
import com.app.models.Employe;

public class Main {

	public static void main(String[] args) {
		
		IDao<Employe> dao = new DaoEmploye();
		
		dao.save(new Employe(1,"EMPP11","ADD EMP","0678909"));
		
		System.out.println(dao.getAll().size());
		
	}

}

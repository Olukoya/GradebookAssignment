import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Grades;
import customTools.DBUtil;

 

public class Insert {

public static void insert(Grades user) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.persist(user);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void update(Grades user) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.merge(user);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void delete(Grades user) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.remove(emf.merge(user));
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
} 
}

public static Double average(Grades user){
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	TypedQuery<Double> q = emf.createQuery("select avg(g.grade) from Grades g",Double.class);
	Double avg = q.getSingleResult();
	
	return avg;
}

public static List<Grades>selectPost() {
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT g FROM Grades g";
	TypedQuery<Grades> q = emf.createQuery(qString, Grades.class);
	//q.setParameter("",username);
	//q.setParameter("",post);
	List <Grades> custs;
	try{
		custs = q.getResultList();
		if (custs==null || custs.isEmpty())
			custs = null;
	} finally {
		emf.close();
	}
	return custs;
}



}
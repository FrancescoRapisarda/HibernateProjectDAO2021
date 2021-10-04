package corsoAdecco.HibernateProjectDAO2021.models.crud;

import java.util.List;

public interface Dao<T> {		//Il Dao prende una tipologia generica T.

	 void insert(T t);
	 
	 T findById(int id);
	 
	 List<T> findAll();
	 
	 boolean delete(T t);
	 
	 boolean delete (int id);
	 
	 boolean update (T t);
	 
}

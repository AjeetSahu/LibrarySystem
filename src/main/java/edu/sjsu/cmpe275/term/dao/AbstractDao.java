package edu.sjsu.cmpe275.term.dao;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDao<PK extends Serializable, T> {
	
	private Class<T> persistentClass;
	
	@PersistenceContext(unitName = "CMPE275TERM")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public T findById(String id) {
		try{
			System.out.println("in abstract DAO+"+id);
			if(this.entityManager.find(this.persistentClass, id) != null){
				T entity = (T) this.entityManager.find(this.persistentClass, id);
				System.out.println("in abstract DAO+"+entity);	
				return entity;	
			}
		}
		catch(RollbackException e)
		{	
			System.out.println("Rollback Exception in findById");
			return null;
		}
		catch(Exception e){
			System.out.println(this.persistentClass.getName()+" not found! "+ e);
			return null;
		}
		return null;
	}
	
	/**
	 * @author Pratik
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery("from "+this.persistentClass.getName()).getResultList();
	}

	public T save(T entity) {
		try{ 
			System.out.println("I am in the save method..");
			this.entityManager.persist(entity);	
			return entity;
		}
		catch(Exception e){
			System.out.println("Exception occur while saving!");
			return null;
		}	
	}
	
	/**
	 * @author Pratik
	 * @param entity
	 * @return
	 */
	public T update(T entity) {
		T mergedEntity = this.entityManager.merge(entity);
		return mergedEntity;
	}
	
	/**
	 * @author Pratik
	 * @param id
	 * @return
	 */
	public String deleteById(PK id){
		try{
			T entity = this.findById(id.toString());
			if(entity != null){
				this.delete(entity);
				return "Deletion operation successfully performed";
			}else{
				return "Deletion operation failed";
			}
		}
		catch (NumberFormatException e) {
		    System.out.println("Exception while parsing id to string: "+e);
		    return "Deletion operation failed";
		}
	}
	
	/**
	 * @author Pratik
	 * @param entity
	 */
	public void delete(T entity){
		this.entityManager.remove(entity);
    }
	
	public void flush() {
		this.entityManager.flush();
	}
}

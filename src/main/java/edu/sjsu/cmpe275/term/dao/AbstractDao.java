package edu.sjsu.cmpe275.term.dao;

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
	
	public T findById(PK id) {
		int userid=0;
		try{
			 userid= Integer.parseInt(id.toString());
			if(this.entityManager.find(this.persistentClass, userid) != null){
				T entity = (T) this.entityManager.find(this.persistentClass, userid);
				return entity;	
			}
		}
		catch (NumberFormatException e) {
		    System.out.println("Exception while parsing id to string: "+e);
		}
		catch(RollbackException e)
		{	
			System.out.println("Rollback Exception in findById");
			return null;
		}
		catch(Exception e){
			System.out.println(this.persistentClass.getName()+" not found!");
			return null;
		}
		return null;
	}
	
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
	
	public T update(T entity) {
		T mergedEntity = this.entityManager.merge(entity);
		return mergedEntity;
	}
	
	public String deleteById(PK id){
		try{
			T entity = this.findById(id);
	      	this.delete(entity);
	      	return "Deletion operation successfully performed";
		}
		catch (NumberFormatException e) {
		    System.out.println("Exception while parsing id to string: "+e);
		    return "Deletion operation failed";
		}
	}

	public void delete(T entity){
		this.entityManager.remove(entity);
    }
	
	public void flush() {
		this.entityManager.flush();
	}
	
	public boolean checkById(PK id) {
		int userid = 0;
		try{
			userid= Integer.parseInt(id.toString());
			if(this.entityManager.find(this.persistentClass, userid) != null){
					return true;	
			}else{
				System.out.println("");
				System.out.println(this.persistentClass.getName()+" not found!");
				return false;
			}
		}
		catch (NumberFormatException e) {
		    System.out.println("Exception while parsing string to id: "+e);
		    return false;
		}
		catch(RollbackException e)
		{
			System.out.println("Rollback Exception in checkById");
			System.out.println(this.persistentClass.getName()+" not found!");
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(this.persistentClass.getName()+" not found!");
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAllIssuedBookByPatronId(PK id) {
		//int patronId=0;
		try{
			//patronId= Integer.parseInt(id.toString());
			 return this.entityManager.createNativeQuery("").getResultList();
		}
		catch (NumberFormatException e) {
		    System.out.println("Exception while parsing id to string: "+e);
		    return null;
		}
	}
}

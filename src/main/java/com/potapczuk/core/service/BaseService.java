package com.potapczuk.core.service;

import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T> {

	// TODO fix repo abstraction
//	protected JpaRepository<T, Serializable> repository;
//	
//	/*
//	 * (non-Javadoc)
//	 * @see org.springframework.data.repository.CrudRepository#findAll()
//	 */
//	public List<T> findAll()
//	{
//		return repository.findAll();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
//	 */
//	public List<T> findAll(Sort sort){
//		return repository.findAll(sort);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
//	 */
//	public <S extends T> List<S> save(Iterable<S> entities){
//		return repository.save(entities);
//	}
//
//	/**
//	 * Flushes all pending changes to the database.
//	 */
//	public void flush(){
//		repository.flush();
//	}
//
//	/**
//	 * Saves an entity and flushes changes instantly.
//	 * 
//	 * @param entity
//	 * @return the saved entity
//	 */
//	public T saveAndFlush(T entity){
//		return repository.saveAndFlush(entity);
//	}
//
//	/**
//	 * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear
//	 * the {@link javax.persistence.EntityManager} after the call.
//	 * 
//	 * @param entities
//	 */
//	public void deleteInBatch(Iterable<T> entities){
//		repository.deleteInBatch(entities);
//	}
//
//	/**
//	 * Deletes all entites in a batch call.
//	 */
//	public void deleteAllInBatch(){
//		repository.deleteAllInBatch();
//	}
//	
//	/**
//	 * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
//	 * 
//	 * @param pageable
//	 * @return a page of entities
//	 */
//	public Page<T> findAll(Pageable pageable){
//		return repository.findAll(pageable);
//	}
//	
//	/**
//	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
//	 * entity instance completely.
//	 * 
//	 * @param entity
//	 * @return the saved entity
//	 */
//	public <S extends T> S save(S entity){
//		return repository.save(entity);
//	}
//	
//	/**
//	 * Retrives an entity by its id.
//	 * 
//	 * @param id must not be {@literal null}.
//	 * @return the entity with the given id or {@literal null} if none found
//	 * @throws IllegalArgumentException if {@code id} is {@literal null}
//	 */
//	public T findOne(Long id){
//		return repository.findOne(id);
//	}
//
//	/**
//	 * Returns whether an entity with the given id exists.
//	 * 
//	 * @param id must not be {@literal null}.
//	 * @return true if an entity with the given id exists, alse otherwise
//	 * @throws IllegalArgumentException if {@code id} is {@literal null}
//	 */
//	public boolean exists(Long id){
//		return repository.exists(id);
//	}
//
//	/**
//	 * Returns all instances of the type with the given IDs.
//	 * 
//	 * @param ids
//	 * @return
//	 */
//	public Iterable<T> findAll(Iterable<Long> ids){
//		return repository.findAll(ids);
//	}
//
//	/**
//	 * Returns the number of entities available.
//	 * 
//	 * @return the number of entities
//	 */
//	public long count() {
//		return repository.count();
//	}
//
//	/**
//	 * Deletes the entity with the given id.
//	 * 
//	 * @param id must not be {@literal null}.
//	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
//	 */
//	public void delete(Long id){
//		repository.delete(id);
//	}
//
//	/**
//	 * Deletes a given entity.
//	 * 
//	 * @param entity
//	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
//	 */
//	public void delete(T entity){
//		repository.delete(entity);
//	}
//
//	/**
//	 * Deletes the given entities.
//	 * 
//	 * @param entities
//	 * @throws IllegalArgumentException in case the given {@link Iterable} is (@literal null}.
//	 */
//	public void delete(Iterable<? extends T> entities){
//		repository.delete(entities);
//	}
//
//	/**
//	 * Deletes all entities managed by the repository.
//	 */
//	public void deleteAll(){
//		repository.deleteAll();
//	}
}
